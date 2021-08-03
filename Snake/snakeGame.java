//Created By Nasim Faridnia and Kimia afzalzadeh

import javax.swing.*;



import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;



import javax.swing.ImageIcon;


public  class snakeGame extends JPanel implements ActionListener {
	
	//fpr directions
	 private boolean left = false;
	    private boolean right = true;
	    private boolean up = false;
	    private boolean down = false;
	   

	
	

	// for game 
	   private boolean inGame=true;
	   private Timer timer;
	   private int _speed ;
	private int _width;
	private int _height;
	  
	
	
	//snake
	 private final int _v=10;//ax,ay
			private  int totalSize=9999999;
			private final int x[]=new int[totalSize];
			public final int y[]=new int[totalSize];
			public  int  size;//initial size		   
		   public Image body;
		    public Image head;
	
	
	
		
		//food
		public  int _xFood;
		public  int _yFood;
		public  Image _imgfood;
		
	
		
		//block
		public int _xblock;
		public int _yblock;
		public Image block;
		
		
		
	//constructor
	public snakeGame(int speed,int height,int width) {
		 addKeyListener(new KeyListener() {
			
		        public void keyPressed(KeyEvent e) {

		            int key = e.getKeyCode();

		            if ((key == KeyEvent.VK_LEFT) && (!right)) {// make sure snake wasn't going right
		                left = true;
		                up = false;
		                down = false;
		            }

		            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
		                right = true;
		                up = false;
		                down = false;
		            }

		            if ((key == KeyEvent.VK_UP) && (!down)) {
		                up = true;
		                right = false;
		                left = false;
		            }

		            if ((key == KeyEvent.VK_DOWN) && (!up)) {
		                down = true;
		                right = false;
		                left = false;
		            }
		        }

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
		});
		_speed=speed;
		_height=height;
		_width=width;
		setFocusable(true);		
		setPreferredSize(new Dimension(_height,_width));		
		setBackground(Color.CYAN);	
	loadImage();
	initGame();
			
	}
	
	
	
	//load the image
	public void loadImage() {
		
		//for apple
		    ImageIcon imgFood=new ImageIcon("food.png");
		_imgfood=imgFood.getImage();
		
		
		//for Snake
        ImageIcon I1 = new ImageIcon("body.png");
        body = I1.getImage();
        ImageIcon I2 = new ImageIcon("head.png");
        head = I2.getImage();
		
        
        //for block
        ImageIcon imgblock=new ImageIcon("block.png");
        block=imgblock.getImage();
	}
	
	//draw the apple
	@Override
		public void paintComponent(Graphics g) {//redraw when user interacts
	        super.paintComponent(g);
	        Draw(g);
	        if(!inGame) {
	        	
					g.drawString("Game Over ",130,150);
									g.drawString("Score:"+size, 130, 170);
	        }
	    }

			public void Draw(Graphics g) {														
				if(inGame==true){
				g.drawImage(_imgfood, _xFood, _yFood, this);
				g.drawImage(block, _xblock, _yblock, this);
	        for(int i=0;i<size;i++){
	            if(i==0)
	                g.drawImage(head, x[i], y[i], this);
	           
	            else
	                g.drawImage(body, x[i], y[i], this);  
	   
	        }        
							
				}
		}
		
	
	
//Locate the apple
	public void locateFood() {
		_xFood=(int)(Math.random()*50*size);
		_yFood=(int)(Math.random()*50*size);	
		if((_xFood>=280)||(_yFood>=280)||(_xFood<=20)||(_yFood<=20))// if location is out of bounds
	locateFood();
		
	} 	
	
	
	

	//check if apple has been eaten
	public void checkEat() {
		if((_xFood-20<x[0])&&((_xFood+20)>x[0])&&((_yFood-20)<y[0])&&((_yFood+20)>y[0])) {
			size=size+1;
			locateFood();
			locateBlock();
		}
	}

	
			//action event after timer starts
			@Override
			public void actionPerformed(ActionEvent e) {
				if (inGame) {
					checkEat();
					GameOver();      		            		    
		            move();
		            
		        }

		        repaint();//update graphics
				
			}

			//movement
			private void move() {

		        for (int z = size; z > 0; z--) {
		            x[z] = x[(z - 1)];
		            y[z] = y[(z - 1)];
		        }
		
		        if (left) {
		            x[0] -= _v;
		        }

		        if (right) {
		            x[0] += _v;
		        }

		        if (up) {
		            y[0] -= _v;
		        }

		        if (down) {
		            y[0] += _v;
		        }
		    }

		//start
			public void initGame() {

		     size=4;

		        for (int z = 0; z < size; z++) {
		            x[z] = 10 - z * 10;
		            y[z] = 50;

		        }
		 
		        locateFood();
locateBlock();
		        timer =new Timer (_speed,this);//for updating animation
		       timer.start();
		       
		    }
			
			  
			//locate the block
			public void locateBlock() {
				_xblock=(int)(Math.random()*120*size);
				_yblock=(int)(Math.random()*120*size);	
				if((_xblock>=280)||(_yblock>=280)||(_xblock<=20)||(_yblock<=20))// if location is out of bounds
			locateBlock();	
				if((_xblock==_xFood)&&(_yblock==_yFood))//if apple and block collide
					locateBlock();
			}
			
			
	
	    public void GameOver(){
	        for (int z = size; z > 0; z--) {
	            if ((z > 4) && (x[0] ==x[z]) && (y[0] == y[z]))//if snake head hits the body
	                inGame = false;
	        }
	            if(x[0]>=_width-5 || y[0]>=_height-5 || y[0]<0 || x[0]<0)//if snake crosses the boundaries 
	                inGame = false;
	            if((_xblock-20<x[0])&&((_xblock+20)>x[0])&&((_yblock-20)<y[0])&&((_yblock+20)>y[0]))
	            	inGame=false;//if snake hits the block
	            if(!inGame) {
	                timer.stop();    
	        }
	        }
		
	
	
}
