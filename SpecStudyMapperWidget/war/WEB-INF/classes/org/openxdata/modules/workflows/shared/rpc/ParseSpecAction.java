package org.openxdata.modules.workflows.shared.rpc;


import net.customware.gwt.dispatch.shared.Action;
import org.openxdata.modules.workflows.model.shared.OSpecification;

public class ParseSpecAction implements Action<ParseSpecAction.Result> {

	private static final long serialVersionUID = 311826454990112004L;

	private String xml;

	ParseSpecAction() {
	}

	public ParseSpecAction(String xml) {
		this.xml = xml;
	}

	public String getXml() {
		return xml;
	}

	public static class Result implements
			net.customware.gwt.dispatch.shared.Result {

		private static final long serialVersionUID = -5084873941787405454L;
		private OSpecification ospecification;

		Result() {
		}

		public Result(OSpecification oSpecification) {
			this.ospecification = oSpecification;
		}

		public OSpecification getOspecification() {
			return ospecification;
		}
	}

}
