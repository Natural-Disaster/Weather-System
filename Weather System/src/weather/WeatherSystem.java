package weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import handlers.DownloadHandler;
import handlers.FileHandler;

public class WeatherSystem {

	private static boolean menuLoop = true;
	private static Scanner userInput = new Scanner(System.in);
	private static DownloadHandler dl = new DownloadHandler();

	public static void main(String[] args) throws FileNotFoundException {
		initialise();
		while (menuLoop) {
			switch (displayMainMenu()) {
			case "1":
				System.out.println("Location search here");
				break;
			case "2":
				FileHandler handler = new FileHandler(new File("src\\data"));
				System.out.println("Select a date:");
				handler.loadData();
				String date = "";
				System.out.print("> ");
				date = userInput.nextLine(); {
					
				if (date.equals("060219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("src\\data\\060219.txt"));
					for (String[] string : d) {
						for (int i = 0; i < string.length; i++) {
							System.out.println(string[i]);
						}
					}
				}
				///////////////////////////////////////////////////////////
				else if (date.equals("070219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("src\\data\\070219.txt"));
					for (String[] string1 : d) {
						for (int i = 0; i < string1.length; i++) {
							System.out.println(string1[i]);
						}
					}
				}
				else if (date.equals("080219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("src\\data\\080219.txt"));
					for (String[] string2 : d) {
						for (int i = 0; i < string2.length; i++) {
							System.out.println(string2[i]);
						}
					}
				}
				else if (date.equals("090219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("src\\data\\090219.txt"));
					for (String[] string3 : d) {
						for (int i = 0; i < string3.length; i++) {
							System.out.println(string3[i]);
						
						}
						}
				}
				else if (date.equals("100219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("src\\data\\100219.txt"));
					for (String[] string3 : d) {
						for (int i = 0; i < string3.length; i++) {
							System.out.println(string3[i]);
						}
					}

				}
				else if (date.equals("110219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("src\\data\\110219.txt"));
					for (String[] string3 : d) {
						for (int i = 0; i < string3.length; i++) {
							System.out.println(string3[i]);
						}
					}
				}

				else {
					System.out.println("Invalid Option");
				}
				break;
			}
			case "3":
				System.out.println("Weather overview");
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
		String[] placeID = {"310012","310013","352287","310123","352409","354301"};
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

}