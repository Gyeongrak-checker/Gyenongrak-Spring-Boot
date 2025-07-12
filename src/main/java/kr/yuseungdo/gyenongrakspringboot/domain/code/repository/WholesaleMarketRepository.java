package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.WholesaleMarket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WholesaleMarketRepository extends JpaRepository<WholesaleMarket, Long> {
    boolean existsBy();
    Optional<WholesaleMarket> findByCode(String code);
}