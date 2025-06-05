import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

	public static void main(String[] args) {
		// Create frame and add text area
    	JFrame frame = new JFrame("Emotion Analyzer");
        JTextArea textArea = new JTextArea();
        frame.add(textArea);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Tracks time of the last key press to measure typing speed
        final long[] lastKeyTime = {System.nanoTime()};
        
        // Tracks how often backspace is pressed (as an error indicator)
        final int[] backspaceCount = {0};

        textArea.addKeyListener(new KeyListener() {
        	@Override
            public void keyTyped(KeyEvent e) {
            	// unsued
            }

        	@Override
        	public void keyPressed(KeyEvent e) {
        		long now = System.nanoTime();
        		long diffMillis = (now - lastKeyTime[0]) / 1_000_000;

        		lastKeyTime[0] = now;

        		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        			backspaceCount[0]++;
        		}

        		// Simple mood estimation based on typing speed
        		String mood;
        		if (diffMillis < 300) {
        			mood = " Calm";
        		} else if (diffMillis < 1000) {
        			mood = " Normal";
        		} else {
        			mood = " Stressed";
        		}
        		
        		// Print mood and error count to console
        		System.out.printf("Pause: %dms | Mood: %s | Errors: %d%n", diffMillis, mood, backspaceCount[0]);
        	}

        	@Override
        	public void keyReleased(KeyEvent e) {
        		// unused
        	}
        });
    }
}
