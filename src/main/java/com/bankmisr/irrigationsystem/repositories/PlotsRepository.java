package com.bankmisr.irrigationsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bankmisr.irrigationsystem.model.Plot;

@Repository
public interface PlotsRepository extends PagingAndSortingRepository<Plot, Integer>,JpaRepository<Plot, Integer>{
	@Modifying
	@Transactional
	@Query("Update  Plot p set p.crop.id=?1, p.soilTemperature=?2  where p.id=?3")
	public int updatePlot(int cropId, int soilTemp,int id);
	
	@Query("Select p from  Plot p where p.soilTemperature<=?1 and p.wateringIndicator<>'Y'")
	public List<Plot> getPlotsNeedWater(int soilTemp);

	@Modifying
	@Transactional
	@Query("Update  Plot p set p.wateringIndicator=?1 where p.id=?2")
	public void updatePlotWateringStatus(String ind, int id);
	
	@Modifying
	@Transactional
	@Query("Update  Plot p set p.wateringIndicator=?1, p.soilTemperature=?2  where p.id=?3")
	public int updateWateredPlotTemp(String ind, int soilTemp,int id);

	@Query("Select p from  Plot p where p.land.id=?1 ")
	public List<Plot> getLandPlots(int landId);
}
