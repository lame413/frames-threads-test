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
        
        FrameStorage gameFrame = new FrameStorage();
        PositionCalculation tPos = new PositionCalculation((short)64, gameFrame);
        DrawGraphics tGraphics = new DrawGraphics(gameFrame);
        
        tPos.start();
        tGraphics.start();
        
        //frame.dispose();
        
    }

}
