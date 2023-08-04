package com.devnunens.warp.data.entity

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("features") var features: ArrayList<Features> = arrayListOf()
)

data class Features(
    @SerializedName("properties") var properties: Properties? = Properties()
)
data class Properties(
    @SerializedName("id") var id: String? = null,
    @SerializedName("effective") var effective: String? = null,
    @SerializedName("ends") var ends: String? = null,
    @SerializedName("event") var event: String? = null,
    @SerializedName("senderName") var senderName: String? = null,
)
