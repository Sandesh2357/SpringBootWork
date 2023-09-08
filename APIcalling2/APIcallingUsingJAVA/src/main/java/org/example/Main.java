package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {

            String apiUrl = "https://api.chucknorris.io/jokes/random";


            URL url = new URL(apiUrl);


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            connection.setRequestMethod("GET");


            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;


                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }


                reader.close();
                System.out.println("Chuck Norris Joke: " + response.toString());
            } else {
                System.err.println("Failed to fetch data. Response code: " + responseCode);
            }

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}