package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.AgriculturalCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgriculturalCategoryRepository extends JpaRepository<AgriculturalCategory, Long> {
}