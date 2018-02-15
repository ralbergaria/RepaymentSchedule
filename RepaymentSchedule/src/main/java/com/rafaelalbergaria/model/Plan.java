package com.rafaelalbergaria.model;

import java.util.Date;

public class Plan {
	private Double loanAmount;
	private Float nominalRate;
	private Integer duration;
	private Date startDate;
	
	public Plan() {
		super();
	}
	
	public Plan(Double loanAmount, Float nominalRate, Integer duration, Date startDate) {
		super();
		this.loanAmount = loanAmount;
		this.nominalRate = nominalRate;
		this.duration = duration;
		this.startDate = startDate;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public Float getNominalRate() {
		return nominalRate;
	}
	
	public void setNominalRate(Float nominalRate) {
		this.nominalRate = nominalRate;
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((loanAmount == null) ? 0 : loanAmount.hashCode());
		result = prime * result + ((nominalRate == null) ? 0 : nominalRate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (loanAmount == null) {
			if (other.loanAmount != null)
				return false;
		} else if (!loanAmount.equals(other.loanAmount))
			return false;
		if (nominalRate == null) {
			if (other.nominalRate != null)
				return false;
		} else if (!nominalRate.equals(other.nominalRate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}	
}
