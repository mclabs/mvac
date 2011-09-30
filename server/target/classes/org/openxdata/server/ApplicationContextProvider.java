/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author Ronald.K
 */
public class ApplicationContextProvider implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Context.setContext(applicationContext);
    }
}
