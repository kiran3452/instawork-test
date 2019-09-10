package com.instawork.pageobjects;

import com.instawork.genericcomponents.Base_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchPage {

    public SearchPage(WebDriver driver){
        initElements(driver, this);
    }



}
