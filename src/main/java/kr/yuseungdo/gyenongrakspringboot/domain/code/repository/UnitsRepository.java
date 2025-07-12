package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Units;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitsRepository extends JpaRepository<Units, Long> {
    boolean existsBy();
}
