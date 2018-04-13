package net.tophatfox.jAutoBot;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.im.InputContext;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestMain implements KeyListener {

	public static void main(String[] args) {
		new TestMain();
	}

	public TestMain() {

		//showKeyTestWindow();

		try {
			AutoBot bot = new AutoBot();
			
			InputContext ic = InputContext.getInstance();
			
			bot.mouseMove(1300, 200);

			bot.leftClick();

			//bot.typeText("asdf asdf\ntest");

			for (Character c : AutoBot.keyMap.keySet()) {
				bot.typeKey(AutoBot.keyMap.get(c));
				bot.typeKey(AutoBot.keyMap.get('\n'));
			}

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showKeyTestWindow() {
		JFrame keyTest = new JFrame("Key Tester");
		keyTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextArea testTA = new JTextArea(7, 20);
		testTA.addKeyListener(this);

		JScrollPane scrp = new JScrollPane(testTA);

		keyTest.add(scrp);
		keyTest.pack();
		keyTest.setLocationRelativeTo(null);
		keyTest.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar() + " " + KeyEvent.getKeyText(e.getKeyCode()));

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
