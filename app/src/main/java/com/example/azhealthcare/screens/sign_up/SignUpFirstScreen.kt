package com.example.azhealthcare.screens.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.azhealthcare.navegation.NavController
import com.example.azhealthcare.navegation.Screen
import com.example.azhealthcare.ui.theme.BtnRed
import com.example.azhealthcare.ui.theme.DarkBlue
import com.example.azhealthcare.ui.theme.DescriptionColor
import com.example.azhealthcare.ui.theme.LightBlue
import com.example.azhealthcare.ui.theme.PlaceholderColor
import com.example.azhealthcare.ui.theme.TextColor
import com.example.azhealthcare.view_models.signup_viewmodel.SignUpViewModel

@Composable
fun SignUpFirstScreen(
    navController: NavController,
    viewModel: SignUpViewModel = viewModel()
) {
    val fullName by viewModel.fullName.observeAsState("")
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val passwordVisibility by viewModel.passwordVisibility.observeAsState(false)
    val allFieldsValid by viewModel.allFieldsValid.observeAsState(false)

    BackgroundScreen()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBox(title = stringResource(id = R.string.sign_up))
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

            Spacer(modifier = Modifier.height(65.dp))
            //Full Name
            Text(
                text = stringResource(R.string.full_name),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = fullName,
                onValueChange = { viewModel.onFullNameChanged(it) },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_full_name),
                        color = DarkBlue
                    )
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = LightBlue,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    placeholderColor = PlaceholderColor
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

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
                onValueChange = { viewModel.onEmailChanged(it) },
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
                    textColor = TextColor,
                    placeholderColor = PlaceholderColor
                )
            )

            if (email.isNotBlank() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                    .matches()
            ) {
                Text(
                    text = "Wrong email format",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 8.dp)
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
                onValueChange = { viewModel.onPasswordChanged(it) },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.password_hint),
                        color = DarkBlue
                    )
                },
                singleLine = true,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
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
                    textColor = TextColor,
                    placeholderColor = PlaceholderColor
                )
            )

            if (password.isNotBlank() && !password.matches(Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#\$%^&*()\\-_=+{}\\[\\]|;:'\",.<>?/~`]).{6,}$"))) {
                Text(
                    text = stringResource(id = R.string.password_rules),
                    color = DescriptionColor,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            MyButton(
                text = stringResource(id = R.string.sign_up),
                onClick = {
                    // Navigate to the second signup screen
                    navController.navigateTo(Screen.SignUpSecondScreen.route)
                },
                enabled = allFieldsValid
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = {
                    navController.navigateTo(Screen.LogIn.route)
                }
            ) {
                Text(
                    text = stringResource(R.string.already_have_an_account),
                    color = Color.DarkGray,
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(id = R.string.sign_in),
                    color = BtnRed,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable {
                        navController.navigateTo(Screen.LogIn.route)
                    },
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpFirstScreen(navController = NavController())
}