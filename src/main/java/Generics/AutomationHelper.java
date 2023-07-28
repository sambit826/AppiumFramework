package Generics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;

public class AutomationHelper {
	public static JsonNode parseJson(String file) {
		File jsonFile = new File(file);

		JsonNode jsonNode = null;
		try {
			jsonNode = new ObjectMapper().readTree(jsonFile);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonNode;
	}

	public static void setEnvVarsFromFile(String envFilePath) {
		Map<String, String> envVars;
		try {
			envVars = readEnvFile(envFilePath);
			setEnvironmentVariables(envVars);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Map<String, String> readEnvFile(String envFilePath) throws IOException {
		Map<String, String> envVars = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(envFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("=", 2);
				if (parts.length == 2) {
					String key = parts[0].trim();
					String value = parts[1].trim();
					envVars.put(key, value);
				}
			}
		}

		return envVars;
	}

	private static void setEnvironmentVariables(Map<String, String> envVars) {
		for (Map.Entry<String, String> entry : envVars.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.setProperty(key, value);
		}
	}

	public static String readPropertiesFileValue(String file, String key) {
		Properties properties = new Properties();

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return properties.getProperty(key);
	}
}
