package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {

    public static Optional<String> parseJoke(String responseBody) {
        try {
            JokeResponse jokeResponse = new Gson().fromJson(responseBody, JokeResponse.class);
            String joke = jokeResponse.getJoke();
            if(joke != null) {
                return Optional.of(jokeResponse.getJoke());
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO: Call https://icanhazdadjoke.com/ API and display joke

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create("https://icanhazdadjoke.com/"))
                                .header("accept", "application/json")
                                .build();

        var response = client.send(request, BodyHandlers.ofString());

        Optional<String> joke = parseJoke(response.body());

        joke.ifPresent(System.out::println);
    }
}
