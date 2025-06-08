package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;


import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductVariety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductVarietyRepository extends JpaRepository<ProductVariety, Long> {
    List<ProductVariety> findAllByCategoryCode(String code);
}