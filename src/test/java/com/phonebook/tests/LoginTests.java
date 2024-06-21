package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {

//    @BeforeClass
//    public void beforeClassPrecondition() {
//        System.out.println("Before Class");
//    }
//
//    @BeforeTest
//    public void beforeTestPrecondition() {
//        System.out.println("Before Test");
//    }
//
//    @AfterClass
//    public void afterClassPostCondition() {
//        System.out.println("After Class");
//    }
//
//    @AfterClass
//    public void afterTestPostCondition() {
//        System.out.println("After Test");
//    }

    @BeforeMethod
    public void ensurePrecondition() {
        //System.out.println("Before Method");
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test(priority = 2)
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
