/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author 1602366
 */
public class map {
    private int row;
    private int col;
    
    private int brickwidth;
    private int brickheight;
    
    private int map[][];
    
    public map(int row,int col){
        map=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                map[i][j]=1;
            }
        }
        brickwidth=340/row;
        brickheight=150/col;
    }
    public void draw(Graphics2D g){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(map[i][j]>0){
                    g.setColor(Color.white);
                    g.fillRect(i*brickwidth+50, j*brickheight+50, brickwidth, brickheight);
                    
                    /*g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(i*brickwidth+50, j*brickheight+50, brickwidth, brickheight);*/
                }
            }
        }
    }
}
