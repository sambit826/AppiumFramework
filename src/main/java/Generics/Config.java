package Generics;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {
	public static Map<String, String> configMap = new HashMap<String, String>();
	private String inputProperties = "Resources/input.properties";
	private String deviceConfig = "Resources/devices.json";
	public void loadConfig() {
		String appName = AutomationHelper.readPropertiesFileValue(inputProperties, "appName");
		String driverType = AutomationHelper.readPropertiesFileValue(inputProperties, "driverType");
		String executionPlatform = AutomationHelper.readPropertiesFileValue(inputProperties, "platform");
		String device = AutomationHelper.readPropertiesFileValue(inputProperties, "device");
		String hub = AutomationHelper.readPropertiesFileValue(inputProperties, "hub");

		configMap.put("appName", appName);
		configMap.put("driverType", driverType);
		configMap.put("platform", executionPlatform);
		configMap.put("device", device);
		configMap.put("hub", hub);
		
		ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(deviceConfig);

        try {
        	Map dataMap = new HashMap<String,HashMap>();
            dataMap =  objectMapper.readValue(jsonFile, new TypeReference<HashMap>(){});
            String name = (String) ((Map)((Map)((Map) dataMap.get(driverType)).get(executionPlatform)).get(device)).get("name");
            String osVersion = (String) ((Map)((Map)((Map) dataMap.get(driverType)).get(executionPlatform)).get(device)).get("os_version");
            String buildFile = (String) (((Map)((Map) dataMap.get(driverType)).get(executionPlatform)).get("BuildFile"));
            configMap.put("deviceName",name);
            configMap.put("osVersion", osVersion);
            configMap.put("buildFile", buildFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
