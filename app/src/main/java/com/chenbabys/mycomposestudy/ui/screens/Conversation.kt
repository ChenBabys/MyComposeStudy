package com.chenbabys.mycomposestudy.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

/**
 * Created by ChenYesheng On 2021/11/2 15:55
 * Desc:
 */
@Composable
fun Conversation(messages: List<String>) {
    //用LazyColumn做列表
    LazyColumn {
        items(messages) { msg ->
            MessageCard(msg = msg)
        }
    }

}