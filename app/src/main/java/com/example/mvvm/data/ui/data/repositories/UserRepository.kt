package com.example.mvvm.data.ui.data.repositories
import com.example.mvvm.data.ui.data.db.entites.AppDatabase
import com.example.mvvm.data.ui.data.db.entites.User
import com.example.mvvm.data.ui.data.network.MyApi
import com.example.mvvm.data.ui.data.network.SafeApiRequest
import com.example.mvvm.data.ui.data.network.responses.AuthResponse

class UserRepository(
    private val api:MyApi,
    private val db: AppDatabase
        ): SafeApiRequest(
        ) {
    suspend fun userLogin(email: String, password: String) : AuthResponse{
        return apiRequest{api.userLogin(email,password)
        }
    }
    suspend fun userSignUp(name: String, email: String, password: String ): AuthResponse{
        return apiRequest{api.userSignUp(name,email,password)}
    }
    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()
}