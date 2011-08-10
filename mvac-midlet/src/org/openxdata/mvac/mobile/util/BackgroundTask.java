/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.util;

import com.sun.lwuit.Display;

/**
 *
 * @author openmrs
 */
public abstract class BackgroundTask {

    /**
     * Start this task
     */
    public final void start() {
        if (Display.getInstance().isEdt()) {
            taskStarted();
        } else {
            Display.getInstance().callSeriallyAndWait(new Runnable() {

                public void run() {
                    taskStarted();
                }
            });
        }
        new Thread(new Runnable() {

            public void run() {
                if (Display.getInstance().isEdt()) {
                    taskFinished();
                } else {
                    performTask();
                    Display.getInstance().callSerially(this);
                }
            }
        }).start();
    }

    /**
     * Invoked on the LWUIT EDT before spawning the background thread, this allows
     * the developer to perform initialization easily.
     */
    public void taskStarted() {
    }

    /**
     * Invoked on a separate thread in the background, this task should not alter
     * UI except to indicate progress.
     */
    public abstract void performTask();

    /**
     * Invoked on the LWUIT EDT after the background thread completed its
     * execution.
     */
    public void taskFinished() {
    }
}
