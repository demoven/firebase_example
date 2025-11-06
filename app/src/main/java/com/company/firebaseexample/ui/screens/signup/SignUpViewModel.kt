package com.company.firebaseexample.ui.screens.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignUpViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun updateEmail(updatedEmail: String) {
        _uiState.value = _uiState.value.copy(email = updatedEmail)
    }

    fun updatePassword(updatedPassword: String) {
        _uiState.value = _uiState.value.copy(password = updatedPassword)
    }

    fun register() {
        val state = _uiState.value
        if (state.email.isBlank() || state.password.isBlank()) {
            return
        }
        viewModelScope.launch {
            try {
                firebaseAuth.createUserWithEmailAndPassword(state.email, state.password).await()
                Log.d("SignUpViewModel", "Inscription réussie pour ${state.email}")
            } catch (e: Exception) {
                Log.e("SignUpViewModel", "Erreur lors de l'inscription", e)
            }
        }
    }
}