/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames.threads.test;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dedged
 */
public class FramesThreadsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         JFrame frame = new JFrame("Hello, world!");
         frame.setSize(250, 300);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel panel1 = new JPanel();
         frame.add(panel1);
         
         panel1.setLayout(null);
         
    }
    
}
