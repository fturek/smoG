package com.slowiak.turek.smoG.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

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
        while(true){
            URL url = new URL(urlLink);

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;

            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(5000);
                urlConnection.setReadTimeout(50000);
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.setRequestMethod("GET");

                inputStream = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                return readAll(rd);

            }catch(SocketTimeoutException e ){
                System.out.println("ex, trying again");
            }finally {
                if(inputStream != null){
                    inputStream.close();
                }
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
            }
        }
    }
}