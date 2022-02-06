package com.codepath.apps.restclienttemplate.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONArray
import org.json.JSONObject

// Tweet model to extract JSON data
@Parcelize
class Tweet(var body: String = "", var createdAt: String = "", var user: User? = null):
    Parcelable {


    // Gets the JSON data for tweets
    companion object {
        // returns a tweet object
        fun fromJson(jsonObject: JSONObject): Tweet {
            val tweet = Tweet()
            tweet.body = jsonObject.getString("text")
            tweet.createdAt = jsonObject.getString("created_at")

            // Gets the user data
            tweet.user = User.fromJson(jsonObject.getJSONObject("user"))
            return tweet
        }

        // Converts jsonArray into an ArrayList
        fun fromJsonArray(jsonArray: JSONArray): List<Tweet> {
            val tweets = ArrayList<Tweet>()
            for (i in 0 until jsonArray.length()) {
                tweets.add(fromJson(jsonArray.getJSONObject(i)))
            }
            return tweets
        }
    }
}