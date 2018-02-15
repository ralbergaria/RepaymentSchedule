package com.rafaelalbergaria.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelalbergaria.model.GeneratePlan;
import com.rafaelalbergaria.model.Plan;
import com.rafaelalbergaria.service.RepaymentScheduleService;

@RestController
public class RepaymentScheduleRest {
	@Autowired
	RepaymentScheduleService repayment;
	
	@RequestMapping(value = "/generate-plan", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<List<GeneratePlan>> generatePlan(@RequestBody Plan plan) {
		try {
			return new ResponseEntity<List<GeneratePlan>>(repayment.generatePlan(plan), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<GeneratePlan>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}