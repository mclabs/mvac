package org.celllife.emit.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.celllife.emit.client.controllers.DataCaptureController;
import org.celllife.emit.client.controllers.FormListController;
import org.celllife.emit.client.controllers.FormPrintController;
import org.celllife.emit.client.controllers.FormResponsesController;
import org.celllife.emit.client.controllers.LoginController;
import org.celllife.emit.client.controllers.UserProfileController;
import org.celllife.emit.client.service.FormService;
import org.celllife.emit.client.service.FormServiceAsync;
import org.celllife.emit.client.service.UserService;
import org.celllife.emit.client.service.UserServiceAsync;
import org.celllife.emit.client.util.ProgressIndicator;
import org.openxdata.server.admin.model.User;
import org.purc.purcforms.client.util.FormUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboValue;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Emit implements EntryPoint, Refreshable {
	
    final AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class);	
    public static final String VIEWPORT = "viewport";
    public static final String PORTAL = "portal";
    
    FormServiceAsync formService;
    UserServiceAsync userService;
    
    private Viewport viewport;
    private Portal portal;
    
    private Text userBanner;
    
    /**
     * This is the entry point method.
     */
    @Override
	public void onModuleLoad() {
        /* Install an UncaughtExceptionHandler which will
         * produce <code>FATAL</code> log messages
         */
    	GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
			public void onUncaughtException(final Throwable tracepoint) {
            	Log.fatal("Uncaught Exception", tracepoint);
            	Window.alert(appMessages.pleaseTryAgainLater(tracepoint.getMessage()));
            	ProgressIndicator.hideProgressBar();
            }
        });
        
        formService = (FormServiceAsync) GWT.create(FormService.class);
        userService = (UserServiceAsync) GWT.create(UserService.class);
        
        initUI();
        
        RootPanel.get().setStylePrimaryName("body");
        
        Dispatcher dispatcher = Dispatcher.get();
        dispatcher.addController(new LoginController(userService));
        dispatcher.addController(new FormListController(formService));
        dispatcher.addController(new DataCaptureController(userService, formService));
        dispatcher.addController(new UserProfileController(userService));
        dispatcher.addController(new FormPrintController());
        dispatcher.addController(new FormResponsesController(formService, userService));
        //dispatcher.addController(new StatsController(formService));

        dispatcher.dispatch(FormListController.FORMLIST);
        //dispatcher.dispatch(StatsController.STATS);
        
        RefreshablePublisher publisher = RefreshablePublisher.get();
        publisher.subscribe(RefreshableEvent.Type.NAME_CHANGE, this);
        
        FormUtil.dlg.hide();
    }
    
    private void initUI() {
        viewport = new Viewport();
        viewport.setLayout(new BorderLayout());
        viewport.addStyleName("emit-viewport");

        createNorth();
        createPortal();
        createDisclaimer();

        // registry serves as a global context
        Registry.register(VIEWPORT, viewport);
        Registry.register(PORTAL, portal);

        RootPanel.get().add(viewport);
    }

    private void createNorth() {
        HorizontalPanel northPanel = new HorizontalPanel();
        northPanel.setTableWidth("100%");
        northPanel.setBorders(false);

        TableData logoTableData = new TableData();
        logoTableData.setHorizontalAlign(HorizontalAlignment.LEFT);
        logoTableData.setVerticalAlign(VerticalAlignment.TOP);
        logoTableData.setWidth("200");
        logoTableData.setHeight("40");
        Image logo = new Image("images/emit/EMIT_logo_small_TRANS.png");
        logo.setHeight("40");
        logo.setWidth("79");
        logo.setTitle("Emit");
        northPanel.add(logo, logoTableData); 

        TableData userBannerTableData = new TableData();
        userBannerTableData.setHorizontalAlign(HorizontalAlignment.CENTER);
        userBannerTableData.setVerticalAlign(VerticalAlignment.MIDDLE);
        userBanner = new Text("");
        userBanner.setStyleName("userBanner");
        northPanel.add(userBanner, userBannerTableData);
        
        DeferredCommand.addCommand(new Command() {
            @Override
			public void execute() {
            	userService.getLoggedInUser(new EmitAsyncCallback<User>() {
                    @Override
					public void onSuccess(User usr) {
                    	String userName = appMessages.user() + " : " + usr.getFullName(); 
                    	userBanner.setText(userName);
                    }
                });
            }
        });    	

        Button myDetails = new Button(appMessages.myDetails());
        myDetails.addListener(Events.Select, new Listener<ButtonEvent>() {
            @Override
			public void handleEvent(ButtonEvent be) {
                forwardToUserProfile();
            }
        }); 
        
        Button logout = new Button(appMessages.logout());
        logout.addListener(Events.Select, new Listener<ButtonEvent>() {
            @Override
			public void handleEvent(ButtonEvent be) {
                Window.Location.replace(GWT.getModuleBaseURL()+"j_spring_security_logout"); 
            }
        });
        FlexTable ft = new FlexTable();
        ft.setBorderWidth(0);
        ft.setWidget(0, 0, myDetails);
        ft.setWidget(0, 1, logout);
        TableData buttonsTableData = new TableData();
        buttonsTableData.setHorizontalAlign(HorizontalAlignment.RIGHT);
        buttonsTableData.setVerticalAlign(VerticalAlignment.MIDDLE);
        buttonsTableData.setWidth("200");
        buttonsTableData.setHeight("40");
        northPanel.add(ft, buttonsTableData);
        
        BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH, 50);
        data.setMargins(new Margins(10,40,10,14));
        viewport.add(northPanel, data);
    }

    private void createPortal() {
        LayoutContainer center = new LayoutContainer();
        center.setLayout(new FitLayout());
        
        portal = new Portal(1);
        portal.setSpacing(10);
        portal.setColumnWidth(0, .99);
        center.add(portal);

        BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
        data.setMargins(new Margins(5, 5, 5, 5));

        viewport.add(center, data);
    }

	private void createDisclaimer() {        
        final LayoutContainer lc = new LayoutContainer();
        lc.setBorders(false);
        lc.setBounds(1, 1, 1, 1);
        
        VBoxLayout layout = new VBoxLayout();
        layout.setPadding(new Padding(0));  
        layout.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);  
        lc.setLayout(layout);

        final SimpleComboBox<String> languageSelector = new SimpleComboBox<String>();
        languageSelector.setEmptyText(appMessages.language());
        languageSelector.add("English");
        languageSelector.setData("English", "en");
        languageSelector.add("Portugu\u00EAs");
        languageSelector.setData("Portugu\u00EAs", "pt");
        languageSelector.add("Sesotho");
        languageSelector.setData("Sesotho", "st");
        languageSelector.add("Chichewa");
        languageSelector.setData("Chichewa", "ny");
        languageSelector.addSelectionChangedListener(new SelectionChangedListener<SimpleComboValue<String>>() {
        	@Override
        	public void selectionChanged(SelectionChangedEvent<SimpleComboValue<String>> se) {
        		// Note: hacking GWT 2.0 UrlBuilder functionality (copied code must be removed when we upgrade)
        		String selectedValue = se.getSelectedItem().getValue();
        		String locale = languageSelector.getData(selectedValue);
        		if (locale != null && !locale.trim().equals("")) {
        			UrlBuilder urlBuilder = createUrlBuilder();
            		urlBuilder.setParameter("locale", locale);
        			Window.Location.replace(urlBuilder.buildString());
        		}
        	}
        });
        lc.add(languageSelector);
        
        lc.add(new Text(""));

        Text disclaimerTxt = new Text(appMessages.disclaimer());
        disclaimerTxt.setStyleName("disclaimer");
        lc.add(disclaimerTxt);
        
        BorderLayoutData data = new BorderLayoutData(LayoutRegion.SOUTH, 100);
        data.setMargins(new Margins(10,40,10,14));
        viewport.add(lc, data);
    }
	
	// copied from GWT 2.0 Window.Location
    private static UrlBuilder createUrlBuilder() {
        UrlBuilder builder = new UrlBuilder();
        builder.setProtocol(Window.Location.getProtocol());
        builder.setHost(Window.Location.getHost());
        String path = Window.Location.getPath();
        if (path != null && path.length() > 0) {
          builder.setPath(path);
        }
        String hash = Window.Location.getHash();
        if (hash != null && hash.length() > 0) {
          builder.setHash(hash);
        }
        String port = Window.Location.getPort();
        if (port != null && port.length() > 0) {
          builder.setPort(Integer.parseInt(port));
        }

        // Add query parameters.
        Map<String, List<String>> params = Window.Location.getParameterMap();
        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
          List<String> values = new ArrayList<String>(entry.getValue());
          builder.setParameter(entry.getKey(),
              values.toArray(new String[values.size()]));
        }

        return builder;
    }
    
    public void forwardToUserProfile(){
    	Dispatcher dispatcher = Dispatcher.get();
    	dispatcher.dispatch(UserProfileController.USERPROFILE);
    }

	@Override
	public void refresh(RefreshableEvent event) {
		User user = event.getData();
		Log.debug("Name change event for "+user.getFullName());
		String userName = appMessages.user() + " : " + user.getFullName();
		userBanner.setText(userName);
	}
}