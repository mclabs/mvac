package org.openxdata.modules.workflows.model.shared;

import java.io.Serializable;

public class OParameter implements Serializable {

        public static enum Flow {

                INPUT("I"),
                OUPUT("O"),
                INPUTOUTPUT("I/O");
                private final String name;

                private Flow(String name) {
                        this.name = name;
                }

                @Override
                public String toString() {
                        return name;
                }
        }
        private static final long serialVersionUID = 1L;
        public static final String TYPE_STRING = "string";
        public static final String TYPE_INTEGER = "integer";
        public static final String TYPE_INT = "int";
        public static final String TYPE_DATE = "date";
        public static final String TYPE_DATE_TIME = "dateTime";
        public static final String TYPE_DOUBLE = "double";
        public static final String TYPE_DECIMAL = "decimal";
        public static final String TYPE_TIME = "time";
        public static final String TYPE_BOOLEAN = "boolean";
        private String name;
        private String type;// This should probably be an object
        private String nameSpace;
        private String initialValue;
        private Flow flow;

        public boolean isInput() {
                return flow == Flow.INPUT;
        }

        public boolean isInputOutput() {
                return flow == Flow.INPUTOUTPUT;
        }

        public boolean isOutput() {
                return flow == Flow.OUPUT;
        }

        public OParameter() {
        }

        public String getInitialValue() {
                return initialValue;
        }

        public void setInitialValue(String initialValue) {
                this.initialValue = initialValue;
        }

        public String getName() {
                return name;
        }

        public String getDisplayName() {
                // return getName() + " [" + flow + "," + type + "]";
                return getName() + " #" + type;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getNameSpace() {
                return nameSpace;
        }

        public void setNameSpace(String nameSpace) {
                this.nameSpace = nameSpace;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public void setFlow(Flow flow) {
                this.flow = flow;
        }

        public Flow getFlow() {
                return flow;
        }
}
