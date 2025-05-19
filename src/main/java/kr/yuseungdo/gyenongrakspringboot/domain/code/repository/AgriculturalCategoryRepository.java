package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.AgriculturalCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgriculturalCategoryRepository extends JpaRepository<AgriculturalCategory, Long> {
}