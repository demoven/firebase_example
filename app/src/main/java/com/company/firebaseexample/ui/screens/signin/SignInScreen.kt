package com.company.firebaseexample.ui.screens.signin

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
fun SignInScreen(
    onNavigateToSignUp: () -> Unit,
    modifier : Modifier = Modifier,
    viewModel: SignInViewModel = viewModel()
) {
    val signInUiState by viewModel.uiState.collectAsState()

    Column(modifier = modifier) {
        OutlinedTextField(
            value = signInUiState.email,
            onValueChange = {
                viewModel.updateEmail(it)
            },
            label = { Text(stringResource(R.string.email)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = signInUiState.password,
            onValueChange = {
                viewModel.updatePassword(it)
            },
            label = { Text(stringResource(R.string.password)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                viewModel.login()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.sign_in))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick= onNavigateToSignUp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.sign_up))
        }
    }
}