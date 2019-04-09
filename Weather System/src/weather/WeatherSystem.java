package weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import handlers.DownloadHandler;
import handlers.XMLHandler;

public class WeatherSystem {

	private static boolean menuLoop = true;
	private static Scanner userInput = new Scanner(System.in);
	private static DownloadHandler dl = new DownloadHandler();

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		initialise();
		while (menuLoop) {
			switch (displayMainMenu()) {
			case "1":
				locationSearch(); // NOT STARTED
				break;
			case "2":
				dailyReport(); // WIP
				break;
			case "3":
				planningDay();
						
				break;
			case "Q":
				menuLoop = false;
				break;

			default:
				System.out.println("Invalid choice entered, please try again");
			}
		}
	}

	private static void planningDay() throws ParserConfigurationException, SAXException, IOException {
		System.out.println("Where Are You Visiting?");
		String location = "";
		System.out.print("> ");
		location = userInput.nextLine();


		System.out.println("What to wear-");
		System.out.println("What to do-");
		
		
		System.out.println("Next best thing-");
		
	}
		
	
	//} else {
		//System.out.println("Invalid location entered");
	//}
	//System.out.println("Press enter to return to menu");
	//userInput.nextLine();
	//}
	
		
	
	private static void initialise() {
		System.out.println("Initialising");
		refreshDownloads();
		System.out.println("Initialisation Complete\n");
	}

	private static void refreshDownloads() {
		System.out.println("Downloads Started");
		String[] placeID = { "310012", "310013", "352287", "310123", "352409", "354301" };
		for (String id : placeID) {
			dl.downloadFileURL(id);
		}
		System.out.println("Downloads Finished");
	}

	public static String displayMainMenu() {
		String choice = "";

		System.out.println("--Weather observation and forecasting system--");
		System.out.println("Pick:");
		System.out.println("1. Location search");
		System.out.println("2. Daily weather report");
		System.out.println("3. Plan My Day!");
		System.out.println("Q. Quit");
		System.out.print("> ");
		choice = userInput.nextLine();

		return choice;
	}

	public static ArrayList<String> nextDates() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		ArrayList<String> dates = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			String format = dtf.format(now);
			dates.add(format);
			now = now.plusDays(1);
		}
		return dates;
	}

	public static void locationSearch() throws ParserConfigurationException, SAXException, IOException {
		System.out.println("Search Location Here");

		ArrayList<String> locations = new ArrayList<String>();
		ArrayList<String> searchedLocations = new ArrayList<String>();
		
		File[] files = new File("src/data").listFiles();
		for (File file : files) {
			XMLHandler xmlHandler = new XMLHandler(file);
			xmlHandler = new XMLHandler(file);
			locations.add(xmlHandler.getName());
		}
		
		
		System.out.print("> ");
		String input = userInput.nextLine().toUpperCase();

		for (int i =0; i < locations.size(); i++) {
			if (locations.get(i).contains(input)) {
				searchedLocations.add(locations.get(i));
			}
		}
		if (searchedLocations.size() == 1) {
			XMLHandler xmlHandler = new XMLHandler(files[locations.indexOf(searchedLocations.get(0))]);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			String format = dtf.format(now);
			xmlHandler.dailySearch(format);
		}else if(searchedLocations.size() > 1) {
			for (String searched : searchedLocations) {
				System.out.println(searched);
			}
			System.out.println("Locations found, please choose from above");
			System.out.print("> ");
			String locationChoice = userInput.nextLine();
			if (searchedLocations.contains(locationChoice.toUpperCase())) {
				int indexVal = 0;
				for (int i = 0; i < searchedLocations.size(); i++) {
					if(searchedLocations.get(i).equals(locationChoice)){
						indexVal = i;
					}
				}
				XMLHandler xmlHandler = new XMLHandler(files[locations.indexOf(searchedLocations.get(indexVal))]);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				String format = dtf.format(now);
				xmlHandler.dailySearch(format);
			}else {
				System.out.println("Sorry no locations are found by that name");
			}
			
			
		}else {
			System.out.println("No location data found");
		}
		
		

	}

	public static void dailyReport() throws ParserConfigurationException, SAXException, IOException {
		System.out.println("Select a date:");
		// handler.loadData();
		ArrayList<String> dates = nextDates();
		for (String date : dates) {
			System.out.println(date);
		}
		String date = "";
		System.out.print("> ");
		date = userInput.nextLine();

		if (dates.contains(date)) {
			File[] files = new File("src/data").listFiles();
			for (File file : files) {
				XMLHandler xmlHandler = new XMLHandler(file);
				xmlHandler.dailySearch(date);
			}

		} else {
			System.out.println("Invalid Date entered");
		}
		System.out.println("Press enter to return to menu");
		userInput.nextLine();
	}


	}
