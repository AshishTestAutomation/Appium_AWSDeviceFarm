package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartApplication {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoAcceptAlerts","true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        URL url=new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<MobileElement> driver= new AndroidDriver<>(url,capabilities);
        Thread.sleep(3000);
        MobileElement two= driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sec.android.app.popupcalculator:id/calc_keypad_btn_02']"));
        MobileElement plus= driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sec.android.app.popupcalculator:id/calc_keypad_btn_add']"));
        MobileElement equal= driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal']"));
        two.click();
        Thread.sleep(1000);
        plus.click();
        Thread.sleep(1000);
        two.click();
        Thread.sleep(1000);
        equal.click();
        Thread.sleep(2500);
        MobileElement total= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        String result=total.getText();
        System.out.println("Output on Calc display: "+result);
        if(result.equalsIgnoreCase("4")){
            System.out.println("Test Case PASS");
        }

        driver.quit();
    }

}
