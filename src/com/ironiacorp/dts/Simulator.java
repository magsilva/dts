package com.ironiacorp.dts;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ironiacorp.dts.resource.ContinuousResource;
import com.ironiacorp.dts.resource.Resource;
import com.ironiacorp.dts.unit.Time;
import com.ironiacorp.dts.unit.Unit;
import com.ironiacorp.dts.unit.Watt;

public class Simulator
{
	private Map<Class<? extends Unit>, Double> status;
	
	private Set<Resource> resources;
	
	private Date startDate;
	
	private Date endDate;
	
	public Simulator()
	{
		status = new HashMap<Class<? extends Unit>, Double>();
		resources = new HashSet<Resource>();
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void registerResource(Resource resource)
	{
		resources.add(resource);
	}
	
	public void run()
	{
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(startDate);

		for (long i = startDate.getTime(); i < endDate.getTime(); i += Time.DAY) {
			for (Resource resource : resources) {
				List<Quanta> result = resource.step(startDate, endDate);
				for (Quanta quanta : result) {
					double value = quanta.getAmount();
					if (quanta.getQuantaType() == ProcessType.CONSUMPTION) {
						value *= -1;
					}
					if (status.containsKey(quanta.getType())) {
						value += status.get(quanta.getType());
					}
					status.put(quanta.getType(), value);
				}
			}
			calendar.add(Calendar.DAY_OF_MONTH, 0);
			for (Class<? extends Unit> unit : status.keySet()) {
				System.out.println(calendar.getTime().toLocaleString() + " = " + status.get(unit));
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		Simulator sim = new Simulator();
		
		Calendar calendar = GregorianCalendar.getInstance();
		
		calendar.clear();
		calendar.set(2011, 0, 1);
		sim.setStartDate(calendar.getTime());
		
		calendar.clear();
		calendar.set(2011, 0, 2);
		sim.setEndDate(calendar.getTime());
		
		ContinuousResource resource = new ContinuousResource();
		resource.setInputUnit(Watt.class);
		resource.setConsumptionRate(new Rate(Watt.class, 13.5, Time.class, (double) Time.HOUR));
		sim.registerResource(resource);

		sim.run();
	}
}
