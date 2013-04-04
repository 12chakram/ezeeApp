/**
 * 
 */
package com.ezeeappointer.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author dreddy
 *
 */
public class TEATimePeriodUtility {
	
	
	public static Map<String, String> createAllPossiblePeriods(String start, String end, String status){
		Map<String, String> periodMap = new HashMap<String, String>();
		Date startDate = new Date("1/1/1970 " + start);
		Date endDate = new Date("1/1/1970 " + end);
		if(startDate.getTime() > endDate.getTime()) ;
		SimpleDateFormat dt = new SimpleDateFormat("hh:mm a");
		for(;! end.equalsIgnoreCase(dt.format(startDate)); ){
			String startTime = dt.format(startDate).replace("AM", "am").replace("PM","pm");
			startDate = DateUtils.addMinutes(startDate, 30);
		String endTime = dt.format(startDate).replace("AM", "am").replace("PM","pm");
		periodMap.put(startTime +" - " +endTime, status);
		}
		
		return periodMap;
	}
	
	public static List createAllTimePeriods(String start, String end ){
		List<String> periodList = new ArrayList<String>();
		Date startDate = new Date("1/1/1970 " + start);
		Date endDate = new Date("1/1/1970 " + end);
		if(startDate.getTime() > endDate.getTime()) System.out.println("Start time cannot be greater than end time!!");
		SimpleDateFormat dt = new SimpleDateFormat("hh:mm a");
		for(;! end.equalsIgnoreCase(dt.format(startDate)); ){
			String startTime = dt.format(startDate).replace("AM", "am").replace("PM","pm");
			startDate = DateUtils.addMinutes(startDate, 30);
		String endTime = dt.format(startDate).replace("AM", "am").replace("PM","pm");
		System.out.println(endTime);
		periodList.add(startTime +" - " +endTime);
		}
		
		return periodList;
	}
	
	public static void main(String[] args){
		createAllPossiblePeriods("09:00 am", "05:00 pm", "AL");
		createAllTimePeriods("08:00 am", "04:00 pm");
	}

}
