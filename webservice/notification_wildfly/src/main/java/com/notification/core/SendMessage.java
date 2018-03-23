package com.notification.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMessage {
	
	static final Logger LOG = LoggerFactory.getLogger(SendMessage.class);
	final static String firebaseURL = "https://fcm.googleapis.com/fcm/send";
	
		
	public void sendMessage(String serverKey, String token, String title, String message) throws IOException{
		
		URL url = new URL(firebaseURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", "key=" + serverKey);

		conn.setDoOutput(true);

		String input = String.format("{\"to\":\"%s\", \"notification\" : {\"title\" : \"%s\", \"body\":\"%s\"}}", token, title, message);

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		os.close();

		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + input);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
		    response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		LOG.trace(response.toString());
	}
}
