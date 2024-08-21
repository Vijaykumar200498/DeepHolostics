package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {

	static AppiumServiceBuilder builder;
	static AppiumDriverLocalService server;

	public static void startAppiumServer() {

		AppiumServiceBuilder builder = new AppiumServiceBuilder(); // Build Appium Server
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);

		server = AppiumDriverLocalService.buildService(builder); // Start Appium Server With builder
		server.start();
	}

	public static void stopAppiumServer() {

		// server = AppiumDriverLocalService.buildService(builder);
		// server.stop();
		if (server.isRunning()) {
			server.stop();
		}
	}
}