package com.company.firebaseexample.ui.screens.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.company.firebaseexample.R

@Composable
fun SignUpScreen(
    onNavigateToSignIn: () -> Unit,
    modifier : Modifier = Modifier,
    signUpViewModel: SignUpViewModel = viewModel(),
) {
    val signUpState by signUpViewModel.uiState.collectAsState()

    Column(modifier = modifier) {
        OutlinedTextField(
            value = signUpState.email,
            onValueChange = {
                signUpViewModel.updateEmail(it)
            },
            label = { Text(stringResource(R.string.email)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = signUpState.password,
            onValueChange = {
                signUpViewModel.updatePassword(it)
            },
            label = { Text(stringResource(R.string.password)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                signUpViewModel.register()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.sign_up))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button (
            onClick = onNavigateToSignIn,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.already_have_account))
        }
    }
}