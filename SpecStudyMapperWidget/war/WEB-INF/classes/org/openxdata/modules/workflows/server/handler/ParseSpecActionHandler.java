package org.openxdata.modules.workflows.server.handler;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.openxdata.modules.workflows.model.shared.OSpecification;

import org.openxdata.modules.workflows.server.util.SpecificationMapperUtil;
import org.openxdata.modules.workflows.shared.rpc.ParseSpecAction;
import org.openxdata.modules.workflows.shared.rpc.ParseSpecAction.Result;

public class ParseSpecActionHandler implements
        ActionHandler<ParseSpecAction, ParseSpecAction.Result>
{

    @Override
    public ParseSpecAction.Result execute(ParseSpecAction arg0,
                                          ExecutionContext arg1)
            throws ActionException
    {

        try {
            OSpecification mapToSimpleOXDModel = SpecificationMapperUtil.mapToSimpleOXDModel(arg0.getXml());
            return new Result(mapToSimpleOXDModel);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ActionException(e);
        }
    }

    @Override
    public Class<ParseSpecAction> getActionType()
    {
        return ParseSpecAction.class;
    }

    @Override
    public void rollback(ParseSpecAction arg0, Result arg1,
                         ExecutionContext arg2) throws ActionException
    {
    }
}
