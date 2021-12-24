package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.Tweet;

import reactor.core.publisher.Flux;

@RestController
public class TweetNonBlockingController {

	@GetMapping(value = "/tweets-non-blocking", 
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tweet> getTweetsNonBlocking() {
	    System.out.println("Starting NON-BLOCKING Controller!");
	    Flux<Tweet> tweetFlux = WebClient.create()
	      .get()
	      .uri("http://localhost:8080/slow-service-tweets")
	      .retrieve()
	      .bodyToFlux(Tweet.class);

	    tweetFlux.subscribe(tweet -> {
	    	System.out.println(tweet.toString());
	    });
	    
	    System.out.println("Exiting NON-BLOCKING Controller!");
	    return tweetFlux;
	}
}
