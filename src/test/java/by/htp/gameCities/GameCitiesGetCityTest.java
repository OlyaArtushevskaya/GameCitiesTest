package by.htp.gameCities;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.citiesgame.CitiesClient;

public class GameCitiesGetCityTest {

	private CitiesClient citiesClient;
	private List<String> testListCities;
	private String testPrevCity;
	private String testLastStartChar;
	private static final Logger log = LogManager.getLogger(GameCitiesGetCityTest.class.getName());

	@BeforeClass
	public void paramsTest() {
		citiesClient = new CitiesClient();
		testListCities = new ArrayList<String>();
		testListCities.add("Псков");
		testListCities.add("Гродно");
		testListCities.add("Солигорск");
		testListCities.add("Сан-Франциско");
		testListCities.add("Минск");
		testPrevCity = "Санкт-Петербург";
		testLastStartChar = "г";
	}

	@Test
	public void getLastCharTest() {
		System.out.println("TestListCities: " + testListCities);
		System.out.println("TestPrevCity: " + testPrevCity);
		System.out.println("Expected result - testLastStartChar " + testLastStartChar + " - " + testListCities.get(1));
		System.out.print("Actual result - testLastStartChar ");
		citiesClient.getLastChar(testPrevCity);
		Assert.assertEquals(citiesClient.getCity(testPrevCity).startsWith("г"), testListCities.get(1).startsWith("г"));
	}

	@AfterClass
	public static void logger() {
		log.log(Level.INFO, "Hello!");
		
	}

}
