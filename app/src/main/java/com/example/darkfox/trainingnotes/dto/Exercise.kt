package com.example.darkfox.trainingnotes.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exercise(val name:String,
                    val rounds:Int,
                    val weight:Double) : Parcelable