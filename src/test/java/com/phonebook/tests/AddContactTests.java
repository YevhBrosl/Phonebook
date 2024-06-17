package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("seba@yh.com")
                .setPassword("12345Qw$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Jane")
                .setLastName("Doe")
                .setPhone("1234567890")
                .setEmail("johndoe@gm.com")
                .setAddress("Berlin")
                .setDescription("colleague"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Jane"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
        app.getContact().pause(500);
    }
}
