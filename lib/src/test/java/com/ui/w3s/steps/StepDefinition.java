package com.ui.w3s.steps;



import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.w3s.common.FilePropertyReader;
import com.ui.w3s.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;




public class StepDefinition extends PageObject {
//Webdriver driver=getDriver();
	FilePropertyReader propertyReader;
	Connection connect=null;
	Statement statement = null;
	@Steps()
	LoginPage home;

	@Before
	public void beforeScenario() {
	propertyReader = new FilePropertyReader();
	//System.out.println(propertyReader.getMail());
	//System.out.println(propertyReader.getPassword());
	 System.out.println("New Scenario begins");
     try {
         Class.forName("org.postgresql.Driver");
         connect= DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "anjali");
         System.out.println("Opened Database Successfully");
     }
     catch(Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+" : "+e.getMessage());
         System.exit(0);
     }
 }
	



	@Given("user is on home page")
public void user_is_on_home_page() {
System.out.println("Inside step- user is on home page");

getDriver().navigate().to("https://www.w3schools.com/");
getDriver().manage().window().maximize();
}



@When("user clicks on login page and enters the credentials")
public void user_clicks_on_login_page_and_enters_the_credentials() throws SQLException {
System.out.println("Inside step- user enters username and password");
home.Login_button();
statement = connect.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM userdata");
while(rs.next())
{
    String username = rs.getString("mail");
    home.mail(username);
}

/*String decryptDatausername = propertyReader.getMail();
byte[] decodeBytes1=Base64.getDecoder().decode(decryptDatausername.getBytes());
home.mail(new String(decodeBytes1));*/
String decryptDataPassword = propertyReader.getPassword();
byte[] decodeBytes2=Base64.getDecoder().decode(decryptDataPassword.getBytes());
home.password(new String(decodeBytes2));



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
home.Clicking_MySql();
Thread.sleep(5000);
//getDriver().close();
//getDriver().quit();

}
}