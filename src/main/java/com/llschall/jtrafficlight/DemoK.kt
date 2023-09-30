package com.llschall.jtrafficlight

import com.llschall.jtrafficlight.model.LightMode
import com.llschall.jtrafficlight.model.TrafficLight

object DemoK {
    @JvmStatic
    fun main(args: Array<String>) {
        val trafficLight = TrafficLight()
        trafficLight.openPort()
        trafficLight.switchMode(LightMode.ON, LightMode.ON, LightMode.ON)
        trafficLight.sendToPort()
        delay(2)
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF, LightMode.ON)
        trafficLight.sendToPort()
        delay(1)
        trafficLight.switchMode(LightMode.OFF, LightMode.ON, LightMode.OFF)
        trafficLight.sendToPort()
        delay(1)
        trafficLight.switchMode(LightMode.ON, LightMode.OFF, LightMode.OFF)
        trafficLight.sendToPort()
        delay(1)
        trafficLight.switchMode(LightMode.ON, LightMode.ON, LightMode.ON)
        trafficLight.sendToPort()
    }

    fun delay(seconds: Long) {
        try {
            Thread.sleep(1000 * seconds)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
    }
}
