package com.ajio.execution;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Asus-2020\\eclipse-workspace\\AjioCucumber\\src\\test\\java\\com\\ajio\\feature", 
				 glue= {"com.ajio.stepdefinition"},strict = false)
public class RunnerClass {	

}
