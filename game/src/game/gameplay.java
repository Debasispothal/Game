/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 1602366
 */
public class gameplay extends JPanel implements KeyListener,ActionListener {
    private int play=0;
    private int paposx=180;
    private int papost=330;
    private int paposy=0;
    
    private int ballposx=100;
    private int ballposy=400;
    
    private int balldirx=-1;
    private int balldiry=-1;
    
    private Timer timer;
    private int delay=5;
    private map ma;
    
    private int row=5;
    private int col=7;
    private int totalbrick=0;
    private int score=0;
    
    private int brickwidth;
    private int brickheight;
    
    private int map[][];
    
    private int level=1;
    public gameplay(){
         map=new int[row][col];
         
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                
                map[i][j]=1;
                totalbrick++;
                
            }
        }
         brickwidth=540/row;
        brickheight=150/col;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
    }
    
    public void paint(Graphics g){
        
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 792);
        
        g.setColor(Color.red);
        g.fillRect(paposx, 750, 5, 40);
        g.fillRect(paposx, 750, 150, 02);
        g.fillRect(papost, 750, 5, 40);
        
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Level "+level, 300, 40);
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(map[i][j]==1){
                    g.setColor(Color.white);
                    g.fillRect(i*brickwidth+50, j*brickheight+50, brickwidth, brickheight);
                    
                    //g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(i*brickwidth+50, j*brickheight+50, brickwidth, brickheight);
                }
            }
        }
        

        g.setColor(Color.green);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Score: "+score, 600, 50);
        
        if(totalbrick==0){
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 35));
        g.drawString("CONGO YOU WON THE GAME!!! ", 50, 350);
            g.drawString("Press number(2)Level2 ", 50, 460);
            g.drawString("Press number(3)Level3 ", 50, 490);
            g.drawString("Press number(4)Level4 ", 50, 520);
            g.drawString("Press number(5)Level5", 50, 550);
        }
        
        if(ballposy>790){
            balldirx=0;
            balldiry=0;
            
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 35));
        g.drawString("Sorry game over \nTry again press enter", 50, 350);
        }
        
        g.setColor(Color.BLUE);
        g.fillOval(ballposx, ballposy, 25, 25);
        
        g.dispose();
    }
    
@Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play==1){
            ballposx+=balldirx;
            ballposy+=balldiry;
            if(new Rectangle(ballposx,ballposy,25,25).intersects(new Rectangle(paposx, 750, 150, 02))){
             balldiry=-balldiry;
             
            }
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(map[i][j]==1){
                        Rectangle r1=new Rectangle(i*brickwidth+50, j*brickheight+50, brickwidth, brickheight);
                        Rectangle r2= new Rectangle(ballposx,ballposy,25,25);
                        if(r2.intersects(r1)){
                            map[i][j]=0;
                            totalbrick--;
                            score++;
                            
                            balldiry=-balldiry;
                            repaint();
                        }
                    }
                }
            }
                
            if(ballposx<=0){
                balldirx=-balldirx;
            }
            if(ballposy<=0){
                balldiry=-balldiry;
                
            }
            if(ballposx>=681){
                balldirx=-balldirx;
            }
          
            
        }
        repaint();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyTyped(KeyEvent e) {
  
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(papost>681){
                papost=681;
                paposx=531;
            }
            papost+=10;
            paposx+=10;
            play=1;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(paposx<0){
                paposx=0;
                papost=150;
            }
             papost-=10;
            paposx-=10;
            play=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_2){
            if(play==1){
                  play=0;
    paposx=180;
     papost=330;
     paposy=0;
    
    ballposx=100;
     ballposy=400;
    
         balldirx=-1;
         balldiry=-1;
         score=0;
         totalbrick=0;
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                 if(i%2==0){
                 map[i][j]=1;
                 totalbrick++;
                 }
                 else{
                     map[i][j]=0;
                 }
             }
               
         }
         level=2;
         repaint();
           }
        }
        
         if(e.getKeyCode()==KeyEvent.VK_3){
            if(play==1){
                  play=0;
    paposx=180;
     papost=330;
     paposy=0;
    
    ballposx=100;
     ballposy=400;
    
         balldirx=-1;
         balldiry=-1;
         score=0;
         totalbrick=0;
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                 if(j%2==0){
                 map[i][j]=1;
                 totalbrick++;
                 }
                 else{
                     map[i][j]=0;
                 }
             }
               
         }
         level=3;
         repaint();
           }
        }
        
          if(e.getKeyCode()==KeyEvent.VK_4){
            if(play==1){
                  play=0;
    paposx=180;
     papost=330;
     paposy=0;
    
    ballposx=100;
     ballposy=400;
    
         balldirx=-1;
         balldiry=-1;
         score=0;
         totalbrick=0;
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                 if(i%2==0){
                     if(j%2==0){
                 map[i][j]=1;
                 totalbrick++;
                     }
                     else{
                         map[i][j]=0;
                     }
                 }
                 else{
                     if(j%2!=0){
                         map[i][j]=1;
                 totalbrick++;
                     }
                     else{
                         map[i][j]=0;
                     }
                 }
             }
               
         }
         level=4;
         repaint();
           }
        }
          
           if(e.getKeyCode()==KeyEvent.VK_5){
            if(play==1){
                  play=0;
    paposx=180;
     papost=330;
     paposy=0;
    
    ballposx=100;
     ballposy=400;
    
         balldirx=-1;
         balldiry=-1;
         score=0;
         totalbrick=0;
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                 if(i>=j){
                 map[i][j]=1;
                 totalbrick++;
                 }
                 else{
                     map[i][j]=0;
                 }
             }
               
         }
         level=5;
         repaint();
           }
        }
        
          if(e.getKeyCode()==KeyEvent.VK_ENTER){
           if(play==1){
                  play=0;
    paposx=180;
     papost=330;
     paposy=0;
    
    ballposx=100;
     ballposy=400;
    
         balldirx=-1;
         balldiry=-1;
         score=0;
         totalbrick=0;
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                 map[i][j]=1;
                 totalbrick++;
             }
               
         }
         repaint();
           }
       }
        
        //repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
     
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
