package by.htp.citiesgame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CitiesClient {
	List<String> listCities = new ArrayList<String>();
	HashSet<String> usedCities = new HashSet<String>();
	private String messageClient = "Start client";
	private String lastChar;

	public String messageConnectionClientServer() {
		System.out.println(messageClient);
		return messageClient;
	}

	public CitiesClient() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("resources\\Cities.txt"), "UTF-8"));

			String city = "";
			int i = 1;
			while ((city = br.readLine()) != null) {
				if (i++ % 9 == 0)
					listCities.add(city); // добавим каждый 9-й город
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCity(int i) {
		// listCities.remove(i-1);
		return listCities.get(i);
	}

	public String getLastChar(String prevCity) {
		lastChar = prevCity.substring(prevCity.length() - 1);
		System.out.println(lastChar);
		return lastChar;
	}

	public String getCity(String prevCity) {
		usedCities.add(prevCity);
		// String lastChar = prevCity.substring(prevCity.length() - 1);
		// Радужный ?
		int trim = 1;
		while ("йъыь".contains(lastChar)) {
			lastChar = prevCity.substring(prevCity.length() - 1 - trim, prevCity.length() - trim);
			trim++;
		}
		String firstChar = lastChar.toUpperCase();
		String city = "Not answer";
		for (int i = 0; i < listCities.size(); i++) {
			if (listCities.get(i).startsWith(firstChar)) {
				String tempCity = listCities.get(i);
				if (usedCities.contains(tempCity)) {
					continue;
				} else {
					city = tempCity;
					usedCities.add(city);
					break;
				}
			}
		}
		System.out.println(city);
		return city;
	}

}