package com.chenbabys.mycomposestudy.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by ChenYesheng On 2021/11/3 11:43
 * Desc:
 */
@Composable
fun SplashScreen(onSplashCompleted: () -> Unit) {

    //设置状态栏颜色为透明并且适配黑夜
    rememberSystemUiController().setStatusBarColor(Color.Transparent, darkIcons = true)

    Surface(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(15.dp)
        ) {
            //协程领域
            LaunchedEffect(Unit) {
                delay(3000L)
                onSplashCompleted()
            }
            Image(
                painter = painterResource(id = com.chenbabys.mycomposestudy.R.mipmap.ic_image_one),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
                    .scale(5f)//铺满缩放
            )
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = getCurrentTime(),
                    color = Color.Black,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(8.dp)
                )
                Text(text = "遇见你，真美好", color = Color.Black, style = MaterialTheme.typography.body1)
            }
//            Row(
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .padding(8.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Image(
//                    painter = painterResource(id = com.chenbabys.mycomposestudy.R.mipmap.ic_image_one),
//                    contentDescription = "Logo"
//                )
//                Text(text = "豆瓣", color = Color.Black, style = MaterialTheme.typography.h5)
//            }

        }

    }
}

@SuppressLint("SimpleDateFormat")
private fun getCurrentTime(): String {
    return try {
        val time = System.currentTimeMillis()
        val date = Date(time)
        val format = SimpleDateFormat("yyyy年MM月dd日 EEEE")
        format.format(date)
    } catch (e: Exception) {
        "2021年11月3日 星期三"
    }
}