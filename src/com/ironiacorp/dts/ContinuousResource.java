package com.ironiacorp.dts;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ironiacorp.dts.unit.Time;
import com.ironiacorp.dts.unit.Unit;
import com.ironiacorp.dts.unit.Watt;

public class ContinuousResource implements Resource
{
	private Set<Class<? extends Unit>> inputUnits;
	
	private Set<Class<? extends Unit>> outputUnits;
	
	private List<Rate> productionRates;
	
	private List<Rate> consumptionRates;
	
	public ContinuousResource()
	{
		inputUnits = new HashSet<Class<? extends Unit>>();
		outputUnits = new HashSet<Class<? extends Unit>>();
		productionRates = new ArrayList<Rate>();
		consumptionRates = new ArrayList<Rate>();
	}
	
	public Set<Class<? extends Unit>> getInputUnits() {
		return inputUnits;
	}

	public void setInputUnit(Class<? extends Unit> inputUnit) {
		inputUnits.add(inputUnit);
	}

	public Set<Class<? extends Unit>> getOutputUnits() {
		return outputUnits;
	}

	public void setOutputUnit(Class<? extends Unit> outputUnit) {
		outputUnits.add(outputUnit);
	}

	public void setConsumptionRate(Rate rate)
	{
		consumptionRates.add(rate);
	}
	
	public List<Rate> getConsumptionRates()
	{
		return consumptionRates;
	}
	
	public void setProductionRate(Rate rate)
	{
		productionRates.add(rate);
	}
	
	public List<Rate> getProductionRates()
	{
		return productionRates;
	}

	@Override
	public List<Quanta> step(Date startDate, Date endDate)
	{
		List<Quanta> result = new ArrayList<Quanta>();
		for (Rate rate : consumptionRates) {
			if (rate.getConsequentUnit() == Time.class) {
				double value = (rate.getAntecedentUnitCount() * Time.DAY) / rate.getConsequentUnitCount();
				Quanta quanta = new Quanta();
				quanta.setQuantaType(ProcessType.CONSUMPTION);
				quanta.setType(Watt.class);
				quanta.setAmount(value);
				result.add(quanta);
			}
		}
		return result;
	}
}
