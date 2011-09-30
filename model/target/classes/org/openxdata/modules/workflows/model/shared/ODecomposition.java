package org.openxdata.modules.workflows.model.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ODecomposition implements Serializable {

        private static final long serialVersionUID = 1L;
        private String id;
        private HashMap<String, OParameter> mParams;
        private String urlService;

        public ODecomposition() {
                mParams = new HashMap<String, OParameter>();

        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public void addParameter(OParameter param) {
                if (param != null) {
                        mParams.put(param.getName(), param);
                }
        }

        public void addParameters(List<OParameter> params){
                for (OParameter oParameter : params) {
                     addParameter(oParameter);
                }
        }

        public ArrayList<OParameter> getInputParams() {

                ArrayList<OParameter> params = new ArrayList<OParameter>();
                for (OParameter oParameter : mParams.values()) {
                        if (oParameter.isInput()) {
                                params.add(oParameter);
                        }
                }
                return params;
        }

        public ArrayList<OParameter> getOutputParams() {
                ArrayList<OParameter> params = new ArrayList<OParameter>();
                for (OParameter oParameter : mParams.values()) {
                        if (oParameter.isOutput()) {
                                params.add(oParameter);
                        }
                }
                return params;
        }

        public String getUrlService() {
                return urlService;
        }

        public void setUrlService(String urlService) {
                this.urlService = urlService;
        }

        public ArrayList<OParameter> getAllParams() {
                return new ArrayList<OParameter>(mParams.values());
        }
}
