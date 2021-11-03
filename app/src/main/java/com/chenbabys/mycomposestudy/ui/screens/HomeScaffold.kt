package com.chenbabys.mycomposestudy.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

/**
 * Created by ChenYesheng On 2021/11/3 15:10
 * Desc: 容器Scaffold，可以设置顶部设置栏和底部设置栏的容器。
 */

@Composable
fun HomeScaffold() {
    //val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "我是周杰伦") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(text = "我爱林俊杰")
                Spacer(modifier = Modifier.weight(1f, true))
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Favorite, null)
                }
            }
        },
    ) {
        Conversation(
            arrayListOf(
                "我超级爱周杰伦我超级爱周杰伦我超级爱周杰伦我超级爱周杰伦",
                "我超级爱林俊杰我超级爱林俊杰我超级爱林俊杰我超级爱林俊杰",
                "我超级爱邓紫棋我超级爱邓紫棋我超级爱邓紫棋我超级爱邓紫棋",
                "我超级爱林俊杰我超级爱林俊杰我超级爱林俊杰我超级爱林俊杰",
                "我超级爱周杰伦我超级爱周杰伦我超级爱周杰伦我超级爱周杰伦",
                "我超级爱邓紫棋我超级爱邓紫棋我超级爱邓紫棋我超级爱邓紫棋"
            )
        )
    }
}