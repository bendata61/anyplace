package com.nav.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class NavLog {

	private static String datetime(){
		long  epochtime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String datestr = sdf.format(new Date(epochtime));
		return datestr;
	}


	public static void appendLog(double lat, double lon){       
	
	   File logFile = new File("sdcard/AnyPlace/Nav-log");
	   if (!logFile.exists())
	   {
	      try
	      {
	         logFile.createNewFile();
	      } 
	      catch (IOException e)
	      {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	   try
	   {
	      //BufferedWriter for performance, true to set append to file flag
	      BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
	      String utc = datetime();
	      String text = utc + ',' + lat + ',' + lon;
	      buf.append(text);
	      buf.newLine();
	      buf.close();
	   }
	   catch (IOException e)
	   {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }
	}
}
