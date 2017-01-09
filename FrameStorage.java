/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames.threads.test;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class initializes and stores the frames.
 *
 * @author lame
 */
public class FrameStorage {

    private int box1PosX;
    private int box1PosY;

    private int box2PosX;
    private int box2PosY;

    private JFrame mainContainer; // the frame
    private JPanel mainPanel;
    private JPanel boxBlack;
    private JPanel boxWhite;
    
    //TODO: comment, split into functions
    FrameStorage() {
        mainContainer = new JFrame("");
        mainContainer.setResizable(false);
        mainContainer.setVisible(true);
        mainContainer.setSize(250, 250);
        mainContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainContainer.setBackground(Color.gray);

        JPanel bfbg = new JPanel();
        bfbg.setBackground(Color.gray);
        bfbg.setLayout(null);
        bfbg.setVisible(true);

        boxBlack = new JPanel();
        boxBlack.setSize(50, 50);
        boxBlack.setLayout(null);
        boxBlack.setBackground(Color.black);
        boxBlack.setLocation(127, 0);
        boxBlack.setVisible(true);

        boxWhite = new JPanel();
        boxWhite.setSize(50, 50);
        boxWhite.setLayout(null);
        boxWhite.setBackground(Color.white);
        boxWhite.setLocation(0, 127);
        boxWhite.setVisible(true);

        mainContainer.add(bfbg);
        bfbg.add(boxBlack);
        bfbg.add(boxWhite);
    }
    
    FrameStorage moveBox1(int _x, int _y){
        box1PosX = _x;
        box1PosY = _y;
        boxBlack.setLocation(box1PosX, box1PosY);
        
        return this;
    }
    
    FrameStorage moveBox2(int _x, int _y){
        box2PosX = _x;
        box2PosY = _y;
        boxWhite.setLocation(box2PosX, box2PosY);
        System.out.println("Box 2:" + box2PosX + ", " + box2PosY+"\n");
        return this;
    }
    
    FrameStorage redraw(){
        boxWhite.repaint();
        boxBlack.repaint();
        return this;
    }
    
    FrameStorage closeFrame(){
        mainContainer.dispose();
        return this;
    }
    
}
