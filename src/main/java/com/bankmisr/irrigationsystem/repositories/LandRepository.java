package com.bankmisr.irrigationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bankmisr.irrigationsystem.model.Land;

public interface LandRepository extends JpaRepository<Land, Integer> {

	@Query("Select l.totalArea from  Land l where l.id=?1 ")
	public int getLandArea(int landId);

}
