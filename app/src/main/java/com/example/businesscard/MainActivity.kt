package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun ContactItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconDescription: String,
    iconInfo: String
) {
    Row(
        modifier = modifier.padding(top = 10.dp),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = Color(0xFF157040)
        )
        Text(
            text = iconInfo,
            modifier = modifier.padding(start = 20.dp)
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFD2E7D4)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "Business Logo",
                    modifier = modifier
                        .background(color = Color.Black)
                        .width(120.dp)
                        .height(150.dp)
                )
                Text(
                    fontSize = 40.sp,
                    text = "James Webber",
                    modifier = modifier.padding(top = 2.dp)
                )
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(color = 0xFF157040),
                    text = "Android Developer Extraordinaire",
                    modifier = modifier.padding(top = 4.dp)
                )
            }


            Column(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                ContactItem(
                    icon = Icons.Rounded.Phone,
                    iconDescription = "Telephone Icon",
                    iconInfo = "+91 9568989885"
                )

                ContactItem(
                    icon = Icons.Rounded.Share,
                    iconDescription = "Share Icon",
                    iconInfo = "@james.webber"
                )

                ContactItem(
                    icon = Icons.Rounded.Email,
                    iconDescription = "Email Icon",
                    iconInfo = "jameswebber@example.com"
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}