RPi LCD Java
============

Raspberry Pi LCD Project (coded with Java)

Installation
----------------

Dependencies
*Install JRE/JDK*

If you have not already installed a Java runtime environment, please see the following article for a complete set of installation instructions for installing the Oracle JDK.

*WiringPi Native Library*

Pi4J depends on the WiringPi native library by Gordon Henderson. Please see the following page for more information on WiringPi.
https://projects.drogon.net/raspberry-pi/wiringpi/download-and-install/

No installation is required for Wiring Pi. Wiring Pi is embedded in the Pi4J native library.

**Pi4J**
--------

*Install Pi4J*

Download a copy of the latest Pi4J Debian/Raspian installer package (.deb) file. You can use the following command on the Raspberry Pi's console to download the latest pi4j.jar build:
wget http://pi4j.googlecode.com/files/pi4j-0.0.5.deb

*NOTE: If you have a previous version of Pi4J installed, please uninstall it first.*

*Once downloaded, use the following command to perform the installation:*

sudo dpkg -i pi4j-0.0.5.deb

*This will install the Pi4J libraries and example source files to:*

/opt/pi4j/lib
/opt/pi4j/examples

*When attempting to compile a Java program using the Pi4J libraries, make sure to include the Pi4J lib folder in the classpath:*

javac -classpath .:classes:/opt/pi4j/lib/'*' ...

*When attempting to start a Java program using the Pi4J libraries, make sure to include the Pi4J lib folder in the classpath:*

sudo java -classpath .:classes:/opt/pi4j/lib/'*' ...

*If you would like to explore the examples, you can compile all the examples with the following commands:*

cd /opt/pi4j/examples
./build
*Uninstall Pi4J*

*To uninstall Pi4J from your Raspberry Pi, use the following command:*

sudo dpkg -r pi4j

**Pin Numbering**
-----------------

![Pin Numbering][1]
![Pin Numbering][2]


**LCD Pin Numbering**
-----------------

![LCD Pin Numbering][3]

**Wiring Diagram**
------------------

![Wiring Diagram][4]



**Navigate**

If you have not already downloaded and installed the Pi4J library on the RaspberryPi, then view this page for instructions on where to download and how to install Pi4J:

*Download & Install Pi4J*

First, locate the GPIO_Control.java source file in the samples folder of the Pi4J installation on the RaspberryPi.

*You can use the following command on the Pi's console or SSH terminal to navigate to this path:*

cd /opt/pi4j/examples

**Compile**
-----------

*Next, use the following command to compile this example program:*

javac -classpath .:classes:/opt/pi4j/lib/'*' -d . lcd.java

**Execute**
-----------

*The following command will run this example program:*

sudo java -classpath .:classes:/opt/pi4j/lib/'*' lcd


İsmet Said Çalık

[WebSite][5]


  [1]: https://raw.githubusercontent.com/iscalik/RPi_LCD_Java/master/pin_header_pics/p1header.png
  [2]: https://raw.githubusercontent.com/iscalik/RPi_LCD_Java/master/pin_header_pics/p5header.png
  [3]: https://raw.githubusercontent.com/iscalik/RPi_LCD_Java/master/pinout-lcd-16x2-2x16-hd44780-2.gif
  [4]: https://raw.githubusercontent.com/iscalik/RPi_LCD_Java/master/rpi_lcd_java_wiring.png
  [5]: http://ismetsaidcalik.com
