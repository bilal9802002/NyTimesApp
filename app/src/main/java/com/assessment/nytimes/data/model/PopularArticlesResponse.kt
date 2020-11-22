package com.assessment.nytimes.data.model

import com.google.gson.annotations.SerializedName

data class PopularArticlesResponse (

	@SerializedName("status") val status : String,
	@SerializedName("copyright") val copyright : String,
	@SerializedName("num_results") val numResults : Int,
	@SerializedName("results") val results : List<Article>
)