package com.rafaelalbergaria.model;

import java.util.Date;

public class GeneratePlan {
	private Double borrowerPaymentAmount;
	private Date date;
	private Double initialOutstandingPrincipal;
	private Double interest;
	private Double principal;
	private Double remainingOutstandingPrincipal;
	
	public Double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}
	
	public void setBorrowerPaymentAmount(Double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	
	public void setInitialOutstandingPrincipal(Double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	
	public Double getInterest() {
		return interest;
	}
	
	public void setInterest(Double interest) {
		this.interest = interest;
	}
		
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public void setRemainingOutstandingPrincipal(Double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	public Double getPrincipal() {	
		return principal;
	}
	
	public Double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borrowerPaymentAmount == null) ? 0 : borrowerPaymentAmount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((initialOutstandingPrincipal == null) ? 0 : initialOutstandingPrincipal.hashCode());
		result = prime * result + ((interest == null) ? 0 : interest.hashCode());
		result = prime * result + ((principal == null) ? 0 : principal.hashCode());
		result = prime * result
				+ ((remainingOutstandingPrincipal == null) ? 0 : remainingOutstandingPrincipal.hashCode());
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
		GeneratePlan other = (GeneratePlan) obj;
		if (borrowerPaymentAmount == null) {
			if (other.borrowerPaymentAmount != null)
				return false;
		} else if (!borrowerPaymentAmount.equals(other.borrowerPaymentAmount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (initialOutstandingPrincipal == null) {
			if (other.initialOutstandingPrincipal != null)
				return false;
		} else if (!initialOutstandingPrincipal.equals(other.initialOutstandingPrincipal))
			return false;
		if (interest == null) {
			if (other.interest != null)
				return false;
		} else if (!interest.equals(other.interest))
			return false;
		if (principal == null) {
			if (other.principal != null)
				return false;
		} else if (!principal.equals(other.principal))
			return false;
		if (remainingOutstandingPrincipal == null) {
			if (other.remainingOutstandingPrincipal != null)
				return false;
		} else if (!remainingOutstandingPrincipal.equals(other.remainingOutstandingPrincipal))
			return false;
		return true;
	}
	
	
}
