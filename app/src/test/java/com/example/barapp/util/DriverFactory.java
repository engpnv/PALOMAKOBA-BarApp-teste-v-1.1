package com.example.barapp.util;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            criarDriver();
        }
        return driver;
    }

    private static void criarDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "K7AXB60350088V6");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.example.barapp");
        desiredCapabilities.setCapability("appActivity", "com.example.barapp.MainActivity");

        URL remoteUrl;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void finalizarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
