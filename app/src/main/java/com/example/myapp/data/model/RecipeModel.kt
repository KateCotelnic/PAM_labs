package com.example.myapp.data.model
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeModel (
    @Expose
    @SerializedName("username")
    var username: String,
    @Expose
    @SerializedName("name")
    var name: String,
    @Expose
    @SerializedName("type")
    var type: String,
    @Expose
    @SerializedName("image")
    var image: String,
    @Expose
    @SerializedName("ingredients")
    var ingredients: ArrayList<String>,
    @Expose
    @SerializedName("description")
    var description: ArrayList<String>
) : Parcelable

