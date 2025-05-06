package com.example.azhealthcare.presentation.viewmodels.signup_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns

class SignUpViewModel : ViewModel() {

    private val _fullName = MutableLiveData("")
    val fullName: LiveData<String> = _fullName

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _passwordVisibility = MutableLiveData(false)
    val passwordVisibility: LiveData<Boolean> = _passwordVisibility

    private val _allFieldsValid = MutableLiveData(false)
    val allFieldsValid: LiveData<Boolean> = _allFieldsValid

    fun onFullNameChanged(newValue: String) {
        _fullName.value = newValue
        validateFields()
    }

    fun onEmailChanged(newValue: String) {
        _email.value = newValue
        validateFields()
    }

    fun onPasswordChanged(newValue: String) {
        _password.value = newValue
        validateFields()
    }

    fun togglePasswordVisibility() {
        _passwordVisibility.value = _passwordVisibility.value?.not()
    }

    private fun validateFields() {
        val isFullNameValid = !_fullName.value.isNullOrBlank()
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(_email.value ?: "").matches()
        val isPasswordValid = _password.value?.let {
            it.length >= 6 && it.any { char -> char.isUpperCase() } &&
                    it.any { char -> char.isLowerCase() } &&
                    it.any { char -> "!@#$%^&*()-=_+[]{}|;:',.<>?/".contains(char) }
        } ?: false

        _allFieldsValid.value = isFullNameValid && isEmailValid && isPasswordValid
    }
}
