package com.example.mvvm.data.ui.profile

import androidx.lifecycle.ViewModel;
import com.example.mvvm.data.ui.data.repositories.UserRepository
class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
