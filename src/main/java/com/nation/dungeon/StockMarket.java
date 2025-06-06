package com.nation.dungeon;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class StockMarket {

    //website link: https://finnhub.io/dashboard
    //apiKey = d11h591r01qjtpe6rl70d11h591r01qjtpe6rl7g

    private final String apiKey;
    private final HttpClient client;

    public StockMarket(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
    }

    public double getCurrentPrice(String symbol) {
        String url = "https://finnhub.io/api/v1/quote?symbol=" + symbol + "&token=" + apiKey;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return extractCurrentPrice(response.body());
            } else {
                System.out.println("Error with call of HTTP: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error under API call: " + e.getMessage());
        }

        return -1;
    }

    public double extractCurrentPrice(String json) {

        int index = json.indexOf("\"c\":");
        if(index == -1) {
            return -1;
        }

        int start = index + 4;
        int end = json.indexOf("," + start);

        if(end == -1) {
            end = json.indexOf("}" + start);
        }

        String value = json.substring(start, end).trim();
        return Double.parseDouble(value);
    }
}
