package handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileHandler {
	
	private File sourceFolder;
	private ArrayList<ArrayList> allData = new ArrayList<>();

	public fileHandler(File source) {
		this.sourceFolder = source;
	}
	
	public void loadData() {
		for (File file : listFilesInFolder(sourceFolder)) {
			System.out.println(file.getName());
		}
	}
	
	private ArrayList<File> listFilesInFolder(File folder) {
		ArrayList<File> files = new ArrayList<>();
		for (File file : sourceFolder.listFiles()) {
			if(file.isDirectory()) {
				listFilesInFolder(file);
			}else{
				files.add(file);
			}
		}
		return files;
	}
	
	
	public ArrayList<String[]> readFile(File file) throws FileNotFoundException {
		
		Scanner scan = new Scanner(file);
		ArrayList<String[]> data = new ArrayList<>();

		while (scan.hasNext()) {
			String fileData = scan.nextLine();
			String[] dataSplit = fileData.split(" ");
			data.add(dataSplit);
		}

		return data;
		
	}
}

