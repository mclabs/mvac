/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.maps.validator;

import java.util.List;
import org.openxdata.modules.workflows.model.shared.OParameter;
import org.openxdata.modules.workflows.model.shared.OTask;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.TaskFormVersionMap;

/**
 *
 * @author kay
 */
public class DefaultCompletenessValidator implements CompletenessValidator
{

        private StringBuilder builder = new StringBuilder();

        public Response isComplete(SpecStudyMap map)
        {
                List<OTask> allUnMatchedTasks = map.getAllUnMatchedTasks();
                if (allUnMatchedTasks.isEmpty()) {
                        return Response.OK;
                }
                String message = new StringBuilder("You have ").append(allUnMatchedTasks.size()).
                        append(" unmatched tasks in the &lt ").
                        append(map.getUniqueName()).
                        append("&gt map<br/>").toString();
                builder.append(message);
                return new Response(false, message);
        }

        public Response isComplete(TaskFormVersionMap map)
        {
                List<OParameter> unMatchedParams = map.getUnMatchedParams();
                if (unMatchedParams.isEmpty()) {
                        return Response.OK;
                }
                String message = new StringBuilder("You have ").append(unMatchedParams.size()).
                        append(" unmatched parameters in the &lt ").
                        append(map.getUniqueName()).
                        append("&gt map<br/>").toString();
                builder.append(message);
                return new Response(false, message);
        }

        public String getErrors()
        {
                return builder.toString();
        }

        public void reset()
        {
                builder = new StringBuilder();
        }

        public boolean hasErrors()
        {
                return builder.length() != 0;
        }
}
