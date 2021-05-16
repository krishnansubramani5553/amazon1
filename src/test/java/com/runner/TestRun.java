package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\resources\\Amazon.feature", glue = {"com.stepdef"},snippets=SnippetType.CAMELCASE)
public class TestRun {
	
}