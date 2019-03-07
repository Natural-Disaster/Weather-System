package weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import handlers.fileHandler;

public class WeatherSystem {

	private static boolean menuLoop = true;
	private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		while (menuLoop) {
			switch (displayMainMenu()) {
			case "1":
				System.out.println("Location search here");
				break;
			case "2":
				fileHandler handler = new fileHandler(new File("M:\\git\\Weather-System\\Weather System\\src\\data"));
				System.out.println("Select a date:");
				handler.loadData();
				String date = "";
				System.out.print("> ");
				date = userInput.nextLine(); {
					
				if (date.equals("060219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("M:\\git\\Weather-System\\Weather System\\src\\data\\060219.txt"));
					for (String[] string : d) {
						for (int i = 0; i < string.length; i++) {
							System.out.println(string[i]);
						}
					}
				}
				///////////////////////////////////////////////////////////
				else if (date.equals("070219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("M:\\git\\Weather-System\\Weather System\\src\\data\\070219.txt"));
					for (String[] string1 : d) {
						for (int i = 0; i < string1.length; i++) {
							System.out.println(string1[i]);
						}
					}
				}
				else if (date.equals("080219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("M:\\git\\Weather-System\\src\\data\\080219.txt"));
					for (String[] string2 : d) {
						for (int i = 0; i < string2.length; i++) {
							System.out.println(string2[i]);
						}
					}
				}
				else if (date.equals("090219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("M:\\git\\Weather-System\\src\\data\\090219.txt"));
					for (String[] string3 : d) {
						for (int i = 0; i < string3.length; i++) {
							System.out.println(string3[i]);
						
						}
						}
				}
				else if (date.equals("100219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("M:\\git\\Weather-System\\src\\data\\100219.txt"));
					for (String[] string3 : d) {
						for (int i = 0; i < string3.length; i++) {
							System.out.println(string3[i]);
						}
					}

				}
				else if (date.equals("110219")) {
					ArrayList<String[]> d = handler
							.readFile(new File("M:\\git\\Weather-System\\src\\data\\110219.txt"));
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