package com.slowiak.turek.smoG.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONReader {

    private static String readAll(BufferedReader rd) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public String readJsonFromUrl(String urlLink) throws IOException {
        URL url = new URL(urlLink);
        
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("Accept", "application/json");
        urlConnection.setRequestMethod("GET");

        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        try {
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(inputStream, Charset.forName("UTF-8"))
            );
            String jsonText = readAll(rd);
            return jsonText;

        } finally {
            inputStream.close();
            urlConnection.disconnect();
        }
    }
}