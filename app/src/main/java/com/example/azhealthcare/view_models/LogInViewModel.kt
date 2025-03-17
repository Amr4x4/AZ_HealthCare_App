package com.example.azhealthcare.view_models

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LogInViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _passwordVisibility = MutableStateFlow(false)
    val passwordVisibility: StateFlow<Boolean> = _passwordVisibility

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun togglePasswordVisibility() {
        _passwordVisibility.value = !_passwordVisibility.value
    }

    fun validateFields(): Boolean {
        val emailValid = Patterns.EMAIL_ADDRESS.matcher(_email.value).matches()
        return _email.value.isNotBlank() && _password.value.isNotBlank() && emailValid
    }

    fun login(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        if (!validateFields()) {
            _errorMessage.value = "Please enter valid email and password."
            return
        }

        _loading.value = true
        viewModelScope.launch {
            delay(2000)  // Simulating network call
            // Assume login is successful for this demo
            _loading.value = false
            onSuccess()
        }
    }
}
