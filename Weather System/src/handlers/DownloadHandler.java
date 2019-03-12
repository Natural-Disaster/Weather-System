package handlers;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadHandler {

	private String url = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/xml/";
	private String query = "?res=3hourly&key=31264c5e-a6f0-4c72-8c05-fc8fa8b9999f";
	public DownloadHandler() {

	}

	public void downloadFileURL(String id) {
		try (BufferedInputStream in = new BufferedInputStream(new URL(url + id + query).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream("src/data/"+id+".xml")) {
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
		} catch (IOException e) {
			// handle exception
			System.out.println("Error downloading: " + e);
		}
	}

}
