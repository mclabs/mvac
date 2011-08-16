/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.communication.model;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author mike
 */
public class Message {
    Hashtable parameters;
    StringBuffer paramString;
    String serverUrl;

    public Message(String serverUrl) {
        this.serverUrl=serverUrl;
        paramString=new StringBuffer();
        parameters = new Hashtable();
    }
    
    
    
    public void setParam(String name,String value){
        if(!parameters.containsKey(name)){
          parameters.put(name, value);  
        }
        
    }
    
    public String getParamsString(){
        Enumeration keys = parameters.keys();
        
        while (keys.hasMoreElements()) {
            String myKey = (String)keys.nextElement();
            String myValue = (String)parameters.get(myKey);
            paramString.append(myKey+"="+myValue+"&");
            
        }
        
        return paramString.toString();
    }
    
    public String requestString(){
        return serverUrl+"?"+getParamsString();
    }
    
}
