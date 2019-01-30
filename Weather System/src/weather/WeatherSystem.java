package weather;

import java.util.Scanner;

public class WeatherSystem {

	private static boolean menuLoop = true;
	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (menuLoop) {
			switch(displayMainMenu()) {
			case "1":
			System.out.println("Location search here");
			break;
			case "2":
				System.out.println("Daily weather report");
				break;
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
		String choice="";
		
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
