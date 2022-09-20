package com.ui.w3s.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ui.w3s.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


public class StepDefinition extends PageObject {
	//Webdriver driver=getDriver();
	@Steps
	HomePage home;

	@Given("user is on home page")
	public void user_is_on_home_page() {
	    System.out.println("Inside step- user is on home page");
	    
		getDriver().navigate().to("https://www.w3schools.com/");
		getDriver().manage().window().maximize();
	}

	@When("user clicks on login page and enters the credentials")
	public void user_clicks_on_login_page_and_enters_the_credentials() {
		System.out.println("Inside step- user enters username and password");
		home.Login_button();
		
		home.mail("sanketkharode11@gmail.com");
		home.password("Sanket1234*");
		home.sign_in_button();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("user clicks on courses")
	public void user_clicks_on_courses() throws InterruptedException {
		System.out.println("Inside step- user clicks on courses");
		home.navigating_to_courses();
		Thread.sleep(2000);
	}

	@Then("user is navigated to the list")
	public void user_is_navigated_to_the_list() throws InterruptedException {
		System.out.println("Inside step- user is navigated to the list");
		Thread.sleep(3000);
		
	}

	@Then("user clicks on java")
	public void user_clicks_on_java() throws InterruptedException {
		System.out.println("Inside step- user clicks on java");
		home.Clicking_MySql();;
		Thread.sleep(5000);
		//getDriver().close();
		//getDriver().quit();
		
	}

}
