package test;

import java.util.Random;

import org.testng.annotations.Test;

public class Checking {
	  public static void main(String[] args) {
	        double eastLongitude =  -70.8961020085398;
	        double westLongitude =   -70.89819478414749;
	        double eastLatitude = 42.1110311951435;
	        double westLatitude = 41.99597421027852;

	        // Generate random longitude and latitude within the specified range
	        double randomLongitude = getRandomDouble(westLongitude, eastLongitude);
	        double randomLatitude = getRandomDouble(eastLatitude, westLatitude);

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
