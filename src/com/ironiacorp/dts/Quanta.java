package com.ironiacorp.dts;

import com.ironiacorp.dts.unit.Unit;

public class Quanta
{
	private double amount;
	
	private Class<? extends Unit> type;
	
	private ProcessType quantaType;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Class<? extends Unit> getType() {
		return type;
	}

	public void setType(Class<? extends Unit> type) {
		this.type = type;
	}

	public ProcessType getQuantaType() {
		return quantaType;
	}

	public void setQuantaType(ProcessType quantaType) {
		this.quantaType = quantaType;
	}
}
