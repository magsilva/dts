package com.ironiacorp.dts.resource;

import java.util.Date;
import java.util.List;

import com.ironiacorp.dts.Quanta;

public interface Resource
{
	List<Quanta> step(Date startDate, Date endDate); 
}
