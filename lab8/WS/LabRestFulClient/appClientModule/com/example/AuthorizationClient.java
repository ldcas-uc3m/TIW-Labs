package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

//import com.fasterxml.jackson.databind.SerializationFeature;

public class AuthorizationClient {

	private static final String targetURL = "http://localhost:8080/LabRESTFULService/rest/codificaciones";

	public static void main(String[] args) {
		try {

			URL targetUrl = new URL(targetURL);
			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type", "application/json");

			AuthorizationRQ authRQ = new AuthorizationRQ("123456789", Long.valueOf(100), "1234567890123456789");
			ObjectMapper objectMapper = new ObjectMapper();
			String authRQString = objectMapper.writeValueAsString(authRQ);

			System.out.println(targetURL + "      AuthorizationRQ: " + authRQString);

			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(authRQString.getBytes());
			outputStream.flush();

			if (httpConnection.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			String output;

			// Genero el objeto a partir del JSON recibido
			while ((output = responseBuffer.readLine()) != null) {

				System.out.println("AuthorizationRS JSON:" + output);
				ObjectMapper mapper = new ObjectMapper();
				AuthorizationRSCompleto authRS = mapper.readValue(output, AuthorizationRSCompleto.class);
				System.out.println("AuthorizationRS Object:" + authRS);

			}
			httpConnection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
