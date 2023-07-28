package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Generics.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.File;
import java.io.IOException;

public class BrowserStack implements DriverInterface {
	private static final String BROWSERSTACK_USERNAME = "sambitsenapati_IihGyu";
	private static final String BROWSERSTACK_ACCESS_KEY = "5qYJxx1hWowEydfMEzbq";
//	private static final String PLATFORM_NAME = "Android Device";
//	private static final String DEVICE_NAME = "";
//	private static final String BROWSER_NAME = "";
//	private static final String APPIUM_HUB_URL = "http://hub.browserstack.com/wd/hub";

	public static String appURL = "";
	DesiredCapabilities capabilities = null;
	HashMap<String, Object> browserstackOptions = new HashMap<>();
	URL url = null;

	@Override
	public void configureCapabilities() {

		if(Config.configMap.get("driverType").toLowerCase().equals("mobile")) {
			configureMobileDesiredCapabilities();
		}
		else {
			configureWebDesiredCapabilities();
		}

		try {
			url = new URL("https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY
					+ "@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public WebDriver createDriver() {
		if(Config.configMap.get("platform").toLowerCase().equals("android"))
			return new AndroidDriver(url, capabilities);
		return new IOSDriver(url, capabilities);
	}
	
	public void configureMobileDesiredCapabilities() {
		if (System.getenv("BROWSER_STACK_APP_URL") == null || System.getenv("BROWSER_STACK_APP_URL").equals("")) {
			uploadBuild();
		} else {
			appURL = System.getenv("BROWSER_STACK_APP_URL");
		}
		capabilities = new DesiredCapabilities();
		browserstackOptions.put("projectName", "Project 1");
		browserstackOptions.put("buildName", "sample_mobile_app");
		browserstackOptions.put("sessionName", "Session_app_test");
		browserstackOptions.put("appiumVersion", "2.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);

		capabilities.setCapability("platformName", Config.configMap.get("platform").toLowerCase());
		capabilities.setCapability("platformVersion", Config.configMap.get("osVersion"));
		capabilities.setCapability("deviceName", Config.configMap.get("deviceName"));
		capabilities.setCapability("app", appURL);
		 capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
	}
	public void configureWebDesiredCapabilities() {
		
	}

	public void uploadBuild() {

		String bUserName = BROWSERSTACK_USERNAME;//System.getenv(BROWSERSTACK_USERNAME);
		String bPassword = BROWSERSTACK_ACCESS_KEY; //System.getenv(BROWSERSTACK_ACCESS_KEY);
		if (bUserName == null || bUserName.equals("")) {
			System.out.println("Browserstack username envrionment variable not set");
			return;
		}
		if (bPassword == null || bPassword.equals("")) {
			System.out.println("Browserstack Password envrionment variable not set");
			return;
		}

		String apiKey = bUserName + ":" + bPassword;

		System.out.println(apiKey);

		String filePath = Config.configMap.get("buildFile");
		String apiUrl = "https://api-cloud.browserstack.com/app-automate/upload";

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(apiUrl);
		httpPost.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(apiKey.getBytes()));
		File file = new File(filePath);
		HttpEntity fileEntity = MultipartEntityBuilder.create()
				.addBinaryBody("file", file, ContentType.APPLICATION_OCTET_STREAM, file.getName()).build();
		httpPost.setEntity(fileEntity);

		try {
			HttpResponse response = httpClient.execute(httpPost);

			// Print the response status code and response body
			System.out.println("Response Status Code: " + response.getStatusLine().getStatusCode());
			System.out.println("Response Body:");
			String responseJson = EntityUtils.toString(response.getEntity());
			System.out.println(responseJson);
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonNode = objectMapper.readTree(responseJson);

				appURL = jsonNode.get("app_url").asText();

				System.out.println("appURL: " + appURL);
			} catch (IOException e) {
				e.printStackTrace();
			}
			httpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String retriveAppURL(String jsonResponse) {
		String appURL = "";
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(jsonResponse);

			appURL = jsonNode.get("app_url").asText();

			System.out.println("appURL: " + appURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appURL;
	}

}

//
//private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
//
//public static AppiumDriver getDriver(){
//    return driver.get();
//}
//
//public static void setDriver(AppiumDriver driver1){
//    driver.set(driver1);
//}
//
////@Override
//public void configure() {
//	AppiumDriver driver = null;
//    HashMap<String, Object> browserstackOptions = new HashMap<>();
//
//  String device = AutomationHelper.readPropertiesFileValue("Resources/input.properties", "device");
//  String deviceName = AutomationHelper.parseJson("Resources/mobileDevices.json").get(device).get("name").asText();
//  String osVersion = AutomationHelper.parseJson("Resources/mobileDevices.json").get(device).get("os_version").asText();
//  
//  if(System.getenv("BROWSER_STACK_APP_URL") == null || System.getenv("BROWSER_STACK_APP_URL").equals("")) {
//	  uploadBuild();
//  }else {
//	  appURL = System.getenv("BROWSER_STACK_APP_URL");
//  }
//  
//  capabilities = new DesiredCapabilities();
//  browserstackOptions.put("projectName", "Project 1");
//  browserstackOptions.put("buildName", "sample_mobile_app");
//  browserstackOptions.put("sessionName", "Session 1");
//  browserstackOptions.put("appiumVersion", "2.0.0");
//  capabilities.setCapability("bstack:options", browserstackOptions);
//
//  capabilities.setCapability("platformName", "android");
//  capabilities.setCapability("platformVersion", osVersion );
//  capabilities.setCapability("deviceName", deviceName);
//  capabilities.setCapability("app", appURL);

//  
//  try {
//	  url = new URL("https://"+BROWSERSTACK_USERNAME+":"+BROWSERSTACK_ACCESS_KEY+"@hub-cloud.browserstack.com/wd/hub");
//} catch (MalformedURLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//  driver = new AndroidDriver(url, capabilities);
////  setDriver(driver);
////  getDriver().quit();
//}
//
//
//
//
//
//
//
////
////@Override
////public void configure() {
////	caps = new DesiredCapabilities();
////    caps.setCapability("browserstack.user", BROWSERSTACK_USERNAME);
////    caps.setCapability("browserstack.key", BROWSERSTACK_ACCESS_KEY);
////    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
////    caps.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
////    caps.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
////}
////@Override
//public void connect() {
//	try {
//		driver = new AppiumDriver<MobileElement>(new URL(APPIUM_HUB_URL), caps);
//	} catch (MalformedURLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//    // Your test code goes here
//
//    driver.quit();
//	
//}
