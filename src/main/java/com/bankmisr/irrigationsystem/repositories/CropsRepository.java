package com.bankmisr.irrigationsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankmisr.irrigationsystem.model.Crop;

public interface CropsRepository extends JpaRepository<Crop, Integer> {

	Optional<Crop> findByCropName(String cropName);

}
