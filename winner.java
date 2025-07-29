import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class winner {
  winner(){
	  JFrame frame = new JFrame();
	   frame.setSize(1440,960);
	   frame.setLayout(null);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setResizable(false);
	   
	   JButton playagain = new JButton("Play Again");
	   playagain.setBounds(570, 680,300, 80);
	   playagain.setFont(new Font("Lato", Font.BOLD, 30));
	   playagain.setBorder(BorderFactory.createLineBorder(Color.white, 5));
	   playagain.setForeground(Color.white);
	   playagain.setBackground(new Color(52,199,89));
	   frame.add(playagain);
	   
	   playagain.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new NextPage();
		}
	});
	   
	   ImageIcon bgicon = new ImageIcon("image/Winner.jpg");
		  
	   JLabel backGround = new JLabel();
	   backGround.setBounds(0, 0, 1440, 960);
	   backGround.setIcon(bgicon);
	   frame.add(backGround);
	   
	   frame.setVisible(true);
  }
}
