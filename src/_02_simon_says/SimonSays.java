package _02_simon_says;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SimonSays extends KeyAdapter {

	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int imageIndex;
	private int tries = 0;
	private boolean simonSays = false;
	Date timeAtStart;
int points=0;
	// Complete steps 1 - 7 before you test
	// 1. Declare a JFrame variable
	JFrame frame=new JFrame();
	public void run() {
		// 2. Add the four images that match keyboard keys like this:
		images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "down.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "right.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "left.jpg");
		// 3. Use a JOptionPane to tell the user the rules: "Press the matching
		// key when
		// 'Simon says' otherwise press a different key"
		JOptionPane.showMessageDialog(null, "Press the matching  key when" +" Simon says otherwise press a different key");
				
					
		// 4. Call the showImage method to show an image
		showImage();
	}

	public void keyPressed(KeyEvent e) {
		// 15. Make a points variable to track the score.
		
		
		// 16. If the keyCode matches the imageIndex and "Simon says"
if (simonSays==true&&imageIndex==e.getKeyCode()) {
	points+=1;

		// 17. Increase the value of score

		// 18. Use the speak method to tell the user they were correct
	JOptionPane.showMessageDialog(null, "RIGHT");
}
		// 19. If the keyCode doesn't match the imageIndex and "Simon didn't
		// say..."
if (simonSays==false&&imageIndex!=e.getKeyCode()) {
	points+=1;
	
	JOptionPane.showMessageDialog(null, "Simon didnt say that, but I'll give it a point");
}
		// 20. Increase the value of score

		// 21. Use the speak method to tell the user they were correct

		// 22. Increment tries by 1

		// 25. If tries is greater than 9 (or however many you want)...

		// 26. Tell the user their score

		// 27. Exit the program

		// 23. Dispose of the frame

		// 24. Call the showImage method to show a new image
	}

	private void showImage() {
		// 5. Initialize your frame to a new JFrame()
		
		// 6. Set the frame to visible
		frame.setVisible(true);
		// 7. Uncomment the following line to add a random image to your frame
		frame.add(getNextRandomImage());
		
		// 8. Set the name of your frame
		frame.setTitle("Image");
		// 9. Pack the frame
		frame.pack();
		// 10. Set the defaultCloseOperation of your frame to
		// JFrame.EXIT_ON_CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 11. Add a key listener to the frame
		frame.addKeyListener(this);
		// 12. Create a new instance of Random
	Random random= new Random();
		// 13. Use the Random and the speak method to either say
		// "Simon says press this key" or "Press this key"
	
	simonSays=random.nextBoolean();
	if (simonSays==true) {
		
	
	JOptionPane.showMessageDialog(null, "Simon says press this key");
	}else {
		
		JOptionPane.showMessageDialog(null, " press this key");
	}
		// 14. Above, set the value of simonSays to true/false appropriately

	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 * BONUS! Add a timer : ~~~ where the code starts running ~~~ timeAtStart =
 * newDate();
 *
 * ~~~ where the code ends ~~~ Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
