package com.narcissus.util;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.narcissus.keywords.Keyword;

public class Waits {
	
	public Waits() {
		WebDriverWait wait=null;
		wait=new WebDriverWait(Keyword.driver,Duration.ofSeconds(30));
		wait.withMessage("Timeoutnfor while waiting for the element");
		wait.pollingEvery(Duration.ofMillis(500));
		
	}
	public void forDuration(long milliseconds) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime  + milliseconds; 
		while(startTime!=endTime) {
			startTime=System.currentTimeMillis();
		}
	}
	
	
}
