package org.openxdata.modules.workflows.server.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.JDOMException;
import org.openxdata.modules.workflows.model.shared.ODecomposition;
import org.openxdata.modules.workflows.model.shared.OParameter;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.model.shared.OTask;
import org.yawlfoundation.yawl.elements.YAWLServiceGateway;
import org.yawlfoundation.yawl.elements.YAWLServiceReference;
import org.yawlfoundation.yawl.elements.YDecomposition;
import org.yawlfoundation.yawl.elements.YSpecification;
import org.yawlfoundation.yawl.elements.YTask;
import org.yawlfoundation.yawl.elements.data.YParameter;
import org.yawlfoundation.yawl.engine.YSpecificationID;
import org.yawlfoundation.yawl.exceptions.YSchemaBuildingException;
import org.yawlfoundation.yawl.exceptions.YSyntaxException;
import org.yawlfoundation.yawl.unmarshal.YMarshal;

public class SpecificationMapperUtil {

        public static OSpecification mapToSimpleOXDModel(String ySpecification)
                throws YSyntaxException, YSchemaBuildingException, JDOMException,
                IOException {

                List<YSpecification> specifications = YMarshal.unmarshalSpecifications(ySpecification);
                return (mapToSimpleOXDModel(specifications.get(0)));

        }

        public static OSpecification mapToSimpleOXDModel(
                YSpecification ySpecification) {
                Set<YDecomposition> yDecompositions = ySpecification.getDecompositions();
                Set<YDecomposition> oxdDecomps = extractDecompostionsWithOXDService(yDecompositions);

                List<YTask> netTasks = ySpecification.getRootNet().getNetTasks();
                List<YTask> oxdTasks = extractTasksWIthOxdService(netTasks);

                OSpecification oSpecification = buildOxdSpec(oxdTasks, oxdDecomps);
                YSpecificationID specID = ySpecification.getSpecificationID();
                oSpecification.setName(specID.getSpecName());
                oSpecification.setVersion(specID.getVersion().toString());
                return oSpecification;
        }

        private static List<YTask> extractTasksWIthOxdService(List<YTask> netTasks) {

                List<YTask> tasksWithOxdService = new ArrayList<YTask>();

                for (YTask yTask : netTasks) {
                        YDecomposition yDecomposition = yTask.getDecompositionPrototype();

                        if (yDecomposition instanceof YAWLServiceGateway) {
                                YAWLServiceGateway gateway = (YAWLServiceGateway) yDecomposition;

                                YAWLServiceReference yawlService = gateway.getYawlService();
                                if (yawlService != null && yawlService.getURI().endsWith("wf")) {
                                        tasksWithOxdService.add(yTask);
                                }
                        }

                }
                return tasksWithOxdService;
        }

        private static Set<YDecomposition> extractDecompostionsWithOXDService(
                Set<YDecomposition> decompositions) {
                Set<YDecomposition> decomps = new HashSet<YDecomposition>();

                for (YDecomposition yDecomposition : decompositions) {

                        if (yDecomposition instanceof YAWLServiceGateway) {

                                YAWLServiceGateway gateway = (YAWLServiceGateway) yDecomposition;
                                YAWLServiceReference yawlService = gateway.getYawlService();
                                if (yawlService != null && yawlService.getURI().endsWith("wf")) {
                                        decomps.add(yDecomposition);
                                }
                        }

                }
                return decomps;
        }

        private static OSpecification buildOxdSpec(List<YTask> netTasks,
                Set<YDecomposition> decompositions) {

                ArrayList<ODecomposition> oDecompositions = new ArrayList<ODecomposition>();

                for (YDecomposition yDecomposition : decompositions) {
                        ODecomposition od = convetToOXDDecomposition(yDecomposition);
                        oDecompositions.add(od);
                }

                ArrayList<OTask> oTasks = new ArrayList<OTask>();

                for (YTask yTask : netTasks) {
                        OTask ot = new OTask();

                        ot.setId(yTask.getID());
                        ot.setName(yTask.getName());

                        for (ODecomposition oDecomposition : oDecompositions) {
                                if (oDecomposition.getId().equals(
                                        yTask.getDecompositionPrototype().getID())) {
                                        ot.setDecomposition(oDecomposition);
                                        oTasks.add(ot);
                                        break;
                                }
                        }
                }

                OSpecification oSpecification = new OSpecification(null, oTasks,
                        oDecompositions);

                return oSpecification;
        }

        private static ODecomposition convetToOXDDecomposition(
                YDecomposition yDecomposition) {

                ArrayList<OParameter> lstInParams = new ArrayList<OParameter>();
                ArrayList<OParameter> lstOutParams = new ArrayList<OParameter>();

                Map<String, YParameter> yInputParameters = yDecomposition.getInputParameters();
                Map<String, YParameter> yOutputParameters = yDecomposition.getOutputParameters();

                for (YParameter yParameter : yInputParameters.values()) {
                        OParameter op = fromYParametertoOParameter(yParameter);
                        lstInParams.add(op);
                }



                for (YParameter yParameter : yOutputParameters.values()) {
                        OParameter op = fromYParametertoOParameter(yParameter);
                        lstOutParams.add(op);
                }


                for (OParameter outParam : lstOutParams) {
                        for (OParameter inParam : lstInParams) {
                                if (outParam.getName().equals(inParam.getName())) {
                                        outParam.setFlow(OParameter.Flow.INPUTOUTPUT);
                                        lstInParams.remove(inParam);
                                        break;
                                }
                        }
                }

                ODecomposition oDecomposition = new ODecomposition();
                oDecomposition.setId(yDecomposition.getID());
                oDecomposition.addParameters(lstInParams);
                oDecomposition.addParameters(lstOutParams);

                return oDecomposition;
        }

        private static OParameter fromYParametertoOParameter(YParameter yParameter) {
                OParameter op = new OParameter();
                op.setName(yParameter.getName());
                op.setType(yParameter.getDataTypeName());
                op.setInitialValue(yParameter.getInitialValue());
                op.setNameSpace(yParameter.getDataTypeNameSpace());
                if (yParameter.isInput()) {
                        op.setFlow(OParameter.Flow.INPUT);
                } else {
                        op.setFlow(OParameter.Flow.OUPUT);
                }

                return op;
        }
}
