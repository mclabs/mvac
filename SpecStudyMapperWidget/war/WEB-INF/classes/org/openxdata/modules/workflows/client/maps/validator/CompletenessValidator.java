/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.maps.validator;

import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.TaskFormVersionMap;

/**
 *
 * @author kay
 */
public interface CompletenessValidator
{

        public static class Response
        {

                public static Response OK = new Response();
                private boolean complete = false;
                private String message;

                public Response()
                {
                        complete = true;
                        message = null;
                }

                public Response(boolean complete, String message)
                {
                        this.complete = complete;
                        this.message = message;
                }

                public boolean isComplete()
                {
                        return complete;
                }

                public String message()
                {
                        return message;
                }
        }

        public Response isComplete(SpecStudyMap map);

        public Response isComplete(TaskFormVersionMap map);

        public String getErrors();

        public boolean hasErrors();

        public void reset();
}
