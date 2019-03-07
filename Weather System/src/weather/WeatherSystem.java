
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

	
			
			switch(displayMainMenu()) {
			case "1":
			System.out.println("Location search here");
			fileHandler handler = new fileHandler(new File("M:\\git\\Weather-System\\Weather System\\src\\data"));
			//ArrayList<String[]> d = handler.readFile(new File("M:\\git\\Weather-System\\Weather System\\src\\data\\060219.txt"));
			handler.loadData();
			//for (String[] string : d) {
			//	for (int i = 0; i < string.length; i++) {
			//		System.out.println(string[i]);
			//	}
			//}
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
