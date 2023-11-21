![image](https://github.com/llschall/jtrafficlight/blob/main/doc/jtrafficlight_512.bmp?raw=true)

Plug a traffic light to an Arduino board and control it from your Java application.

<img src="https://github.com/llschall/jtrafficlight/blob/main/doc/20231118_182137.jpg" width="400" height="400">

# Deployment

## Java

* If you use Gradle, add the following dependency to your **build.gradle** file:

_implementation 'io.github.llschall:jtrafficlight:1.0.2'_

* Or if you do not use Gradle, you can download the jar from the page hereafter, and add it to your classpath.
  
https://repo.maven.apache.org/maven2/io/github/llschall/jtrafficlight/1.0.2

## Arduino

Download the **jtrafficlight_ino.zip** file from the page hereafter. Unzip and load it (without any modification) to your Aduino Board using the standard Arduino IDE.

https://github.com/llschall/jtrafficlight/releases/tag/v1.0.2

Plug your traffic light as follows:
- Connect the GNDs together
- Connect Arduino pin D2 to the red led
- Connect Arduino pin D3 to the yellow led
- Connect Arduino pin D4 to the green led

<img src="https://github.com/llschall/jtrafficlight/blob/main/doc/20231118_182622.jpg" width="400" height="400">

# JTrafficLight Java API

Everything is controlled from the Java side, no changes are required in the Arduino code.

See code example:
https://github.com/llschall/jtrafficlight/blob/main/src/main/java/org/llschall/jtrafficlight/LightCheck.java
