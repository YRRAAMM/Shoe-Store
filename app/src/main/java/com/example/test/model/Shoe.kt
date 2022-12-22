package com.example.test.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//val images: List<String> = mutableListOf()
//, var imageId : Int

@Parcelize
data class Shoe(var name: String, var size: Float, var company: String, var description: String) : Parcelable