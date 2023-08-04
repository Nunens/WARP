package com.devnunens.warp.data.entity

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("features") var features: ArrayList<Features> = arrayListOf()
)

data class Features(
    @SerializedName("properties") var properties: Properties? = Properties()
)
//event name "event", start date "effective", end date "ends", source "senderName" & duration (start date - end date)
data class Properties(
    @SerializedName("id") var id: String? = null,
    @SerializedName("effective") var effective: String? = null,
    @SerializedName("ends") var ends: String? = null,
    @SerializedName("event") var event: String? = null,
    @SerializedName("senderName") var senderName: String? = null,
)

/*
data class Properties(
    @SerializedName("@id") var atId: String? = null,
    @SerializedName("@type") var atType: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("areaDesc") var areaDesc: String? = null,
    @SerializedName("affectedZones") var affectedZones: ArrayList<String> = arrayListOf(),
    @SerializedName("references") var references: ArrayList<String> = arrayListOf(),
    @SerializedName("sent") var sent: String? = null,
    @SerializedName("effective") var effective: String? = null,
    @SerializedName("onset") var onset: String? = null,
    @SerializedName("expires") var expires: String? = null,
    @SerializedName("ends") var ends: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("messageType") var messageType: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("severity") var severity: String? = null,
    @SerializedName("certainty") var certainty: String? = null,
    @SerializedName("urgency") var urgency: String? = null,
    @SerializedName("event") var event: String? = null,
    @SerializedName("sender") var sender: String? = null,
    @SerializedName("senderName") var senderName: String? = null,
    @SerializedName("headline") var headline: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("instruction") var instruction: String? = null,
    @SerializedName("response") var response: String? = null,
)*/
