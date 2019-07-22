package com.example.mvvm.data.ui.ui.p

import java.io.IOException

class ApiException(message: String): IOException(message)
class NoInternetException(message: String) : IOException(message)