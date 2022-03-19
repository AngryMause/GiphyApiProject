package com.example.giphytest

import android.os.Parcel
import android.os.Parcelable
import com.google.android.material.internal.ParcelableSparseIntArray
import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class GiphyModel(
    val url: String?): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GiphyModel> {
        override fun createFromParcel(parcel: Parcel): GiphyModel {
            return GiphyModel(parcel)
        }

        override fun newArray(size: Int): Array<GiphyModel?> {
            return arrayOfNulls(size)
        }
    }
}
