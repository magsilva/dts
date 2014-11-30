package com.ironiacorp.dts.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ironiacorp.dts.ProcessType;
import com.ironiacorp.dts.Quanta;
import com.ironiacorp.dts.periodicity.Periodicity;
import com.ironiacorp.dts.unit.Watt;

public class DiscreteResource implements Resource
{
	private Resource resource;
	
	private Periodicity periodicity;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}
	
	
	public List<Quanta> step(Date startDate, Date endDate) {
		List<Quanta> result = new ArrayList<Quanta>();
		
		// TODO: fix this
		Quanta quantum = new Quanta();
		quantum.setQuantaType(ProcessType.CONSUMPTION);
		// quantum.setType(resource.getInputTypes());
		result.add(quantum);
		
		return result;
	}
}
