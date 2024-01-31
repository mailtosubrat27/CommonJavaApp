package com.design.chainOfResponsibility;

public class ChainOfResponsibilityMain {

	public static void main(String[] args) {
		LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		
		logObject.log(LogProcessor.INFO, "Just info message");
		logObject.log(LogProcessor.DEBUG, "Just Debug message");
		logObject.log(LogProcessor.ERROR, "Just Error message");
	}
}
