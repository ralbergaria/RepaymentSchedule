package com.rafaelalbergaria.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rafaelalbergaria.model.GeneratePlan;
import com.rafaelalbergaria.model.Plan;
/**
 * Bean used to perform the calculations necessary for generating the plan. 
 * It was placed in the singleton pattern to be generated only one instance of the object.
 * @author Rafael
 * 
 */
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class RepaymentCalcBean {
	
//	public Double calcPaymentAmount(Plan plan) {
//		Double PV = plan.getLoanAmount();
//		float i = plan.getNominalRate() / 12 / 100;  
//		return (PV * i) / (1 - 1 / Math.pow(1 + i, plan.getDuration()));
//	}
	
	public Double calcAnnuity(Plan plan) {
		float rateMonth = new BigDecimal(plan.getNominalRate() / 12 / 100).setScale(6, RoundingMode.HALF_UP).floatValue();
		return new BigDecimal((rateMonth * plan.getLoanAmount()) / (1 - (Math.pow(1 + rateMonth, - plan.getDuration())))).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	public Double calcInterest(Plan plan) {
		float rateMonth = new BigDecimal(plan.getNominalRate() / 100).setScale(6, RoundingMode.HALF_UP).floatValue();
		return new BigDecimal((rateMonth * 30 * plan.getLoanAmount()) / 360 ).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
//	public Double calcRemainingOutstandingPrincipal(Plan plan, int paymentMade){
//      Double paymentAmount = calcPaymentAmount(Plan plan);	
//		float rateMonth = plan.getNominalRate() / 12 / 100;
//		return ((plan.getLoanAmount() * (Math.pow(1 + rateMonth, paymentMade))) - (paymentAmount * (Math.pow(1 + rateMonth, paymentMade) - 1) / rateMonth));
//	}
	
	public Date addOneMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}
	
	/**
	 * Generates the plan recursively
	 * @param plan
	 * @return
	 */
	public List<GeneratePlan> buildGeneratePlan(Plan plan) {
		List<GeneratePlan> list = new ArrayList<GeneratePlan>();
		GeneratePlan generatePlan = new GeneratePlan();
		generatePlan.setBorrowerPaymentAmount(calcAnnuity(plan));
		generatePlan.setInterest(calcInterest(plan));
		generatePlan.setInitialOutstandingPrincipal(new BigDecimal(plan.getLoanAmount()).setScale(2, RoundingMode.HALF_UP).doubleValue());
		generatePlan.setDate(plan.getStartDate());
		generatePlan.setPrincipal(new BigDecimal(generatePlan.getBorrowerPaymentAmount() - generatePlan.getInterest()).setScale(2, RoundingMode.HALF_UP).doubleValue());
		generatePlan.setRemainingOutstandingPrincipal(generatePlan.getInitialOutstandingPrincipal() - generatePlan.getPrincipal());
		
		list.add(generatePlan);
		
		if (plan.getDuration() > 1) {
			list.addAll(buildGeneratePlan(
					new Plan(generatePlan.getRemainingOutstandingPrincipal(), plan.getNominalRate(), plan.getDuration() - 1, addOneMonth(plan.getStartDate()))));
		}
		
		return list;
	}	
}