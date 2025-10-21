package com.example.utsmocom123

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String
)

object StudentData {
    val students = mutableStateListOf<Student>()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onAddStudentClick: (() -> Unit)? = null
) {
    val backgroundColor = Color(0xFFF5F9FF)
    val appBarColor = Color(0xFF1976D2)
    val cardBackground = Color(0xFFFFFFFF)
    val cardBorder = Color(0xFF90CAF9)
    val textMain = Color(0xFF0D47A1)
    val textSub = Color(0xFF424242)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Student Roster",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(appBarColor)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddStudentClick?.invoke() },
                containerColor = appBarColor
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Student", tint = Color.White)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(paddingValues)
        ) {
            if (StudentData.students.isEmpty()) {
                Text(
                    text = "No students added yet",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(StudentData.students) { student ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = cardBackground),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = student.name,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textMain
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "ID: ${student.id}",
                                    fontSize = 14.sp,
                                    color = textSub
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
