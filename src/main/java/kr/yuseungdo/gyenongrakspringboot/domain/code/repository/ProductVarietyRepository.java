package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.AgriculturalCategory;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductVariety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProductVarietyRepository extends JpaRepository<ProductVariety, Long> {
    List<ProductVariety> findAllByCode(String code);
}