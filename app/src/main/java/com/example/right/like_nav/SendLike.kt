package com.example.right.like_nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.widget.Person
import com.example.right.widget.PersonProfile
import com.example.right.widget.SortSelector

@Preview(showBackground = true)
@Composable
fun SendLikeScreen() {
    var selectedSort by remember { mutableStateOf("남은일") }
    var checked by remember { mutableStateOf(false) }

    val personList = listOf(
        Person(R.drawable.example1, "봄날의 햇살", 25, "부산", 80, 3),
        Person(R.drawable.example2, "봄날의 햇살", 26, "부산", 70, 2),
        Person(R.drawable.example2, "봄날의 햇살", 27, "부산", 60, 1),
        Person(R.drawable.example1, "봄날의 햇살", 27, "부산", 60, 1),
        Person(R.drawable.example1, "봄날의 햇살", 25, "부산", 80, 3),
        Person(R.drawable.example2, "봄날의 햇살", 26, "부산", 70, 2),
        Person(R.drawable.example2, "봄날의 햇살", 27, "부산", 60, 1),
        Person(R.drawable.example1, "봄날의 햇살", 27, "부산", 60, 1),
        Person(R.drawable.example1, "봄날의 햇살", 25, "부산", 80, 3),
        Person(R.drawable.example2, "봄날의 햇살", 26, "부산", 70, 2),
        Person(R.drawable.example2, "봄날의 햇살", 27, "부산", 60, 1),
        Person(R.drawable.example1, "봄날의 햇살", 27, "부산", 60, 1),
    )

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 80.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.align_icon),
                    contentDescription = "align_icon",
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(12.dp))

                SortSelector(
                    selectedOption = selectedSort,
                    onOptionSelected = { selectedSort = it }
                )

                Spacer(modifier = Modifier.weight(1f))

                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(Color.Black),
                    modifier = Modifier
                        .size(14.dp)
                )
                
                Spacer(modifier = Modifier.width(14.dp))

                Text(
                    text = "선택",
                    color = Color.Black,
                    fontSize = 15.sp,
                )
            }

            Spacer(modifier = Modifier.height(17.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Column {
                    personList.chunked(2).forEach { rowItems ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                        ) {
                            rowItems.forEach { person ->
                                PersonProfile(
                                    modifier = Modifier.weight(1f),
                                    image = person.image,
                                    aka = person.aka,
                                    age = person.age,
                                    location = person.location,
                                    percent = person.percent,
                                    lastDay = person.lastDay
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}