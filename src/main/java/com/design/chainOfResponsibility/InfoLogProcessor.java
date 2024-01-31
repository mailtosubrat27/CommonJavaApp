package com.design.chainOfResponsibility;

public class InfoLogProcessor extends LogProcessor {

	InfoLogProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
		
	}
	
	public void log(int logLevel, String message) {
		if(logLevel == INFO) {
			System.out.println("INFO Message- "+ message);
		} else {
			super.log(logLevel, message);
		}
	}

}
