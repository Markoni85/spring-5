package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Tweet;

@RestController
public class SlowServiceTweetController {

	@GetMapping("/slow-service-tweets")
	public List<Tweet> getAllTweets() throws InterruptedException {
		Thread.sleep(2000L); // delay
		
	    return Arrays.asList(
	    	      new Tweet("RestTemplate rules", "@user1"),
	    	      new Tweet("WebClient is better", "@user2"),
	    	      new Tweet("OK, both are useful", "@user1"));
	}
}
