package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

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

class InValidBrowserStackCredentials extends Exception{
	InValidBrowserStackCredentials(String message){
		super(message);
	}
}
 
public class BrowserStack implements DriverInterface {
	private static final String BROWSERSTACK_USERNAME = "sambitsenapati_IihGyu"; //System.getenv("BROWSERSTACK_USERNAME");//"sambitsenapati_IihGyu";
	private static final String BROWSERSTACK_ACCESS_KEY = "5qYJxx1hWowEydfMEzbq"; //System.getenv("BROWSERSTACK_ACCESS_KEY");//"5qYJxx1hWowEydfMEzbq";

	public static String appURL = "";
	DesiredCapabilities capabilities = null;
	HashMap<String, Object> browserstackOptions = new HashMap<>();
	URL url = null;

	
	private void validateCredentials() throws InValidBrowserStackCredentials {
		if (BROWSERSTACK_USERNAME == null || BROWSERSTACK_USERNAME.equals("")) {
			throw new InValidBrowserStackCredentials("BROWSERSTACK_USERNAME envrionment variable not set");
		}
		if (BROWSERSTACK_ACCESS_KEY == null || BROWSERSTACK_ACCESS_KEY.equals("")) {
			throw new InValidBrowserStackCredentials("BROWSERSTACK_ACCESS_KEY envrionment variable not set");
		}
		
	} 
	@Override
	public void configureCapabilities() {
		try {
			validateCredentials();
		} catch (InValidBrowserStackCredentials e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

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
		browserstackOptions.put("projectName", Config.configMap.get("appName"));
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
		
		String bUserName = BROWSERSTACK_USERNAME;
		String bPassword = BROWSERSTACK_ACCESS_KEY;

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
			
			System.out.println("....................");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appURL;
	}
	@Override
	public void configureCapabilities(String deviceName, String udid) {
		// TODO Auto-generated method stub
		
	}

}
