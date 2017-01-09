/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames.threads.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author dedged
 */
public class PositionCalculation implements Runnable {

    private Thread t;
    /**
     * Calculations for the position will be done every 1000/tickrate
     * milliseconds (rounded down).
     *
     * msDelay is just pre-calculated 1000/tickrate.
     *
     */
    private long initTime;
    private long curTime;
    private long cycleStartTime;
    private final short tickrate;
    private final short msDelay;
    private final short cycleTime = 4000;

    FrameStorage mainFrame;

    PositionCalculation(FrameStorage providedFrame) {
        tickrate = 128;
        msDelay = 7;
        mainFrame = providedFrame;
    }

    PositionCalculation(short providedTickrate, FrameStorage providedFrame) {
        tickrate = providedTickrate;
        msDelay = (short) Math.floor(1000 / tickrate);
        mainFrame = providedFrame;
    }

    public void run() {
        initTime = System.currentTimeMillis();
        while (true) {

            cycleStartTime = System.currentTimeMillis();
            curTime = System.currentTimeMillis() - initTime;
            // check if a full cycle passed, if so, update initTime    
            if (curTime >= cycleTime) {
                initTime = System.currentTimeMillis();
                curTime = 0;
            }
            
            //update position for box 1:
            mainFrame.moveBox1(
                    (int) ((Math.sin(Math.toRadians(((double)curTime / (cycleTime/4))*90)))*102)+127,
                    102);
            //System.out.println("toRadinas: "+ Math.toRadians();
            //System.out.println("pos1x = " + (int)(Math.sin(Math.toRadians((((double)curTime / 2000))*90))*250) + ", pos1y = 50\n");

            //update position for box2
            mainFrame.moveBox2(
                    102,
                    (int) ((Math.cos(Math.toRadians(((double)curTime / (cycleTime/4))*90)))*102)+127);
            //System.out.println("pos2 = 50, pos2y = " + (int)(Math.cos(Math.toRadians((((double)curTime / 2000))*90))*250) + "\n curTime = " + curTime);

            //check if the thread is lagging behind
            if (System.currentTimeMillis() - cycleStartTime >= msDelay) {
                continue;
            }

            try {
                //if not, sleep for (msDelay-[execution time]) miliseconds
                Thread.sleep(msDelay - (System.currentTimeMillis() - cycleStartTime));
            } catch (InterruptedException ex) {
                Logger.getLogger(PositionCalculation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

}
