package com.dh.android;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DH_RealDevice {
	static AndroidDriver driver;

	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
		// "UiAutomator2");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14");
		capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
		capabilities.setCapability("udid", "85d9d818");
		//capabilities.setCapability("app", "C:\\Users\\91860\\Desktop\\APK\\dh-staging_1.0.8.apk");
		capabilities.setCapability("appWaitActivity", "com.mysmitch.deepholistics.ui.common.SplashActivity");
		capabilities.setCapability("appWaitPackage", "com.mysmitch.deepholistics.staging");
		capabilities.setCapability("autoGrantPermissions", true);

		URL url = new URL("http://127.0.0.1:4723/");

		driver = new AndroidDriver(url, capabilities);

		System.out.println("App Installed Successfully");

		Thread.sleep(5000);

		WebElement login = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/btn_already_have_account"));
		login.click();

		Thread.sleep(5000);

//		WebElement editcountrycode = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/country_code"));
//		editcountrycode.click();

//		WebElement searchcountry = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/search_text"));
//		searchcountry.click();
//		searchcountry.sendKeys("india");

		WebElement enternumber = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/etMobileNo"));
		enternumber.sendKeys("7598928864");

//Check Enabled , Handle Incorrect Number	

		Thread.sleep(3000);

		WebElement getOtp = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/btn_get_otp"));
		getOtp.click();

		Thread.sleep(3000);

		WebElement enterOtp = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/pinField"));
		enterOtp.sendKeys("6789");

		WebElement continuebutton = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/btn_otp"));
		continuebutton.click();

		Thread.sleep(5000);
		
//Location Permission
		/*
		 * WebElement allowLocation = driver .findElement(By.id(
		 * "com.android.permissioncontroller:id/permission_allow_button"));
		 * allowLocation.click();
		 */
		
		WebElement clickProfile = driver
				.findElement(By.id("com.mysmitch.deepholistics.staging:id/exploreUserProfileSettingsFragment"));
		clickProfile.click();
		
		WebElement clickLogout = driver
				.findElement(By.id("com.mysmitch.deepholistics.staging:id/logout"));
		clickLogout.click();
		
		WebElement Logout = driver
				.findElement(By.id("android:id/button1"));
		Logout.click();
		
		System.out.println("Logged Out Successfully");
		
		
		
		driver.quit();

	}
}
