package com.dh.android;

import java.net.URL;

import org.openqa.selenium.WebElement;

import base.AppiumServer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Deep_holistics {

	// static AndroidDriver driver;

	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub

		/*
		 * DesiredCapabilities capabilities = new DesiredCapabilities();
		 * 
		 * // capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
		 * "UiAutomator2"); capabilities.setCapability("automationName",
		 * "UiAutomator2"); capabilities.setCapability("platformName", "Android");
		 * capabilities.setCapability("platformVersion", "15");
		 * capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
		 * capabilities.setCapability("udid", "emulator-5554");
		 * capabilities.setCapability("app",
		 * "C:\\Users\\91860\\Desktop\\APK\\dh-staging_1.0.8.apk");
		 * capabilities.setCapability("appWaitPackage",
		 * "com.mysmitch.deepholistics.staging");
		 * capabilities.setCapability("appWaitActivity",
		 * "com.mysmitch.deepholistics.ui.user.htOnboarding.welcome.HtWelcomeActivity"
		 * ); //capabilities.setCapability("appWaitPackage",
		 * "com.mysmitch.deepholistics.staging");
		 * capabilities.setCapability("autoGrantPermissions", true);
		 * 
		 * 
		 */

		UiAutomator2Options options = new UiAutomator2Options();
		options.setAutomationName("UiAutomator2").setPlatformName("Android").setPlatformVersion("15")
				.setApp("C:\\Users\\91860\\Downloads\\DH-staging_1.0.8.apk").setIgnoreHiddenApiPolicyError(true)
				.setAppPackage("com.mysmitch.deepholistics.staging")
				// .setAppActivity("com.mysmitch.deepholistics.ui.user.htOnboarding.welcome.HtWelcomeActivity")
				.setAppActivity("com.mysmitch.deepholistics.ui.common.SplashActivity")
				// .setAppWaitActivity("com.mysmitch.deepholistics.ui.common.SplashActivity")
				.setAppWaitActivity("com.mysmitch.deepholistics.ui.user.htOnboarding.welcome.HtWelcomeActivity")
				.setNoReset(false).setAutoGrantPermissions(true);

		URL url = new URL("http://127.0.0.1:4723/");

		AppiumServer.startAppiumServer();
		AndroidDriver driver = new AndroidDriver(url, options);

		System.out.println("App Installed Successfully");

		Thread.sleep(5000);

		WebElement login = driver
				.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/btn_already_have_account"));
		login.click();

		Thread.sleep(5000);

//		WebElement editcountrycode = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/country_code"));
//		editcountrycode.click();

//		WebElement searchcountry = driver.findElement(By.id("com.mysmitch.deepholistics.staging:id/search_text"));
//		searchcountry.click();
//		searchcountry.sendKeys("india");

		WebElement enternumber = driver.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/etMobileNo"));
		enternumber.sendKeys("7598928864");

//Check Enabled , Handle Incorrect Number	

		Thread.sleep(3000);

		WebElement getOtp = driver.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/btn_get_otp"));
		getOtp.click();

		Thread.sleep(3000);

		WebElement enterOtp = driver.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/pinField"));
		enterOtp.sendKeys("6789");

		WebElement continuebutton = driver.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/btn_otp"));
		continuebutton.click();

		Thread.sleep(15000);

//		WebElement allowLocation = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
//		allowLocation.click();

		
		
/*		
		RemoteWebElement swipeDown = (RemoteWebElement) driver
				.findElement((AppiumBy.id("com.mysmitch.deepholistics.staging:id/view1")));

		driver.executeScript("gesture: swipe",ImmutableMap.of("elementId", swipeDown.getId(), "percentage", 50, "direction", "down"));

*/
		
		WebElement dismissBottomSheet = driver
				.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/container"));
		dismissBottomSheet.click();
		
		
		Thread.sleep(5000);

		WebElement clickProfile = driver
				.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/exploreUserProfileSettingsFragment"));
		clickProfile.click();

		Thread.sleep(5000);

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10);"));

		WebElement clickLogout = driver.findElement(AppiumBy.id("com.mysmitch.deepholistics.staging:id/logout"));
		clickLogout.click();

		WebElement Logout = driver.findElement(AppiumBy.id("android:id/button1"));
		Logout.click();

		System.out.println("Account Successfully Logged Out");

		Thread.sleep(2000);

		driver.removeApp("com.mysmitch.deepholistics.staging");

		System.out.println("App Uninstalled");

		AppiumServer.stopAppiumServer();
	}

}
