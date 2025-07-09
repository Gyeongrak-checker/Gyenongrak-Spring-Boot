package kr.yuseungdo.gyenongrakspringboot.domain.search.service;

import kr.yuseungdo.gyenongrakspringboot.domain.search.AuctionMapper;
import kr.yuseungdo.gyenongrakspringboot.domain.search.model.dto.AuctionApiDto;
import kr.yuseungdo.gyenongrakspringboot.domain.search.repository.AuctionRepository;
import kr.yuseungdo.gyenongrakspringboot.global.api.at.AtRequest;
import kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

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
        long localCount = repository.countAll();
        long currentPage = localCount / MAX_COUNT;

        // OpenAPI에는 총 몇개가 존재하는가?
        ApiResponse<AuctionApiDto> auction = atRequest.getAuction(1, MAX_COUNT);

        long apiCount = auction.getTotalCount();
        long apiPage = apiCount / MAX_COUNT;


        // 얼마나 필요한가?
        long needCount = apiCount - localCount;
        long needPage = apiPage - currentPage;

        List<AuctionApiDto> items = auction.getItems();

        // 10,000개 초과라면 페이지로 받아야 한다.
        for(int i = 0; i < needCount - 1; i++) {

        }

        // DB에 저장한다.

        // 데이터가 중복되는게 있으면? - 필요한 만큼만 가져오자 얼마나 필요한지 이미 구했으니까



    }

}
