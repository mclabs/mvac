package org.openxdata.modules.workflows.shared.rpc;

import java.util.ArrayList;

import net.customware.gwt.dispatch.shared.Action;
import org.openxdata.modules.workflows.model.shared.OSpecification;


public class GetSpecsAction implements Action<GetSpecsAction.Result>
{
    private static final long serialVersionUID = 1L;

    public GetSpecsAction()
    {
    }

    public static class Result implements
	    net.customware.gwt.dispatch.shared.Result
    {

	private static final long serialVersionUID = -5084873941787405454L;
	private ArrayList<OSpecification> ospecifications;

	Result()
	{
	}

	public Result(ArrayList<OSpecification> oSpecifications)
	{
	    this.ospecifications = oSpecifications;
	}

	public ArrayList<OSpecification> getOspecification()
	{
	    return ospecifications;
	}
    }
}
