/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JFrame;

/**
 *
 * @author 1602366
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame obj=new JFrame();
        gameplay gm=new gameplay();
        obj.setBounds(10,10,700,800);
        obj.setTitle("brick game");
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setLocationRelativeTo(null);
        obj.add(gm);
        obj.setVisible(true);
        // TODO code application logic here
    }
    
}
