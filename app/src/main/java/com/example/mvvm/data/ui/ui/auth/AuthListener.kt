package com.example.mvvm.data.ui.ui.auth

import com.example.mvvm.data.ui.data.db.entites.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)

}