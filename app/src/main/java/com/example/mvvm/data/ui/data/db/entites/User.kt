package com.example.mvvm.data.ui.data.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User(
//    data class
    var id : Int? = null,
    var name : String? = null,
    var email : String? = null
)
{
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}