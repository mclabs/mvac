package org.openxdata.modules.workflows.server.guice;

import org.yawlfoundation.yawl.engine.interfce.interfaceB.InterfaceB_EnvironmentBasedServer;

import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;

public class YawlServletModule extends ServletModule {

    @Override
    public void configureServlets() {
        configureInterfaceB();
    }

    private void configureInterfaceB() {
        bind(InterfaceB_EnvironmentBasedServer.class).in(Scopes.SINGLETON);
        serve("/wf").with(InterfaceB_EnvironmentBasedServer.class);
        System.out.println("Serving Inteface b");
    }
}
