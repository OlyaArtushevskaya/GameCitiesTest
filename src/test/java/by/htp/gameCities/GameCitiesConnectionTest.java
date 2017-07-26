package by.htp.gameCities;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.citiesgame.CitiesClient;

public class GameCitiesConnectionTest {

	private CitiesClient citiesClient;
	private String testMessageClient;

	@BeforeClass
	public void paramsTest() {
		citiesClient = new CitiesClient();
		testMessageClient = "Start client";
	}

	@Test
	public void connectionTest() {
		System.out.println("Expected result: " + testMessageClient);
		System.out.print("Actual result: ");
		Assert.assertEquals(testMessageClient, citiesClient.messageConnectionClientServer());
	}

	// @AfterClass

}
