package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void fillRegisterLoginFormForRecording(User user) {
        type(By.name("email"), user.getEmail());
        pause(2000);
        type(By.name("password"), user.getPassword());
        pause(2000);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isError409Present() {
        return isElementPresent(By.xpath("//div[.='Registration failed with code 409']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public void clearLoginRegisterForm() {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
    }

}
