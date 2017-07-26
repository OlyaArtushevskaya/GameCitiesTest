package by.htp.gameCities;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.citiesgame.CitiesClient;

public class GameCitiesGetLastCharTest {

	private CitiesClient citiesClient;
	private String testCity;
	private String testLastChar;

	@BeforeClass
	public void paramsTest() {
		citiesClient = new CitiesClient();
		testCity = "Санкт-Петербург";
		testLastChar = "г";
	}

	@Test
	public void getLastCharTest() {
		System.out.println("TestCity: " + testCity);
		System.out.println("Last char of TestCity: ");
		System.out.println("Expected result: " + testLastChar);
		System.out.print("Actual result: ");
		String lastChar = citiesClient.getLastChar(testCity);
		Assert.assertEquals(testLastChar, lastChar);
	}

	// @AfterClass

}
