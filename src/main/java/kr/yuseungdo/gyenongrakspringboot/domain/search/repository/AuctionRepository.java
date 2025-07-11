package kr.yuseungdo.gyenongrakspringboot.domain.search.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.search.model.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    @Query("SELECT COUNT(e) FROM Auction e")
    int countAll();
}
