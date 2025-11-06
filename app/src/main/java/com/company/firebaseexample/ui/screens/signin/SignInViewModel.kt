package com.company.firebaseexample.ui.screens.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignInViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()
    private val firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance()

    fun updateEmail(updatedEmail: String) {
        _uiState.value = _uiState.value.copy(email = updatedEmail)
    }

    fun updatePassword(updatedPassword: String) {
        _uiState.value = _uiState.value.copy(password = updatedPassword)
    }

    fun login() {
        val state = _uiState.value
        if (state.email.isBlank() || state.password.isBlank()) {
            return
        }
        viewModelScope.launch {
            try {
                firebaseAuth.signInWithEmailAndPassword(state.email, state.password).await()
                Log.d("SignInViewModel", "Connexion réussie pour l'utilisateur : ${state.email}")
            } catch (e: Exception) {
                Log.e("SignInViewModel", "Erreur lors de la connexion : ${e.message}")
            }
        }
    }
}