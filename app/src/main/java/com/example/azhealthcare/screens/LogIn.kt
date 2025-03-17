package com.example.azhealthcare.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.azhealthcare.R
import com.example.azhealthcare.common_ui.BackgroundScreen
import com.example.azhealthcare.common_ui.MyButton
import com.example.azhealthcare.common_ui.TopBox
import com.example.azhealthcare.ui.theme.DarkBlue
import com.example.azhealthcare.ui.theme.LightBlue
import com.example.azhealthcare.ui.theme.Purple40
import com.example.azhealthcare.view_models.LogInViewModel

@Composable
fun LogInScreen(viewModel: LogInViewModel = viewModel()) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val passwordVisibility by viewModel.passwordVisibility.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val loading by viewModel.loading.collectAsState()

    val allFieldsValid = viewModel.validateFields()

    BackgroundScreen()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBox(title = stringResource(id = R.string.sign_in))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                fontSize = 32.sp,
                fontWeight = FontWeight.W600,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(56.dp))

            // Email Field
            Text(
                text = stringResource(id = R.string.email),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.onEmailChange(it) },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.email_hint),
                        color = DarkBlue
                    )
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = LightBlue,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                )
            )

            if (email.isNotBlank() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Text(
                    text = stringResource(id = R.string.email_wrong_format),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .background(shape = RoundedCornerShape(4.dp), color = Color.White)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            Text(
                text = stringResource(id = R.string.password),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onPasswordChange(it) },
                placeholder = {
                    Text(text = stringResource(id = R.string.password_hint),
                        color = DarkBlue
                    )
                              },
                singleLine = true,
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisibility)
                        R.drawable.open_eye
                    else
                        R.drawable.close_eye

                    IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = LightBlue,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                )
            )

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            MyButton(
                text = stringResource(id = R.string.sign_in),
                onClick = {
                    viewModel.login(
                        onSuccess = { /* Navigate to next screen */ },
                        onFailure = { /* Error in loading*/ }
                    )
                },
                enabled = allFieldsValid && !loading
            )

            if (loading) {
                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = {/*TODO*/}) {
                Text(
                    text = stringResource(id = R.string.do_not_have_account),
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                )
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 21.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignInPreview() {
    LogInScreen()
}
