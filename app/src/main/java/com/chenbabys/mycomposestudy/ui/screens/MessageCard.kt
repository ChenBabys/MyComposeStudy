package com.chenbabys.mycomposestudy.ui.screens

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chenbabys.mycomposestudy.R

/**
 * Created by ChenYesheng On 2021/11/2 15:35
 * Desc:
 */
@Composable
fun MessageCard(msg: String) {
    val context = LocalContext.current
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            Toast
                .makeText(context, "点击了${msg}", Toast.LENGTH_SHORT)
                .show()
        }
        .fillMaxSize()) {
        Image(
            painter = painterResource(id = R.mipmap.ic_image_one),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                .scale(2f)//缩放*2
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpand by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            if (isExpand) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )

        Column(modifier = Modifier.clickable { isExpand = !isExpand }) {
            Text(
                text = msg,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpand) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }

}