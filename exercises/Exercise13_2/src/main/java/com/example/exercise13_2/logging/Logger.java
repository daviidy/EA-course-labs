package com.example.exercise13_2.logging;

public class Logger implements ILogger {

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

}
