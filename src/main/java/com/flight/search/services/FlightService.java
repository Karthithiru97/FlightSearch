package com.flight.search.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.flight.search.entity.Flight;
import com.flight.search.entity.Search;


@Service
public class FlightService {


	
	@Autowired
	RestTemplate resttemp;

	public Flight[] findAll() {
		ResponseEntity<Flight[]> re=resttemp.getForEntity("http://localhost:8082/flight/search", Flight[].class);
		Search search=new Search();
		Flight[] flight=re.getBody();
		
		return flight;
		
		
	}
	
	
}
