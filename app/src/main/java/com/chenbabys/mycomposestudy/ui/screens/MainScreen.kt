package com.chenbabys.mycomposestudy.ui.screens

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.core.content.ContextCompat.getSystemService
import com.chenbabys.mycomposestudy.R

/**
 * Created by ChenYesheng On 2021/11/1 16:17
 * Desc:
 */

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val sensorManager: SensorManager? = getSystemService(context, SensorManager::class.java)
    val sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

    var xDistance by remember { mutableStateOf(0f) }
    var yDistance by remember { mutableStateOf(0f) }


    val imageBack = ImageBitmap.imageResource(id = R.mipmap.ic_image_one)
    val imageMiddle = ImageBitmap.imageResource(id = R.mipmap.ic_image_two)
    val imageFore = ImageBitmap.imageResource(id = R.mipmap.ic_image_three)
    //开始画
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
//        val canvasWidth = size.width
//        val canvasHeight = size.height
        translate(-xDistance, -yDistance) {
            drawImage(imageBack)
        }
        drawImage(imageMiddle)
        translate(xDistance, yDistance) {
            drawImage(imageFore)
        }
    })

    sensorManager?.registerListener(object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            //Y轴角速度
            val speedY = event?.values?.get(1)
            //X轴角速度
            val speedX = event?.values?.get(0)
            //Z轴角速度
            val speedZ = event?.values?.get(2)
            val mMaxAnular = 100L
            val maxOffset = 100f
            val timestamp = event?.timestamp?.toFloat()
            var angularX: Long = 0
            var angularY: Long = 0
            var angularZ: Long = 0
            var x: Float = 0f
            var y: Float = 0f
            var z: Float = 0f
            if (timestamp != 0f) {
                val dT = (event?.timestamp!! - timestamp!!)
                angularX += (event.values[0] * dT).toLong()
                angularY += (event.values[1] * dT).toLong()
                angularZ += (event.values[2] * dT).toLong()
                //设置x轴y轴最大边界值，
                if (angularY > mMaxAnular) {
                    angularY = mMaxAnular
                } else if (angularY < -mMaxAnular) {
                    angularY = -mMaxAnular
                }

                if (angularX > mMaxAnular) {
                    angularX = mMaxAnular
                } else if (angularX < -mMaxAnular) {
                    angularX = -mMaxAnular
                }
                val xRadio: Float = (angularY / mMaxAnular).toFloat()
                val yRadio: Float = (angularX / mMaxAnular).toFloat()
                xDistance = xRadio * maxOffset
                yDistance = yRadio * maxOffset

                x = Math.abs(event.values[0])
                y = Math.abs(event.values[1])
                z = Math.abs(event.values[2])

                if (x > y + z) {
                    xDistance = 0f
                    yDistance = yRadio * maxOffset
                } else if (y > x + z) {
                    xDistance = xRadio * maxOffset
                    yDistance = 0f}
            }

        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        }

    }, sensor, 20)


}


