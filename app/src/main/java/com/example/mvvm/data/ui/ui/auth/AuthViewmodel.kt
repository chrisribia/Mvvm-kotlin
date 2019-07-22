package com.example.mvvm.data.ui.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.ui.data.repositories.UserRepository
import com.example.mvvm.data.ui.ui.p.ApiException
import com.example.mvvm.data.ui.ui.p.Couroutines
import com.example.mvvm.data.ui.ui.p.NoInternetException

class AuthViewmodel(
    private val repository: UserRepository
) : ViewModel() {
    var email: String? = null
    var password: String? = null
    var name: String? = null
    var passwordconfirm: String? =null

    var authListener: AuthListener? = null

    

    fun getLoogedInUse() = repository.getUser()
        fun onLogin(view: View){
        Intent(view.context,LoginActivity::class.java).also {
        view.context.startActivity(it)
        }
    }

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("invalid email or password")
            return
        }
        Couroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }

                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }
        }
    }



    fun onSignup(view: View){
        Intent(view.context,SingupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


    fun onSignupButtonClick(view: View) {
        authListener?.onStarted()

        if (name.isNullOrEmpty()) {
            authListener?.onFailure("Name is required")
            return
        }

        if (email.isNullOrEmpty()) {
            authListener?.onFailure("Email is required")
            return
        }

        if (password.isNullOrEmpty()) {
            authListener?.onFailure("Please enter a password")
            return
        }

        if (password != passwordconfirm) {
            authListener?.onFailure("Password did not match")
            return
        }


        Couroutines.main {
            try {
                val authResponse = repository.userSignUp(name!!, password!!, email!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }
    }