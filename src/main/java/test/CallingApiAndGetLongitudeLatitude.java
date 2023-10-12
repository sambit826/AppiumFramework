package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class CallingApiAndGetLongitudeLatitude {

	    public static void main(String[] args) throws Exception {
	        String apiKey = "AIzaSyB1j-XO-y-RUnGobIxZZJuxx5qDAw8Lt5w";
	        String startLat = "20.438102";
	        String startLng = "85.899930";
	        String endLat = "20.465711";
	        String endLng = "85.908318";

	        String apiUrl = "https://maps.googleapis.com/maps/api/directions/json?origin=" + startLat + "," + startLng
	                + "&destination=" + endLat + "," + endLng + "&key=" + apiKey;

	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        StringBuilder content = new StringBuilder();

	        while ((inputLine = in.readLine()) != null) {
	            content.append(inputLine);
	        }
	        in.close();
	        connection.disconnect();

	        // Parse the JSON response and extract latitude and longitude coordinates
	        String jsonResponse = content.toString();
	        System.out.println(jsonResponse);
	        // Parse JSON and extract latitude and longitude coordinates from the response
	    }
	}


