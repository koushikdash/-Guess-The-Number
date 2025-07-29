import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NextPage {
	   int attempts = 7;
	   boolean isGameOver = false;
	   StringBuilder input = new StringBuilder();
	   Random rand = new Random();
  	   int  randomNumber;

       public NextPage() {
	  
	   randomNumber = rand.nextInt(100)+1;
	   
	   JFrame frame = new JFrame();
	   frame.setTitle("Number Guessing");
	   frame.setSize(1440,960);
	   frame.setLayout(null);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setResizable(false);
	   
	   
//	   JTextArea screen = new JTextArea();
//	   screen.setBackground(Color.black);
	   
	   JTextField displayField = new JTextField();
	   displayField.setEditable(false);
	   displayField.setHorizontalAlignment(JTextField.CENTER);
	   displayField.setBounds(570, 200, 300, 200);
	   displayField.setFont(new Font("Lato", Font.BOLD, 120));
	   displayField.setBorder(BorderFactory.createLineBorder(Color.white, 5));
	   displayField.setBackground(new Color (255,165,0));
	   displayField.setForeground(Color.white);
	   frame.add(displayField);
	   
	   JButton[] numberCards = new JButton[10];
        for(int i = 0; i<10; i++) {
    	 
    	   numberCards[i] = new JButton(String.valueOf(i));
    	   numberCards[i].setBounds(285+(i*90), 450, 77, 116);
    	   numberCards[i].setFont(new Font("Lato", Font.BOLD,80));
    	   numberCards[i].setBorder(BorderFactory.createLineBorder(Color.white, 5));
    	   numberCards[i].setBackground(new Color (255,165,0));
    	   numberCards[i].setForeground(Color.white);
    	   
    	   String digit = String.valueOf(i);
    	   numberCards[i].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//String input = null;
				// TODO Auto-generated method stub
				if(input.length()<2) {
					input.append(digit);
					displayField.setText(input.toString());
				}
			}
		});
    	   
          frame.add(numberCards[i]);
           
          
       }
       
       JLabel feedback = new JLabel();
       feedback.setText("Pick any number between the Range & Guess The Number?");
       feedback.setFont(new Font("Lato",Font.BOLD,32));
       feedback.setForeground(Color.white);
       feedback.setBounds(310, 580, 900, 40);
       frame.add(feedback);
       
       JLabel headLine = new JLabel();
       headLine.setText("Guess The Number?");
       headLine.setFont(new Font("Lato",Font.BOLD,80));
       headLine.setForeground(Color.white);
       //headLine.setHorizontalAlignment(JLabel.CENTER);
       headLine.setBounds(360, 30, 730, 200);
       frame.add(headLine);
       
       
       
       JButton Guess = new JButton("Guess?");
       Guess.setBounds(570, 680,300, 80);
       Guess.setFont(new Font("Lato", Font.BOLD, 30));
       Guess.setBorder(BorderFactory.createLineBorder(Color.white, 5));
	   Guess.setForeground(Color.white);
       Guess.setBackground(new Color(52,199,89));
	   frame.add(Guess);
	   
	   
	   JLabel result = new JLabel("You have total 7 chances left");
	   result.setFont(new Font("Lato",Font.BOLD,16));
	   result.setForeground(Color.white);
	   result.setBounds(620, 750,300, 80);
	   frame.add(result);
	   
	   
	   
	   JButton restart = new JButton("Refresh");
	   restart.setBounds(1170, 80,200, 80);
	   restart.setFont(new Font("Lato", Font.BOLD, 30));
	   restart.setBorder(BorderFactory.createLineBorder(Color.white, 5));
	   restart.setForeground(Color.white);
	   restart.setBackground(new Color(0,192,232));
	   frame.add(restart);
	   
	   restart.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			new NextPage();
		   }
	    });
	   
	   Guess.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			     if (isGameOver) {
			    	 randomNumber = rand.nextInt(100) +1;
			    	 attempts = 0;
			    	 input.setLength(0);
			    	 displayField.setText("");
			    	 isGameOver = false;
			    	 Guess.setText("Guess?");
                     }
			
				try { 
					int guess = Integer.parseInt(displayField.getText());
					attempts --;
					
					if (guess<1 || guess>100) {
					JOptionPane.showMessageDialog(frame, "Enter a number between 1 and 100.");	
				    result.setText("You have total " + attempts+ " chances left");
				} else if (guess<randomNumber) {
					JOptionPane.showMessageDialog(frame, "Too low! Try again.");
					result.setText("You have total " + attempts+ " chances left");
				} else if(guess>randomNumber) {
					JOptionPane.showMessageDialog(frame, "Too High! Try again.");
					result.setText("You have total " + attempts+ " chances left");
               } else {
            	   JOptionPane.showMessageDialog(frame, "Correct!");
            	   frame.dispose();
            	    new winner();
		    
               //Guess.setText("Play Again");
               isGameOver = true;
		    
			} 
					if(attempts== 0) {
						JOptionPane.showMessageDialog(frame, "OOOPS!");
						frame.dispose();
					    new tryAgain();
					}
             
			} catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(frame, "New Game Started");
			} finally{
				input.setLength(0);
				displayField.setText("");
			   };
			 }
	      });
       
       
	   

	   
	   
	   
	   
	   ImageIcon bgicon = new ImageIcon("image/MainUi.jpg");
	  
	   JLabel backGround = new JLabel();
	   backGround.setBounds(0, 0, 1440, 960);
	   backGround.setIcon(bgicon);
	   frame.add(backGround);
	   
	   
	   
	   frame.setVisible(true);
   }
}
