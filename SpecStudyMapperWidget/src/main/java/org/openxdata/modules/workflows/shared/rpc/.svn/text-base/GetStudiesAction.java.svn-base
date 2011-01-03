package org.openxdata.modules.workflows.shared.rpc;

import java.util.ArrayList;

import net.customware.gwt.dispatch.shared.Action;

public class GetStudiesAction implements Action<GetStudiesAction.Result>
{

    private static final long serialVersionUID = 1L;

    public GetStudiesAction()
    {
    }

    public static class Result implements
	    net.customware.gwt.dispatch.shared.Result
    {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> studies;

	Result()
	{
	}

	public Result(ArrayList<String> studies)
	{
	    this.studies = studies;
	}

	public ArrayList<String> getStudies()
	{
	    return studies;
	}
    }

}
