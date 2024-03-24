package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.rmi.ssl.SslRMIClientSocketFactory;


public class Main {


    public static void lookForCars(String[] carList, String html){
        Document doc = Jsoup.parse(html);
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            for (String car : carList) {
                if (String.valueOf(link).contains(car)) {
                    //System.out.println(link);
                    CarListing x = new CarListing(String.valueOf(link));

                    System.out.println(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "https://www.pickapart.co.nz/Avondale-Stock";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(); 
        
        // optional request header 
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        // response code of 200 means connection successful
        int responseCode = con.getResponseCode(); 
        System.out.println("Response code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
        String inputLine; 
        StringBuilder response = new StringBuilder(); 
        while ((inputLine = in.readLine()) != null) { 
            response.append(inputLine); 
        } 
        in.close(); 
        String html = response.toString();

        String[] carArray = {"Maxima", "Altima", "GT-R", "370z", "Murano"};
        lookForCars(carArray, html);
        // setup array that holds cars to look for



    }
}

/*
for car in carModelList:
        if soup.find_all(string=re.compile(car)): #checks to see if list is no empty
            print(soup.find_all(string=re.compile(car)))
    return
*/