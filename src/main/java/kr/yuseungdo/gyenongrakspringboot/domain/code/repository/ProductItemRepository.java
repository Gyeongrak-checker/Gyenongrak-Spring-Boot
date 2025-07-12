package kr.yuseungdo.gyenongrakspringboot.domain.code.repository;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    boolean existsBy();
    List<ProductItem> findAllByVarietyCode(String code);
    Optional<ProductItem> findByCode(String code);

    @Query("""
    SELECT pi FROM ProductItem pi
    JOIN pi.variety v
    JOIN v.category c
    WHERE pi.code = :itemCode
      AND v.code = :varietyCode
      AND c.code = :categoryCode
""")
    Optional<ProductItem> findProductItemByCodes(
            @Param("itemCode") String itemCode,
            @Param("varietyCode") String varietyCode,
            @Param("categoryCode") String categoryCode
    );

}
