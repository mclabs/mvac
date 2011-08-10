/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.communication;

import mike.messaging.communication.worker.IWorker;
import org.openxdata.mvac.communication.model.Message;
import org.openxdata.mvac.communication.worker.HttpWorker;



/**
 *
 * @author openmrs
 */
public class TransportManager{
    IWorker primaryWorker;
    ITransportListener listener;
    Thread workerThread;
    String requestType;

    public TransportManager(String requestType,ITransportListener listener) {
        this.listener=listener;
        this.requestType=requestType;
    }
    
    
    
    
    
    public void finishedSend(Object args){
        listener.messageSent(args);
        
    }
    
    public void sendMessage(Message msg){
        primaryWorker = new HttpWorker(this, msg, requestType);
       workerThread = new Thread(primaryWorker);
       workerThread.start();
        
    }

    
    
}
