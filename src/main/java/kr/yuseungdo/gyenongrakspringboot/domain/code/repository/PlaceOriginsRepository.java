package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.PlaceOrigins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceOriginsRepository extends JpaRepository<PlaceOrigins, Long> {
}