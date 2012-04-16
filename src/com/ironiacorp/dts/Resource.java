package com.ironiacorp.dts;

import java.util.Date;
import java.util.List;

public interface Resource
{
	List<Quanta> step(Date startDate, Date endDate); 
}
