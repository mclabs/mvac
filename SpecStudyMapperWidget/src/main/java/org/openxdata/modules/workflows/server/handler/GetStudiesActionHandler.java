package org.openxdata.modules.workflows.server.handler;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.commons.io.IOUtils;
import org.openxdata.modules.workflows.server.util.PackageScanner;
import org.openxdata.modules.workflows.shared.rpc.GetStudiesAction;
import org.openxdata.modules.workflows.shared.rpc.GetStudiesAction.Result;

public class GetStudiesActionHandler implements
	ActionHandler<GetStudiesAction, GetStudiesAction.Result>
{

    @Override
    public Result execute(GetStudiesAction arg0, ExecutionContext arg1)
	    throws ActionException
    {
	try {
	    File[] listFiles = PackageScanner
		    .listFiles("org.openxdata.modules.workflows.server.resources.studies");

	    ArrayList<String> studies = new ArrayList<String>(listFiles.length);

	    for (File file : listFiles) {
		String studyXml = IOUtils.toString(new FileInputStream(file));
		studies.add(studyXml);
	    }
	    GetStudiesAction.Result result = new GetStudiesAction.Result(
		    studies);
	    
	    return result;
	} catch (Throwable e) {
	    e.printStackTrace();
	    throw new ActionException(e);
	}
    }

    @Override
    public Class<GetStudiesAction> getActionType()
    {
	return GetStudiesAction.class;
    }

    @Override
    public void rollback(GetStudiesAction arg0, Result arg1,
	    ExecutionContext arg2) throws ActionException
    {
    }
    
    public static void main(String[] args) throws ActionException{
	new GetStudiesActionHandler().execute(null, null);
    }

}
