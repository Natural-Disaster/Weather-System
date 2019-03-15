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

	public static void main(String[] args) throws FileNotFoundException {
		initialise();
		while (menuLoop) {
			switch (displayMainMenu()) {
			case "1":
				locationSearch();
				break;
			case "2":
				dailyReport();
				break;
			case "3":
				weatherOverview();
				break;
			case "Q":
				menuLoop = false;
				break;

			default:
				System.out.println("Invalid choice entered, please try again");
			}
		}
	}

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
		System.out.println("3. Weather overview");
		System.out.println("Q. Quit");
		System.out.print("> ");
		choice = userInput.nextLine();

		return choice;
	}

	public static ArrayList<String> nextDates() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		ArrayList<String> dates = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			String format = dtf.format(now);
			dates.add(format);
			now = now.plusDays(1);
		}
		return dates;
	}

	public static void locationSearch() {
		System.out.println("Location search here");
	}

	public static void dailyReport() {
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
				try {
					xmlHandler.dailySearch(date);
				} catch (ParserConfigurationException | SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} else {
			System.out.println("Invalid Date entered");
		}
	}

	public static void weatherOverview() {
		System.out.println("Weather overview here");
	}
}