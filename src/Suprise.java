import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Suprise implements ActionListener {
	JFrame frame=new JFrame();
	JButton trick=new JButton("Trick");
	JButton treat=new JButton("treat");
	JPanel panel=new JPanel();
	
	Suprise(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(trick);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		
		
		panel.add(treat);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		
		trick.addActionListener(this);
		treat.addActionListener(this);
	}
	
public static void main(String[] args) {
	
	
	
	Suprise suprise=new Suprise();
	
	
	
	 
	
	
}

private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource()==treat) {
		showPictureFromTheInternet("https://i.pinimg.com/originals/7e/84/53/7e84532f5d61ee19ca5b7a97a9618ea4.jpg");
	}
if (e.getSource()==trick) {
		showPictureFromTheInternet("https://i.ytimg.com/vi/YeBFvp7clnk/maxresdefault.jpg");
	}
	
}
}