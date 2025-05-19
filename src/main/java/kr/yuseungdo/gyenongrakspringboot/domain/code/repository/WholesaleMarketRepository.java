package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.WholesaleMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WholesaleMarketRepository extends JpaRepository<WholesaleMarket, Long> {
}