package com.codepath.apps.restclienttemplate.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

// User model to extract JSON data
@Parcelize
class User(var name: String = "", var screenName: String = "", var publicImageUrl: String = ""):
    Parcelable {


    // Gets the User data and returns the user object
    companion object {
        fun fromJson(jsonObject: JSONObject) : User {
            val user = User()
            user.name = jsonObject.getString("name")
            user.screenName = jsonObject.getString("screen_name")
            user.publicImageUrl = jsonObject.getString("profile_image_url_https")

            return user
        }
    }
}