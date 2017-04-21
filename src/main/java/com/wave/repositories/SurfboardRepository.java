package com.wave.repositories;

import com.wave.models.Surfboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SurfboardRepository extends JpaRepository<Surfboard, Long>{
    Surfboard findByBrandAndModel(@Param("brand") String brand,  @Param("model") String model);
    List<Surfboard> findByMsrpBetween(@Param("low") BigDecimal low, @Param("high") BigDecimal high);
}
