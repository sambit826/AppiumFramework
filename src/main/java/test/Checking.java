package test;

import java.util.Random;

public class Checking {
	  public static void main(String[] args) {
	        double eastLongitude =  -73.451132;
	        double westLongitude = -73.486818;
	        double northLatitude = 41.335253;
	        double southLatitude = 41.447884;

	        // Generate random longitude and latitude within the specified range
	        double randomLongitude = getRandomDouble(westLongitude, eastLongitude);
	        double randomLatitude = getRandomDouble(southLatitude, northLatitude);

	        // Print the generated coordinates
	        System.out.println("Random Longitude: " + randomLongitude);
	        System.out.println("Random Latitude: " + randomLatitude);
	        System.out.println(randomLatitude +" "+randomLongitude);

	        // Use these coordinates in your Appium Selenium code for interacting with the app
	        // For example, you can set the location using Appium's setLocation method.
	        // driver.setLocation(new Location(randomLatitude, randomLongitude, 0));
	    }

	    // Generate a random double within a specified range
	    private static double getRandomDouble(double min, double max) {
	        Random rand = new Random();
	        return min + (max - min) * rand.nextDouble();
	    }

}
