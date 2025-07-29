import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class SwingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		JFrame frame = new JFrame();
		frame.setTitle("Number Guessing Game");
		frame.setSize(1440,960);
		frame.setLayout(new FlowLayout());
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    
	   JButton StartGame = new JButton("Start Game");
	   StartGame.setBounds(570, 680,300, 80);
	   StartGame.setFont(new Font("Lato", Font.BOLD, 30));

	   StartGame.setBorder(BorderFactory.createLineBorder(Color.white, 5));
	   StartGame.setForeground(Color.white);
	   StartGame.setBackground(new Color(52,199,89));
	   frame.add(StartGame);
	   
	   StartGame.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			new NextPage();
		}
	});
	   
	   ImageIcon icon1 = new ImageIcon("image/HeroPage.jpg");
	   
	   JLabel bgicon = new JLabel();
	   bgicon.setBounds(0, 0, 1440, 960);
	   bgicon.setIcon(icon1);
	   frame.add(bgicon);
	   
	   frame.setVisible(true);

     
	}

}
