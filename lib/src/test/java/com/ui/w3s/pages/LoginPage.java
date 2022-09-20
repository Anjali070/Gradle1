package com.ui.w3s.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;



public class LoginPage extends PageObject{



/*WebDriver driver;
public HomePage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
}*/
@FindBy(xpath="//*[@id='w3loginbtn']")
WebElementFacade Login_button;

@FindBy(name = "email")
WebElementFacade Enter_Email;

@FindBy(name = "current-password")
WebElementFacade Enter_Password;

@FindBy(xpath = "//*[@class='Button_button__URNp+ Button_primary__d2Jt3 Button_fullwidth__0HLEu']")
WebElementFacade Sign_in;

@FindBy(xpath="//*[@class='explore-link btn btn-light'][1]")
WebElementFacade Courses;

@FindBy(xpath="//*[contains(text(),'MySQL')]")
WebElementFacade MySql;

public void Login_button() {
Login_button.click();
}

public void mail(String mailid) {
Enter_Email.sendKeys(mailid);
}
public void password(String pass) {
Enter_Password.sendKeys(pass);
}
public void sign_in_button() {
Sign_in.click();
}
public void navigating_to_courses() {
Courses.click();
}
public void Clicking_MySql() {
MySql.click();
}
}