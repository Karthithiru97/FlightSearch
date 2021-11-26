package com.flight.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.search.entity.Flight;
import com.flight.search.services.FlightService;



@RestController
public class FligthSearchController {
	
	@Autowired
	FlightService flightservice;
	
	@GetMapping("/flight/search")
    Flight[] search()
    {
	  return flightservice.findAll();
    }
	
	
	@PostMapping("/flights/bylocation/{loc}")
	List<Flight> searchbylocation(@PathVariable("loc") String loc)
	{
		Flight[] ff=flightservice.findAll();
		List<Flight> f=Arrays.stream(ff).filter(x -> x.getDeparture_loc().equals(loc)).collect(Collectors.toList());
		return f;
	}

}
