package com.example.azhealthcare.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.azhealthcare.presentation.theme.BtnRed
import com.example.azhealthcare.presentation.theme.Purple500
import com.example.azhealthcare.presentation.theme.Purple700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(

) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val listState = rememberLazyListState()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            SubjectScreenTopBar(
                title = "Profile",
                onBackButtonClick = { /* TODO */ },
                onLogOutButtonClick = { },
                onSettingsButtonClick = { },
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValue ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Purple700, Purple500, Purple700)
                    )
                )
                .padding(paddingValue)
        ) {
            item {

            }


        }
    }
}
//
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SubjectScreenTopBar(
    title: String,
    onBackButtonClick: () -> Unit,
    onLogOutButtonClick: () -> Unit,
    onSettingsButtonClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    LargeTopAppBar(
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            IconButton(
                onClick = { onBackButtonClick }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Navigation Back"
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            Column(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(4.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { onLogOutButtonClick }
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "App Settings Action",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .background(BtnRed)
                    .padding(4.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { onSettingsButtonClick }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Logout,
                        contentDescription = "LogOut Action",
                        tint = Color.Black
                    )
                }
                Text(
                    text = "LogOut",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black
                )
            }
        }
    )
}


@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}