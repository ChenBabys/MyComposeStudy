package com.chenbabys.mycomposestudy.ui.screens

import android.os.Message
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by ChenYesheng On 2021/11/2 15:55
 * Desc:
 */
@Composable
fun Conversation(messages: List<String>) {
    //用LazyColumn做列表
    LazyColumn {
        items(messages) { msg ->
            Spacer(modifier = Modifier.height(1.dp))
            MessageCard(msg = msg)
        }
    }

}