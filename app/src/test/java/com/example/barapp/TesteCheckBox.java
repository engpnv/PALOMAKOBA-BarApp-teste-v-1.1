package com.example.barapp;

import com.example.barapp.util.DriverFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TesteCheckBox {
    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = DriverFactory.getDriver();

    }

    @Test
    public void testarCheckBox() {
        //procura os elementos pelo seu nome e atribui à um MobileElement
        MobileElement checkboxCerveja = driver.findElement(By.xpath("//*[@text='Cerveja']"));
        MobileElement checkboxAgua = driver.findElement(By.xpath("//*[@text='Água']"));
        MobileElement checkboxCigarro = driver.findElement(By.xpath("//*[@text='Cigarro']"));
        MobileElement checkboxVodka = driver.findElement(By.xpath("//*[@text='Vodka']"));
        MobileElement checkboxCachaca = driver.findElement(By.xpath("//*[@text='Cachaça']"));
        MobileElement checkboxWhisky = driver.findElement(By.xpath("//*[@text='Whisky']"));
        //verifica se os checkboxs não foram selecionados
        Assert.assertTrue(checkboxCerveja.getAttribute("checked").equals("false"));
        Assert.assertTrue(checkboxAgua.getAttribute("checked").equals("false"));
        Assert.assertTrue(checkboxCigarro.getAttribute("checked").equals("false"));
        Assert.assertTrue(checkboxVodka.getAttribute("checked").equals("false"));
        Assert.assertTrue(checkboxCachaca.getAttribute("checked").equals("false"));
        Assert.assertTrue(checkboxWhisky.getAttribute("checked").equals("false"));

        //seleciona os checkboxs
        checkboxCerveja.click();
        checkboxAgua.click();
        checkboxCigarro.click();
        checkboxVodka.click();
        checkboxCachaca.click();
        checkboxWhisky.click();

        //verifica se os checkboxs foram selecionados
        Assert.assertFalse(checkboxCerveja.getAttribute("checked").equals("false"));
        Assert.assertFalse(checkboxAgua.getAttribute("checked").equals("false"));
        Assert.assertFalse(checkboxCigarro.getAttribute("checked").equals("false"));
        Assert.assertFalse(checkboxVodka.getAttribute("checked").equals("false"));
        Assert.assertFalse(checkboxCachaca.getAttribute("checked").equals("false"));
        Assert.assertFalse(checkboxWhisky.getAttribute("checked").equals("false"));
    }


    @After
    public void tearDown() {
        DriverFactory.finalizarDriver();
    }
}
