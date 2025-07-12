package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    boolean existsBy();
}
