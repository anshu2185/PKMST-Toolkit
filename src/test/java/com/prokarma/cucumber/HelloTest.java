package com.prokarma.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report","json:./report/hello-report-json/hello.json" })
public class HelloTest {
}