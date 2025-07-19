package kr.yuseungdo.gyenongrakspringboot.domain.search.service;

import kr.yuseungdo.gyenongrakspringboot.domain.search.AuctionMapper;
import kr.yuseungdo.gyenongrakspringboot.domain.search.model.dto.AuctionApiDto;
import kr.yuseungdo.gyenongrakspringboot.domain.search.model.entity.Auction;
import kr.yuseungdo.gyenongrakspringboot.domain.search.repository.AuctionRepository;
import kr.yuseungdo.gyenongrakspringboot.global.api.at.AtRequest;
import kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // 추가

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepository repository;
    private final AuctionMapper mapper;
    private final AtRequest atRequest;

    // 상수는 대문자로 표기하는 것이 관례입니다.
    private static final int BATCH_SIZE = 10000; // API 부하를 줄이기 위해 한 번에 가져오는 양을 조절하는 것이 좋습니다.

    /**
     * 10초마다 외부 API에서 경매 데이터의 다음 페이지를 가져와 DB에 저장합니다.
     */
    @Scheduled(initialDelay = 5000, fixedDelay = 10000) // 10초마다 실행 (테스트용) -> 실제 운영시는 "0 */10 * * * *" (10분마다) 등으로 변경
    @Transactional // 각 페이지 저장 작업을 하나의 트랜잭션으로 묶습니다.
    public void fetchAndSaveNextAuctionPage() {
        // 1. DB에 저장된 데이터 수를 기반으로 다음에 가져올 페이지 번호를 계산합니다.
        long totalCount = repository.count();
        int pageToFetch = (int) (totalCount / BATCH_SIZE) + 1;

        log.info("현재 데이터: {}개. API로부터 {} 페이지 데이터 동기화를 시도합니다.", totalCount, pageToFetch);

        // 2. 외부 API에서 해당 페이지의 데이터를 가져옵니다.
        List<AuctionApiDto> items = atRequest.getAuction(pageToFetch, BATCH_SIZE).getItems();

        // 3. 가져온 데이터가 없으면 모든 데이터를 가져온 것이므로 작업을 종료합니다.
        if (items == null || items.isEmpty()) {
            log.info("API로부터 더 이상 가져올 새로운 데이터가 없습니다. 동기화 작업을 중단합니다.");
            // 이 스케줄링을 동적으로 중지하고 싶다면 별도의 로직이 필요하지만,
            // 보통은 이렇게 로그만 남기고 다음 스케줄 주기까지 대기하는 것으로 충분합니다.
            return;
        }

        // 4. 가져온 데이터를 Entity로 변환하여 DB에 저장합니다.
        List<Auction> auctionsToSave = items.stream().map(mapper::toEntity).toList();
        repository.saveAll(auctionsToSave);

        log.info("성공적으로 {}개의 신규 데이터를 저장했습니다. (총 데이터: {})", items.size(), totalCount + items.size());
    }


    /**
     * 매일 자정(00:00)에 모든 경매 데이터를 삭제합니다.
     */
    @Scheduled(cron = "0 0 0 * * *") // 초 분 시 일 월 요일 -> 매일 0시 0분 0초에 실행
    @Transactional
    public void deleteAllAuctionsAtMidnight() {
        log.info("자정이 되어 모든 경매 데이터를 삭제합니다.");
        // deleteAll() 보다 deleteAllInBatch()가 대량의 데이터를 삭제할 때 훨씬 효율적입니다.
        repository.deleteAllInBatch();
        log.info("모든 경매 데이터 삭제 완료.");
    }
}