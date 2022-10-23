package com.bankmisr.irrigationsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.bankmisr.irrigationsystem.model.Plot;

public class WateringPlots {
	
	public void processNeededWateringPlots(List<Plot> plots)
	{
	 ExecutorService service = Executors.newFixedThreadPool(10);

     // Or un fixed thread number
     // The number of threads will increase with tasks
     // ExecutorService service = Executors.newCachedThreadPool(10);
     for (Plot o : plots) {
        // service.execute(new MyTask(o));
     }
	}
	

}
