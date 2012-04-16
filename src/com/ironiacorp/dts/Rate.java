package com.ironiacorp.dts;

import com.ironiacorp.dts.unit.Unit;

public class Rate
{
	private Class<? extends Unit> antecedentUnit;
	
	private double antecedentUnitCount;
	
	private Class<? extends Unit> consequentUnit;

	private double consequentUnitCount;

	public Rate(Class<? extends Unit> antecedentUnit, double antecedentUnitCount, Class<? extends Unit> consequentUnit, double consequentUnitCount)
	{
		setAntecedentUnit(antecedentUnit);
		setAntecedentUnitCount(antecedentUnitCount);
		setConsequentUnit(consequentUnit);
		setConsequentUnitCount(consequentUnitCount);
	}
	
	public Class<? extends Unit> getAntecedentUnit() {
		return antecedentUnit;
	}

	public void setAntecedentUnit(Class<? extends Unit> unit) {
		this.antecedentUnit = unit;
	}

	public double getAntecedentUnitCount() {
		return antecedentUnitCount;
	}

	public void setAntecedentUnitCount(double unitCount) {
		this.antecedentUnitCount = unitCount;
	}

	public Class<? extends Unit> getConsequentUnit() {
		return consequentUnit;
	}

	public void setConsequentUnit(Class<? extends Unit> consequentUnit) {
		this.consequentUnit = consequentUnit;
	}

	public double getConsequentUnitCount() {
		return consequentUnitCount;
	}

	public void setConsequentUnitCount(double consequentUnitCount) {
		this.consequentUnitCount = consequentUnitCount;
	}
}
