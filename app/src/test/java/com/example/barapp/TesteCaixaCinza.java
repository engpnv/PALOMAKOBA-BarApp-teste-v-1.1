package com.example.barapp;

import com.example.barapp.util.DriverFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TesteCaixaCinza {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp()  {
        driver = DriverFactory.getDriver();

    }

    @Test
    public void deveInteragirUmCheckbox() throws InterruptedException {
        MobileElement el1 = driver.findElementById("com.example.barapp:id/cb_cerveja");
        el1.click();
        MobileElement el2 = driver.findElementById("com.example.barapp:id/bt_efetuarPedido");
        el2.click();
        Thread thread = new Thread();
        thread.sleep(5000);
        MobileElement el3 = driver.findElementById("com.example.barapp:id/tv_resumoPedido");
        el3.click();
        Assert.assertEquals("1 Cerveja\n", el3.getText());

    }

    @Test
    public void deveInteragirTodosCheckbox() throws InterruptedException {
        MobileElement el1 = driver.findElementById("com.example.barapp:id/cb_cerveja");
        el1.click();
        MobileElement el2 = driver.findElementById("com.example.barapp:id/cb_agua");
        el2.click();
        MobileElement el3 = driver.findElementById("com.example.barapp:id/cb_cigarro");
        el3.click();
        MobileElement el4 = driver.findElementById("com.example.barapp:id/cb_vodka");
        el4.click();
        MobileElement el5 = driver.findElementById("com.example.barapp:id/cb_cachaca");
        el5.click();
        MobileElement el6 = driver.findElementById("com.example.barapp:id/cb_whisky");
        el6.click();
        MobileElement el7 = driver.findElementById("com.example.barapp:id/bt_efetuarPedido");
        el7.click();
        Thread thread = new Thread();
        thread.sleep(5000);
        MobileElement el9 = driver.findElementById("com.example.barapp:id/tv_resumoPedido");
        el9.click();
        Assert.assertEquals("1 Água\n" + "1 Cachaça\n" + "1 Cerveja\n"
                + "1 Cigarro\n" + "1 Vodka\n" + "1 Whisky\n", el9.getText());
    }

    @After
    public void tearDown() {

        DriverFactory.finalizarDriver();
    }
}
