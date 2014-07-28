/*
 * Ismet Said Calik
 * http://ismetsaidcalik.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pi4j.component.lcd.LCDTextAlignment;
import com.pi4j.component.lcd.impl.GpioLcdDisplay;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class lcd {
	// LCD pin setup
	public final static int LCD_ROWS = 2;
	public final static int LCD_ROW_1 = 0;
	public final static int LCD_ROW_2 = 1;
	public final static int LCD_COLUMNS = 16;
	public final static int LCD_BITS = 4;
	public static void main(String args[]) throws InterruptedException {
		System.out.println("GPIO 4 bit LCD example program");
		final GpioController gpio = GpioFactory.getInstance();
		// initialize LCD
		final GpioLcdDisplay lcd = new GpioLcdDisplay(LCD_ROWS, // number of row
																// supported by
																// LCD
				LCD_COLUMNS, // number of columns supported by LCD
				RaspiPin.GPIO_11, // LCD RS pin
				RaspiPin.GPIO_10, // LCD strobe pin
				RaspiPin.GPIO_00, // LCD data bit 1
				RaspiPin.GPIO_01, // LCD data bit 2
				RaspiPin.GPIO_02, // LCD data bit 3
				RaspiPin.GPIO_03); // LCD data bit 4
		// clear LCD
		lcd.clear();
		Thread.sleep(1000);
		// write line 1 to LCD
		lcd.write(LCD_ROW_1, "- RPi LCD Java -");
		// write line 2 to LCD
		lcd.write(LCD_ROW_2, "github/iscalik");
		Thread.sleep(3000);
		// line data replacement
		for (int index = 0; index < 5; index++) {
			lcd.write(LCD_ROW_2, "----------------");
			Thread.sleep(500);
			lcd.write(LCD_ROW_2, "****************");
			Thread.sleep(500);
		}
		lcd.write(LCD_ROW_2, "----------------");
		// single character data replacement
		for (int index = 0; index < lcd.getColumnCount(); index++) {
			lcd.write(LCD_ROW_2, index, ">");
			if (index > 0)
				lcd.write(LCD_ROW_2, index - 1, "-");
			Thread.sleep(300);
		}
		for (int index = lcd.getColumnCount() - 1; index >= 0; index--) {
			lcd.write(LCD_ROW_2, index, "<");
			if (index < lcd.getColumnCount() - 1)
				lcd.write(LCD_ROW_2, index + 1, "-");
			Thread.sleep(300);
		}
		// left alignment, full line data
		lcd.write(LCD_ROW_2, "----------------");
		Thread.sleep(500);
		lcd.writeln(LCD_ROW_2, "<< LEFT");
		Thread.sleep(1000);
		// right alignment, full line data
		lcd.write(LCD_ROW_2, "----------------");
		Thread.sleep(500);
		lcd.writeln(LCD_ROW_2, "RIGHT >>", LCDTextAlignment.ALIGN_RIGHT);
		Thread.sleep(1000);
		// center alignment, full line data
		lcd.write(LCD_ROW_2, "----------------");
		Thread.sleep(500);
		lcd.writeln(LCD_ROW_2, "<< CENTER >>", LCDTextAlignment.ALIGN_CENTER);
		Thread.sleep(1000);
		// mixed alignments, partial line data
		lcd.write(LCD_ROW_2, "----------------");
		Thread.sleep(500);
		lcd.write(LCD_ROW_2, "<L>", LCDTextAlignment.ALIGN_LEFT);
		lcd.write(LCD_ROW_2, "<R>", LCDTextAlignment.ALIGN_RIGHT);
		lcd.write(LCD_ROW_2, "CC", LCDTextAlignment.ALIGN_CENTER);
		Thread.sleep(1000);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		// update time
		while (true) {
			// write time to line 2 on LCD
			lcd.writeln(LCD_ROW_2, formatter.format(new Date()),
					LCDTextAlignment.ALIGN_CENTER);
			Thread.sleep(1000);
		}
	}
}
