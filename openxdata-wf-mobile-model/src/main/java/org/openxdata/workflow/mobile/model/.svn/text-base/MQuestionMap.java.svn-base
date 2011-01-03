
package org.openxdata.workflow.mobile.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.PersistentHelper;

/**
 *
 * @author kay
 */
public class MQuestionMap implements Persistent {

        private String parameter;
        private String question;
        private String value;
        private Boolean output;
        private String type;

        public MQuestionMap() {
        }

        public MQuestionMap(String parameter, String question, String value) {
                this.parameter = parameter;
                this.question = question;
                this.value = value;
        }

        public void write(DataOutputStream dos) throws IOException {
                PersistentHelper.writeUTF(dos, parameter);
                PersistentHelper.writeUTF(dos, question);
                PersistentHelper.writeUTF(dos, value);
                PersistentHelper.writeBoolean(dos, output);
        }

        public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException {
                parameter = PersistentHelper.readUTF(dis);
                question = PersistentHelper.readUTF(dis);
                value = PersistentHelper.readUTF(dis);
                output = PersistentHelper.readBoolean(dis);
        }

        public String getParameter() {
                return parameter;
        }

        public void setParameter(String parameter) {
                this.parameter = parameter;
        }

        public String getQuestion() {
                return question;
        }

        public void setQuestion(String question) {
                this.question = question;
        }

        public String getValue() {
                return value;
        }

        public void setValue(String value) {
                this.value = value;
        }

        public boolean isForTitle() {
                return parameter.endsWith("_");
        }

        public boolean isOutput() {
                if (output == null) {
                        return false;
                }
                return output.booleanValue();
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getType() {
                return type;
        }

        public void setOutput(boolean b) {
                output = new Boolean(b);
        }
}
