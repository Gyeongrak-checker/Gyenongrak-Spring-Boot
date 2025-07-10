package kr.yuseungdo.gyenongrakspringboot.domain.search.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.search.model.entity.Auction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AuctionRepository extends Repository<Auction, Long> {
    @Query("SELECT COUNT(e) FROM Auction e")
    int countAll();

    void saveAll(List<Auction> auctionList);
}