package kr.yuseungdo.gyenongrakspringboot.domain.search.service;

import kr.yuseungdo.gyenongrakspringboot.domain.search.AuctionMapper;
import kr.yuseungdo.gyenongrakspringboot.domain.search.repository.AuctionRepository;
import kr.yuseungdo.gyenongrakspringboot.global.api.at.AtRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepository repository;
    private final AuctionMapper mapper;
    private final AtRequest atRequest;

    private final int MAX_COUNT = 10000;

    @Scheduled(cron = "*/10 * 0-23 * * *")
    private void fetchApi() {
        // DB에 몇개가 저장되어 있는가?
        int localCount = repository.countAll();

        int page = localCount / MAX_COUNT; // 현제 페이지
        if (page == 0) page = 1;
        int apiCount = Integer.MAX_VALUE;

//        ApiResponse<AuctionApiDto> response = atRequest.getAuction(page, MAX_COUNT);
//        List<AuctionApiDto> items = response.getItems();
//
//        for (int i = 0; i < 10; i++) {
//            AuctionApiDto dto = items.get(i);
//            log.info("dto : {}", dto.toString());
//
//            Auction entity = mapper.toEntity(dto);
//            repository.save(entity);
//        }


//
//        log.info("fetch api response: {}", entity);


//        while (localCount < apiCount) {
//            ApiResponse<AuctionApiDto> response = atRequest.getAuction(page, MAX_COUNT);
//            localCount += MAX_COUNT;
//            apiCount = response.getTotalCount();
//            page++;
//            repository.saveAll(response.getItems().stream().map(mapper::toEntity).toList());
//            break;
//        }
    }

    private void save() {

    }
}
