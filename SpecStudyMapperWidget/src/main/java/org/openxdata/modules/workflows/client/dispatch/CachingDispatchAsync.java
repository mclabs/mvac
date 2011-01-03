package org.openxdata.modules.workflows.client.dispatch;

import java.util.HashMap;
import java.util.Map;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class CachingDispatchAsync implements DispatchAsync {

	private DispatchAsync mDispatcher;
	private Map<Action<Result>, Result> mCache = new HashMap<Action<Result>, Result>();

	@Inject
	public CachingDispatchAsync(final DispatchAsync dispatcher) {
		this.mDispatcher = dispatcher;
	}

	public <A extends Action<R>, R extends Result> void execute(final A action,
			final AsyncCallback<R> callback) {
		mDispatcher.execute(action, callback);
	}

	@SuppressWarnings("unchecked")
	public <A extends Action<R>, R extends Result> void executeWithCache(
			final A action, final AsyncCallback<R> callback) {
		final Result r = mCache.get(action);

		if (r != null) {
			callback.onSuccess((R) r);
		} else {
			execute(action, new AsyncCallback<R>() {

				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}

				public void onSuccess(R result) {
					mCache.put((Action) action, (Result) result);
					callback.onSuccess(result);
				}

			});
		}
	}

	public void clear() {
		mCache.clear();
	}
}