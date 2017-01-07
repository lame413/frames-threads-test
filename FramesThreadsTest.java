/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames.threads.test;

import java.awt.Color;
import java.util.HashSet;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

/**
 *
 * @author dedged
 */
public class FramesThreadsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Hello, world!");
        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.gray);

        JPanel bfbg = new JPanel();
        bfbg.setBackground(Color.gray);
        bfbg.setLayout(null);
        bfbg.setVisible(true);

        JPanel boxBlack = new JPanel();
        boxBlack.setSize(50, 50);
        boxBlack.setLayout(null);
        boxBlack.setBackground(Color.black);
        boxBlack.setLocation(127, 0);
        boxBlack.setVisible(true);

        JPanel boxWhite = new JPanel();
        boxWhite.setSize(50, 50);
        boxWhite.setLayout(null);
        boxWhite.setBackground(Color.white);
        boxWhite.setLocation(0, 127);
        boxWhite.setVisible(true);

        frame.add(bfbg);
        bfbg.add(boxBlack);
        bfbg.add(boxWhite);
        //frame.add(boxBlack);
        //frame.add(boxWhite);
        frame.setSize(250, 250);

        frame.setLocation(250, 250);
        frame.repaint();

        try {
            Thread.sleep(1000);//1sec
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        boxWhite.setLocation(200, 127);
        boxBlack.setLocation(127, 200);
        frame.repaint();

        try {
            Thread.sleep(1000);//1sec
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        frame.dispose();
    }

}
