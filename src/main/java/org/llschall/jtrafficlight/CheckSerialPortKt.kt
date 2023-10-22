package org.llschall.jtrafficlight

import org.llschall.jtrafficlight.model.JTrafficLight
import org.llschall.jtrafficlight.model.LightMode

/**
 * A class to check the serial connection
 */
object CheckSerialPortKt {
    /**
     * @param args No args supported
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val trafficLight = JTrafficLight()
        trafficLight.openPort()
        println("*** Check Serial Port ***")
        println("***      all off      ***")
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF, LightMode.OFF)
        delay()
        println("***     red only      ***")
        trafficLight.switchMode(LightMode.ON, LightMode.OFF, LightMode.OFF)
        delay()
        println("***    yellow only    ***")
        trafficLight.switchMode(LightMode.OFF, LightMode.ON, LightMode.OFF)
        delay()
        println("***    green only     ***")
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF, LightMode.ON)
        delay()
        println("***      all on       ***")
        trafficLight.switchMode(LightMode.ON, LightMode.ON, LightMode.ON)
        println("***  Check Finished   ***")
    }

    private fun delay() {
        try {
            Thread.sleep(4000)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
    }
}
