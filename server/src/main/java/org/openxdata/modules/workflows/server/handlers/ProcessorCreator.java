/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.handlers;

import org.springframework.stereotype.Component;

/**
 *
 * @author kay
 */
@Component("processorCreator")
public class ProcessorCreator
{

        public RequestHandler buildRequestHandler(String type)
        {
                RequestHandler rh = null;
                try {
                        rh = loadClassForQuery(type).newInstance();
                } catch (ClassNotFoundException ex) {
                        rh = new NotSupportedHandler(type);
                } catch (Exception ex) {
                        rh = new ErrorWhileProcessHandler(ex);
                }
                return rh;
        }

        private Class<RequestHandler> loadClassForQuery(String handlerClassName) throws ClassNotFoundException
        {
                try {
                        return (Class<RequestHandler>) Class.forName(handlerClassName);
                } catch (ClassNotFoundException classNotFoundException) {
                }
                try {
                        return (Class<RequestHandler>) Class.forName("org.openxdata.modules.workflows.server.handlers." + handlerClassName);
                } catch (ClassNotFoundException classNotFoundException) {
                }
                return (Class<RequestHandler>) Class.forName("org.openxdata.modules.workflows.server.handlers." + handlerClassName + "Handler");
        }
}
