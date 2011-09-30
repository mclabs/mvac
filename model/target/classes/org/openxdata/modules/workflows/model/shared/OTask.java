package org.openxdata.modules.workflows.model.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class OTask implements Serializable {

        private static final long serialVersionUID = 1L;
        private String name;
        private String id;
        private ODecomposition decomposition;

        public OTask() {
        }

        public ODecomposition getDecomposition() {
                return decomposition;
        }

        public void setDecomposition(ODecomposition decomposition) {
                this.decomposition = decomposition;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public ArrayList<OParameter> getOutPutParams() {
                return decomposition.getOutputParams();
        }

        public ArrayList<OParameter> getInputParams() {
                return decomposition.getInputParams();
        }

        public ArrayList<OParameter> getAllParams() {
                return decomposition.getAllParams();
        }
}
