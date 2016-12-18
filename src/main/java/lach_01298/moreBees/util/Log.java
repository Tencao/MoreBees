package lach_01298.moreBees.util;

import lach_01298.moreBees.MoreBees;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;


public class Log {

	
	
	
	public static void log(Level logLevel, String message) 
	{
		LogManager.getLogger(MoreBees.MOD_ID).log(logLevel, message);
	}
	
	public static void log(Level logLevel, String message, Object e) 
	{
		LogManager.getLogger(MoreBees.MOD_ID).log(logLevel, message, e);
	}
	
}
