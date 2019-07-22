package com.example.mvvm.data.ui.data.network.responses

import com.example.mvvm.data.ui.data.db.entites.User

class AuthResponse
    (
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User
    )