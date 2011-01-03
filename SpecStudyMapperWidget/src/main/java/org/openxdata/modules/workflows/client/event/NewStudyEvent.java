package org.openxdata.modules.workflows.client.event;

import org.openxdata.server.admin.model.StudyDef;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class NewStudyEvent extends GwtEvent<NewStudyEvent.Handler>
{
    public interface Handler extends EventHandler
    {
	public void onStudyLoaded(StudyDef studyDef);
    }

    public static Type<Handler> TYPE = new Type<Handler>();
    private StudyDef studyDef;

    public NewStudyEvent(StudyDef studyDef)
    {
	this.studyDef = studyDef;
    }

    @Override
    protected void dispatch(NewStudyEvent.Handler handler)
    {
	handler.onStudyLoaded(studyDef);
    }

    @Override
    public Type<NewStudyEvent.Handler> getAssociatedType()
    {
	return TYPE;
    }
}
