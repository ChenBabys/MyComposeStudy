package com.chenbabys.mycomposestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.chenbabys.mycomposestudy.ui.screens.*
import com.chenbabys.mycomposestudy.ui.theme.MyComposeStudyTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeStudyTheme {//添加MaterialTheme主题
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    //UILayout()
//
//                }

                //使用启动页Splash为先，然后再加载Home
                ProvideWindowInsets {
                    val (appState, setAppState) = remember { mutableStateOf(AppState.Splash) }
                    when (appState) {
                        AppState.Splash -> {
                            SplashScreen {
                                setAppState(AppState.Home)
                            }
                        }
                        AppState.Home -> {
                            HomeScaffold()
                        }
                    }
                }

            }
        }
    }
}

enum class AppState {
    Splash,
    Home
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@ExperimentalAnimationApi
@Composable
fun UILayout() {
    //卡片布局
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        elevation = 2.dp
    ) {
        var expands by remember { mutableStateOf(false) }
//        val imageone = ImageBitmap.imageResource(id = R.mipmap.ic_image_one)
//        val imagetwo = ImageBitmap.imageResource(id = R.mipmap.ic_image_two)
//        val imagethree = ImageBitmap.imageResource(id = R.mipmap.ic_image_three)

//        Image(painter = painterResource(id = R.mipmap.ic_image_one), contentDescription ="1" )
//        Image(painter = painterResource(id = R.mipmap.ic_image_two), contentDescription ="1" )
//        Image(painter = painterResource(id = R.mipmap.ic_image_three), contentDescription ="1" )

        //设置一个竖着的排列
        Column(modifier = Modifier.clickable { expands = !expands }) {
            Image(painter = painterResource(id = R.mipmap.ic_image_one), contentDescription = "图片底")
            AnimatedVisibility(visible = expands) {
                //添加一个16dp的间隔空间
                //Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.padding(15.dp)) {
                    Text(
                        text = "我超级爱周杰伦",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h3,//固定文本大小按照h3标准
//                        fontSize = 16.sp//直接设置文本大小
                    )
                    Text(
                        text = "我超级爱林俊杰",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h4
                    )
                    Text(
                        text = "我超级爱邓紫棋",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeStudyTheme {
        //UILayout()
    }
}
