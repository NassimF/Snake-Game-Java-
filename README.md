# Snake-Game-Java-
The classic Snake Game made using Java.
## Some of the libraries and classes used in this project
* javax.swing.*;
* java.awt.*;
* java.awt.image.*;
* java.awt.event.ActionListener;
* java.awt.event.KeyAdapter;
* java.awt.event.ActionEvent;
* java.awt.event.KeyListener;
* java.awt.event.KeyEvent;
* import java.awt.Color;
* import java.awt.Dimension;
* import java.awt.Graphics;
 ## Description
* The game consists of two primary classes: "main" and "snakeGame". 
* The "main" class takes the initial speed of the snake, as well as, the preferred width and height of the game window from the command line.
It also initilises the game components and starts everything.
* The snakeGame class includes the game settings and mechanics.
* It includes the keyboard listeners and controls the snake movements, food and block generation, and updating snake size.
* This class uses the Timer class; as soon as the timer is reset, the game graphics are updated on the JPanel, as a result the movement of the game elements can be percieved.
* In the beginning, the "initGame" method initialises the game.
* A variable named "inGame" is used to alert the end of the game; at each update, this variable is checked, if it equals 'false' then the timer stops, every thing gets disabled, and player score will be displayed on the screen

