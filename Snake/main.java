import javax.swing.*;




import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class main extends javax.swing.JFrame{
	
	public static void main(String[] args) {
				
	int speed =Integer.parseInt(args[0]);
	int height=Integer.parseInt(args[1]);
	int width=Integer.parseInt(args[2]);
		
		JFrame frame =new JFrame();
		snakeGame s=new snakeGame(speed,height,width);
		frame. add(s);
		frame. setResizable(false);
	       frame.pack();//size compatible to components
	       frame. setTitle("Snake");
	        frame.setVisible(true);
	       frame.setLocationRelativeTo(null);// in the middle of the screen	      
	        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);			
					
	        
}

	
}
	