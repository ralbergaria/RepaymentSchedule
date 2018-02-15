package com.rafaelalbergaria.service;

import java.util.List;

import com.rafaelalbergaria.model.GeneratePlan;
import com.rafaelalbergaria.model.Plan;

public interface RepaymentScheduleService {
	public List<GeneratePlan> generatePlan(Plan plan);
}
