package com.bluetrailsoft.cursokmp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.ColorUtils
import com.bluetrailsoft.cursokmp.ui.theme.CursoKMPTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var isCardClicked by remember { mutableStateOf(false) }

            CursoKMPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CustomText(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Color.Cyan)
                                .clickable {
                                    Log.d("Click", "Taaap")
                                },
                            text = "Bievenidos",
                            fontSize = 30.sp
                        )
                        CustomText(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Color.Cyan)
                                .clickable {
                                    Log.d("Click", "Taaap")
                                },
                            text = "Bievenidos",
                            fontSize = 30.sp
                        )
                        CustomText(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Color.Cyan)
                                .clickable {
                                    Log.d("Click", "Taaap")
                                },
                            text = "Bievenidos",
                            fontSize = 30.sp
                        )

                        Row(modifier = Modifier.padding(24.dp)) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "Hello ")
                            }
                            ElevatedButton(
                                onClick = {
                                    Log.d("Click", "Taaap")
                                }
                            ) {
                                Text("Show more")
                            }
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Card(
                            modifier = Modifier.clickable {
                                isCardClicked = !isCardClicked
                                Log.d("Click", "Click on card: $isCardClicked")
                            },
                            shape = RoundedCornerShape(80),
                            elevation = CardDefaults.cardElevation(10.dp),
                            border = BorderStroke(1.dp, Color.Red)
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_person_pin_24),
                                    contentDescription = "Profile"
                                )

                                CustomText(
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .background(Color.Cyan)
                                        .clickable {
                                            Log.d("Click", "Taaap")
                                        },
                                    text = if (isCardClicked) "Adios" else "Hola",
                                    fontSize = 30.sp
                                )
                            }
                        }
                        CustomText(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Color.Cyan)
                                .clickable {
                                    Log.d("Click", "Taaap")
                                },
                            text = "Hola",
                            fontSize = 30.sp
                        )
                        CustomText(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Color.Cyan)
                                .clickable {
                                    Log.d("Click", "Taaap")
                                },
                            text = "Hola",
                            fontSize = 30.sp
                        )
                    }
                    CustomList()
                }
            }
        }
    }
}

@Composable
fun CustomText(
    modifier: Modifier,
    text: String,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = text,
        color = Color.Black,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun CustomList(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Text(
                text = name,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}