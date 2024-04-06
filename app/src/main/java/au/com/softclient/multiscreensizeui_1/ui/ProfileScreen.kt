package au.com.softclient.multiscreensizeui_1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    val windowSize = rememberWindowSize()
    when(windowSize.width){
        WindowType.Compact ->{
            CompactProfileScreen()
        }
        else -> {
            MediumToExpandedProfileScreen()
        }
    }
}

@Composable
fun CompactProfileScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(36.dp))
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .size(180.dp)
            .background(MaterialTheme.colorScheme.primary)
            .align(Alignment.CenterHorizontally)
        ){
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "A",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 80.sp,
                )
        }
        Spacer(modifier = Modifier.height(64.dp))
        UserInfo(
            title = "Name",
            content = "Pure"
        )
        UserInfo(
            title = "Email",
            content = "Pure@gmail.com"
        )
        UserInfo(
            title = "Gender",
            content = "Male"
        )

    }
}


@Composable
fun MediumToExpandedProfileScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(36.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .size(180.dp)
                .background(MaterialTheme.colorScheme.primary)
            ){
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "A",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 80.sp,
                )
            }
            Spacer(modifier = Modifier.height(150.dp))
            Column {
                UserInfo(
                    title = "Name",
                    content = "Pure"
                )
                UserInfo(
                    title = "Email",
                    content = "Pure@gmail.com"
                )
                UserInfo(
                    title = "Gender",
                    content = "Male"
                )

            }
        }
    }
}


@Composable
fun UserInfo(
    title: String,
    content: String
){
    Column {
        Text(
            modifier = Modifier.alpha(0.7f),
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = content,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(32.dp))
    }

}