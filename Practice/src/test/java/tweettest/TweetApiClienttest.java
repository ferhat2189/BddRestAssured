package tweettest;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tweet.TweetApiClient;

import java.util.UUID;

public class TweetApiClienttest {

private TweetApiClient tweetApiClient;


    @BeforeClass
    public void setUpTweetAPI(){
        this.tweetApiClient =new TweetApiClient();
    }

    @Test()
    public void testTweet(){
        // 1. user send a tweet
        String tweet="test tweet 1"+ UUID.randomUUID().toString();
        ValidatableResponse response= this.tweetApiClient.createTweet(tweet);
        // 2. Verify that the tweet was successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);
    }
    @Test()
    public void testUserCanTweetImageSuccessfully(){

        String tweet="/Users/ferhatbellache/Desktop/IMG.png";
//                + UUID.randomUUID().toString();
      ValidatableResponse response= this.tweetApiClient.createTweetImage(tweet);

        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);
    }
    @Test()
    public void testTweetInRepyToStatusId(){

        String tweet="That is just right"+ UUID.randomUUID().toString();
        ValidatableResponse response= this.tweetApiClient.tweetInRepyToStatusId(tweet);

        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);
    }
    @Test()
    public void testGetTimeOfaTweet(){
        String tweet="test tweet 1"+ UUID.randomUUID().toString();
        ValidatableResponse response= this.tweetApiClient.getTimeOfaTweet();

        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);
    }
    @Test()
    public void testRetweet(){
        String tweet="test tweet 1";
        ValidatableResponse response= this.tweetApiClient.retweet(1311164125062541313l);
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(tweet,actualTweet);
    }

}
