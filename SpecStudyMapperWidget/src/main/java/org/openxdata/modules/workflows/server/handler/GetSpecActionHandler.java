package org.openxdata.modules.workflows.server.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;


import org.apache.commons.io.IOUtils;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.server.util.PackageScanner;
import org.openxdata.modules.workflows.server.util.SpecificationMapperUtil;
import org.openxdata.modules.workflows.shared.rpc.GetSpecsAction;
import org.openxdata.modules.workflows.shared.rpc.GetSpecsAction.Result;

public class GetSpecActionHandler implements
        ActionHandler<GetSpecsAction, GetSpecsAction.Result>
{

    @Override
    public Result execute(GetSpecsAction action, ExecutionContext ctx)
            throws ActionException
    {
        try {
            File[] listFiles = loadSpecFiles();

            ArrayList<OSpecification> oSpecs = new ArrayList<OSpecification>(
                    listFiles.length);

            for (File file : listFiles) {
                String specXml = IOUtils.toString(new FileInputStream(file));

                OSpecification oSpec = SpecificationMapperUtil.mapToSimpleOXDModel(specXml);
                oSpecs.add(oSpec);
            }

            GetSpecsAction.Result result = new GetSpecsAction.Result(oSpecs);

            return result;

        } catch (Throwable e) {
            e.printStackTrace();
            throw new ActionException(e);
        }
    }

    private File[] loadSpecFiles()
    {
        FilenameFilter filter = new FilenameFilter()
        {

            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".yawl");
            }
        };

        File[] listFiles = PackageScanner.listFiles(
                "org.openxdata.modules.workflows.server.resources.specs",
                filter);
        return listFiles;
    }

    @Override
    public Class<GetSpecsAction> getActionType()
    {
        return GetSpecsAction.class;
    }

    @Override
    public void rollback(GetSpecsAction arg0, Result arg1, ExecutionContext arg2)
            throws ActionException
    {
    }

    public static void main(String[] args) throws ActionException
    {
        new GetSpecActionHandler().execute(null, null);
    }
}
