package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;


import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductVariety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductVarietyRepository extends JpaRepository<ProductVariety, Long> {
    List<ProductVariety> findAllByCategoryCode(String largeCode);
    Optional<ProductVariety> findByCode(String code);
}