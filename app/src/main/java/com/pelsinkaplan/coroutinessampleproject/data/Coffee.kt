package com.pelsinkaplan.coroutinessampleproject.data

/**
 * Created by Pelşin KAPLAN on 7.07.2022.
 */
import com.google.gson.annotations.SerializedName

data class Coffee(
    @SerializedName("title")
    var coffeeName: String,
    @SerializedName("description")
    var coffeeDescription: String,
    @SerializedName("ingredients")
    var coffeeIngredients: List<String>,
    @SerializedName("id")
    var coffeeId: Int
)