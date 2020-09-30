package tweet;

import base.RestAPI;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class TweetApiClient extends RestAPI {

    private final String CREATE_TWEET_ENDPOINT = "/statuses/update.json";

    private final String IMAGE_ENDPOINT="media_id=";

    private final String TWEET_IN_REPLY_ENDPOINT="in_reply_to_status_id";
    private final String TWEET_Id1="1311164125062541313";
    private final String USER_TIMELINE="statuses/user_timeline.json";
    private final String RETWEET_ENDPOINT = "/statuses/retweet/:id.json";

    public ValidatableResponse createTweet(String tweet)  {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl+this.CREATE_TWEET_ENDPOINT)
                .then();
    }

    public ValidatableResponse createTweetImage(String tweet)  {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("media_id", tweet)
                .when().post(this.mediaImage+IMAGE_ENDPOINT)
                .then();
    }
    public ValidatableResponse tweetInRepyToStatusId(String tweet)  {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl+TWEET_IN_REPLY_ENDPOINT)
                .then();
    }
    // GET ALL Tweet Information
    public ValidatableResponse getTimeOfaTweet() {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("user_id",TWEET_Id1)
                .when().get(this.baseUrl +USER_TIMELINE)
                .then();
    }
    public ValidatableResponse retweet(Long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("id",tweetId)
                .when().get(this.baseUrl +RETWEET_ENDPOINT)
                .then();
    }
}
