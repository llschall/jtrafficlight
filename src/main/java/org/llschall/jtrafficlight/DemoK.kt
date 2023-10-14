package org.llschall.jtrafficlight

import org.llschall.jtrafficlight.model.LightMode
import org.llschall.jtrafficlight.model.TrafficLight

object DemoK {
    @JvmStatic
    fun main(args: Array<String>) {
        val trafficLight = TrafficLight()
        trafficLight.openPort()
        trafficLight.switchMode(LightMode.ON, LightMode.ON, LightMode.ON)
        delay(2)
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF, LightMode.ON)
        delay(1)
        trafficLight.switchMode(LightMode.OFF, LightMode.ON, LightMode.OFF)
        delay(1)
        trafficLight.switchMode(LightMode.ON, LightMode.OFF, LightMode.OFF)
        delay(1)
        trafficLight.switchMode(LightMode.ON, LightMode.ON, LightMode.ON)
    }

    fun delay(seconds: Long) {
        try {
            Thread.sleep(1000 * seconds)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
    }
}
