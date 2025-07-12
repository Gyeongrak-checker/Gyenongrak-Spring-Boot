package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.PlaceOrigins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceOriginsRepository extends JpaRepository<PlaceOrigins, Long> {
    boolean existsBy();
    Optional<PlaceOrigins> findByCode(String packageCode);
}