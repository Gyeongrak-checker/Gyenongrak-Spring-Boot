package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductVariety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVarietyRepository extends JpaRepository<ProductVariety, Long> {
}