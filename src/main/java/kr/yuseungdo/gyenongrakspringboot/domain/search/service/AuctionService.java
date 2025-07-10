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
        int localCount = repository.countAll();
        int needCount = 0;
        while(needCount < MAX_COUNT) {

        }
    }
}