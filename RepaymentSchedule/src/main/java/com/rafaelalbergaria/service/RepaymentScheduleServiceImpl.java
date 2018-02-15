package com.rafaelalbergaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rafaelalbergaria.bean.RepaymentCalcBean;
import com.rafaelalbergaria.model.GeneratePlan;
import com.rafaelalbergaria.model.Plan;

@Service("repaymentScheduleService")
public class RepaymentScheduleServiceImpl implements RepaymentScheduleService {
	
	@Autowired
	RepaymentCalcBean bean;
	
	@Override
	@Cacheable("plan")
	public List<GeneratePlan> generatePlan(Plan plan) {
		return bean.buildGeneratePlan(plan);
	}
	
}