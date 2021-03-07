package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DependentsPage extends CommonMethods {

    @FindBy(xpath = "//*[@id='btnAddDependent']")
    public WebElement addButton;

    @FindBy(name = "dependent[name]")
    public WebElement dependentNameBox;

    @FindBy(id = "dependent_relationshipType")
    public WebElement relationshipBox;

    @FindBy(name = "dependent[dateOfBirth]")
    public WebElement dateOfBirthBox;

    @FindBy(id = "btnSaveDependent")
    public WebElement saveButton;


    public DependentsPage(){
        PageFactory.initElements(driver, this);
    }
}
