
package net.tophatfox.jAutoBot;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class AutoBot extends Robot {

	public static HashMap<Character, Integer> keyMap = new HashMap<>();

	public AutoBot() throws AWTException {
		super();
		init();
	}

	public AutoBot(GraphicsDevice screen) throws AWTException {
		super(screen);
		init();
	}

	private void init() {
		keyMap.put(' ', KeyEvent.VK_SPACE);
		keyMap.put(',', KeyEvent.VK_COMMA);
		keyMap.put('.', KeyEvent.VK_PERIOD);
		keyMap.put(';', KeyEvent.VK_SEMICOLON);
		keyMap.put(':', KeyEvent.VK_COLON);
		keyMap.put('#', KeyEvent.VK_NUMBER_SIGN);
		keyMap.put('+', KeyEvent.VK_PLUS);
		keyMap.put('*', KeyEvent.VK_ASTERISK);
		keyMap.put('-', KeyEvent.VK_MINUS);
		keyMap.put('!', KeyEvent.VK_EXCLAMATION_MARK);
		keyMap.put('"', KeyEvent.VK_QUOTE);
		keyMap.put('_', KeyEvent.VK_UNDERSCORE);
		keyMap.put('$', KeyEvent.VK_DOLLAR);
		//keyMap.put('%', KeyEvent.VK_);
		//keyMap.put('&', KeyEvent.VK_);
		keyMap.put('/', KeyEvent.VK_SLASH);
		keyMap.put('\\', KeyEvent.VK_BACK_SLASH);
		keyMap.put('(', KeyEvent.VK_LEFT_PARENTHESIS);
		keyMap.put(')', KeyEvent.VK_RIGHT_PARENTHESIS);
		keyMap.put('[', KeyEvent.VK_BRACELEFT);
		keyMap.put(']', KeyEvent.VK_BRACERIGHT);
		keyMap.put('=', KeyEvent.VK_EQUALS);
		keyMap.put('€', KeyEvent.VK_EURO_SIGN);
		//keyMap.put('<', KeyEvent.VK_De);
		//keyMap.put('>', KeyEvent.VK_SPACE);

		keyMap.put('\n', KeyEvent.VK_ENTER);
		keyMap.put('\r', KeyEvent.VK_BACK_SPACE);
		keyMap.put('\t', KeyEvent.VK_TAB);
	}

	public void leftClick() {
		click(InputEvent.BUTTON1_DOWN_MASK, 50);
	}

	public void rightClick() {
		click(InputEvent.BUTTON2_DOWN_MASK, 50);
	}

	public void click(int button) {
		click(button, 50);
	}

	public void click(int button, int downTime) {
		this.mousePress(button);
		try {
			Thread.sleep(downTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mouseRelease(button);
	}

	public void typeKey(int key) {
		typeKey(key, 50);
	}

	public void typeKey(int key, int downTime) {
		System.out.println(KeyEvent.getKeyText(key));
		try {
			this.keyPress(key);
			try {
				Thread.sleep(downTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.keyRelease(key);
		} catch (IllegalArgumentException e) {

		}

	}

	public void typeText(String text) {
		typeText(text, 50);
	}

	public void typeText(String text, int downTime) {
		for (char c : text.toCharArray()) {
			if (Character.isUpperCase(c)) {
				keyPress(KeyEvent.VK_SHIFT);
			}
			if (Character.isAlphabetic(c)) {
				typeKey(Character.toUpperCase(c), downTime);
			} else {
				try {
					Integer.parseInt("" + c);
					typeKey(c, downTime);
				} catch (NumberFormatException e) {
					if (keyMap.containsKey(c)) {
						typeKey(keyMap.get(c), downTime);
					}
				}

			}
			if (Character.isUpperCase(c)) {
				keyRelease(KeyEvent.VK_SHIFT);
			}
		}
	}

}
