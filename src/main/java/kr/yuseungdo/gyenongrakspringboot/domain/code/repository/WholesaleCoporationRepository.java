package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.WholesaleCoporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WholesaleCoporationRepository extends JpaRepository<WholesaleCoporation, Long> {
}