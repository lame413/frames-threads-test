/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames.threads.test;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dedged
 */
public class DrawGraphics implements Runnable {

    private Thread t;
    private short maxFramerate;
    FrameStorage mainFrame;
    short msDelay;
    long cycleStartTime;

    DrawGraphics(FrameStorage providedFrame) {
        maxFramerate = 300;
        mainFrame = providedFrame;
        msDelay = (short) Math.floor(1000 / maxFramerate);
    }

    DrawGraphics(short providedFramerate, FrameStorage providedFrame) {
        maxFramerate = providedFramerate;
        mainFrame = providedFrame;
        msDelay = (short) Math.floor(1000 / maxFramerate);
    }

    
    
    public void run() {
        while (true) {
            cycleStartTime = System.currentTimeMillis();

            mainFrame.redraw();
            
            // fix for laggy drawing
            Toolkit.getDefaultToolkit().sync();

            //check if the thread is lagging behind
            if (System.currentTimeMillis() - cycleStartTime > msDelay) {
                continue;
            }

            try {
                //if not, sleep for (msDelay-[execution time]) miliseconds
                Thread.sleep(msDelay - (System.currentTimeMillis() - cycleStartTime));
            } catch (InterruptedException ex) {
                Logger.getLogger(DrawGraphics.class.getName()).log(Level.SEVERE, null, ex);
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
