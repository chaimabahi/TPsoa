package org.learning.database.repository;

import org.learning.database.entity.TemperatureData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TemperatureRepository extends JpaRepository <TemperatureData , String > {

   public List <TemperatureData> findByTemperatureGreaterThan(float valmin) ;
}
