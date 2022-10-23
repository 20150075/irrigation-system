package com.bankmisr.irrigationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankmisr.irrigationsystem.model.WaterPipe;

public interface PipeRepository  extends JpaRepository<WaterPipe, Integer>{

}
