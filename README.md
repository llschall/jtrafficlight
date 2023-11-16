Plug a traffic light to an Arduino board and control it from your Java application.

# Deployment

## Java

* If you use Gradle, add the following dependency to your **build.gradle** file:

_implementation 'io.github.llschall:jtrafficlight:1.0.0'_

* Or if you do not use Gradle, you can download the jar from the page hereafter, and add it to your classpath.
  
https://repo.maven.apache.org/maven2/io/github/llschall/jtrafficlight/1.0.0

## Arduino

Download the **jtrafficlight_ino.zip** file from the page hereafter. Unzip and load it (without any modification) to your Aduino Board using the standard Arduino IDE.

https://github.com/llschall/jtrafficlight/releases/tag/v1.0.0

# JTrafficLight API

Everything is controlled from the Java side, no changes are required in the Arduino code.

![](https://github.com/llschall/jtrafficlight/blob/main/jtrafficlight_512.bmp?raw=true)
