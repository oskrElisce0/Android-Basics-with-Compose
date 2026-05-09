package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF073042)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        LogoAndNameSection(
            fullName = "Tu Nombre Aquí",       // << Cambia tu nombre
            title = "Android Developer",        // << Cambia tu cargo
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        ContactInfoSection(
            phone = "+52 951 123 4567",         // << Cambia tu teléfono
            socialMedia = "@tu_usuario",         // << Cambia tu usuario
            email = "tu.email@ejemplo.com",      // << Cambia tu email
            modifier = Modifier.padding(bottom = 48.dp)
        )
    }
}

@Composable
fun LogoAndNameSection(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF003823)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                fontSize = 64.sp,
                color = Color(0xFF3DDC84),
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = fullName,
            fontSize = 36.sp,
            color = Color.White,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color(0xFF3DDC84),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInfoSection(
    phone: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Divider()
        ContactRow(icon = Icons.Rounded.Phone, info = phone)
        Divider()
        ContactRow(icon = Icons.Rounded.Share, info = socialMedia)
        Divider()
        ContactRow(icon = Icons.Rounded.Email, info = email)
        Divider()
    }
}

@Composable
fun ContactRow(icon: ImageVector, info: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 48.dp, top = 12.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3DDC84),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = info,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Composable
fun Divider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .height(1.dp)
            .background(Color(0xFF3DDC84).copy(alpha = 0.3f))
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}