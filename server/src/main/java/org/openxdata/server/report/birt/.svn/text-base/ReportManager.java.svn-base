/*
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.report.birt;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EXCELRenderOption;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.HTMLRenderContext;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IPDFRenderOption;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.model.api.DesignConfig;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.birt.report.model.api.IDesignEngineFactory;
import org.openxdata.server.admin.model.exception.UnexpectedException;
import org.openxdata.server.service.SettingService;
import org.openxdata.server.util.OpenXDataUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class manages running of reports.
 * 
 * @author daniel
 *
 */
public class ReportManager {

    private static final Logger log = Logger.getLogger(ReportManager.class);
    
    /** BIRT runtime engine configuration. */
    private static EngineConfig engineConfig;
    
    /** BIRT runtime design configuration. */
    private static DesignConfig designConfig;
    
    /** The BIRT report engine. */
    private IReportEngine reportEngine;
    
    /** The BIRT design engine. */
    private IDesignEngine designEngine;
    
    /** A static instance/singleton of the report manager. */
    private static ReportManager instance;
    
	@Autowired
    private SettingService settingService;

    /**
     * Creates a new instance of the report manager.
     */
    private ReportManager() {
        init();
    }

    /**
     * Sets up the report manager.
     */
    private void init() {
        try {
            Platform.startup(getEngineConfig());
            reportEngine = getReportEngine();
            designEngine = getDesignEngine();

            //logger = reportEngine.getLogger();
            log.info("Started BIRT report engine");//logger.info("Started BIRT report engine");
        } catch (Exception be) {
            log.error("Error starting BIRT ", be);
            throw new IllegalArgumentException("Failure starting BIRT platform", be);
        }
    }

    /**
     * Gets the report manager instance.
     *
     * @return the report manager singleton instance.
     */
    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    /**
     * Get the configuration object for the BIRT report engine.
     *
     * @return returns the configured report object of BIRT report engine.
     */
    public synchronized EngineConfig getEngineConfig() {
        if (engineConfig == null) {
            String birtHome = System.getProperty("user.home") + File.separatorChar + "birt-runtime-2_5_0" + File.separatorChar + "ReportEngine";
            birtHome = settingService.getSetting("birtHome", birtHome); 
            log.info("Creating BIRT engine config with BIRT_HOME = " + birtHome);
            engineConfig = new EngineConfig();
            engineConfig.setEngineHome(birtHome);
            engineConfig.setLogConfig(BirtConstants.LOGGING_DIR, BirtConstants.LOGGING_LEVEL);
        }

        return engineConfig;
    }

    /**
     * Get the configuration object for the BIRT report design.
     *
     * @return returns the configured report object of BIRT report design.
     */
    public synchronized static DesignConfig getDesignConfig() {
        if (designConfig == null) {
            designConfig = new DesignConfig();
        }

        return designConfig;
    }

    /**
     * Configures a report engine if it doesn't already exist.
     *
     * @return	the report engine
     */
    public synchronized IReportEngine getReportEngine() {
        if (reportEngine == null) {
            log.info("Creating instance of the BIRT Report Engine Factory "
                    + IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);

            IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);

            reportEngine = factory.createReportEngine(getEngineConfig());
        }
        return reportEngine;
    }

    /**
     * Get the BIRT design configuration object.
     *
     * @return the BIRT report design engine.
     */
    public synchronized IDesignEngine getDesignEngine() {
        if (designEngine == null) {
            //Configure the Engine and start the Platform
            try {
				Platform.startup(designConfig);
				IDesignEngineFactory factory = (IDesignEngineFactory) Platform.createFactoryObject(IDesignEngineFactory.EXTENSION_DESIGN_ENGINE_FACTORY);
				designEngine = factory.createDesignEngine(designConfig);
			} catch (BirtException e) {
				throw new UnexpectedException(e.getLocalizedMessage());
			}
        }
        return designEngine;
    }

    /**
     * Shuts down the report engine.
     */
    public void shutdown() {
        Platform.shutdown();
    }

    /**
     * Runs a report and returns its output as html.
     *
     * @param baseUrl the server base url.
     * @param reportDesignXml the report design file.
     * @return the report html output.
     */
    public String getReportText(String baseUrl, String reportDesignXml) {
        try {
            InputStream input = new FileInputStream(reportDesignXml);

            ByteArrayOutputStream baos = getReportStream(baseUrl, input, "html");
            if (baos != null) {
                return baos.toString();
            }
        } catch (FileNotFoundException ex) {
        }

        return null;
    }

    /**
     * Runs a report and returns its pdf out put as a byte array.
     *
     * @param baseUrl the server base url.
     * @param reportDesignXml the report design file.
     * @return the report output as a byte array.
     */
    public byte[] getReportBytes(String baseUrl, String reportDesignXml) {
        try {
            InputStream input = new FileInputStream(reportDesignXml);
            ByteArrayOutputStream baos = getReportStream(baseUrl, input, "pdf");
            if (baos != null) {
                return baos.toByteArray();
            }
        } catch (FileNotFoundException ex) {
        }

        return null;
    }

    /**
     * Runs a report and returns a stream having the report output.
     *
     * @param baseUrl the server base url.
     * @param reportDesignXml the report design file.
     * @param format the report output format. For now we only support html and pdf
     * @return the stream containing the report output.
     */
    public ByteArrayOutputStream getReportStream(String baseUrl, InputStream reportDesignXml, String format) {
        try {
            baseUrl += "/";

            IReportRunnable runner = reportEngine.openReportDesign(reportDesignXml);
            IRunAndRenderTask task = reportEngine.createRunAndRenderTask(runner);
            RenderOption renderContext = new RenderOption();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //HttpServletResponse response;
            //options.setOutputStream(response);

            IRenderOption options = null;
            HashMap<String, Object> contextMap = new HashMap<String, Object>();

            if ("pdf".equals(format)) {
                contextMap.put(EngineConstants.APPCONTEXT_PDF_RENDER_CONTEXT, renderContext);

                options = new PDFRenderOption();
                options.setOutputStream(baos);
                options.setOption(IPDFRenderOption.FIT_TO_PAGE, new Boolean(true));
                options.setOption(IPDFRenderOption.PAGEBREAK_PAGINATION_ONLY, new Boolean(true));
                options.setOutputFormat(PDFRenderOption.OUTPUT_FORMAT_PDF);
            } else if ("excel".equals(format)) {
                options = new EXCELRenderOption();
                options.setOutputStream(baos);
                options.setOutputFormat("xls");
            } else {
                HTMLRenderContext rdContext = new HTMLRenderContext();
                rdContext.setBaseImageURL(baseUrl + "birtimages?imageName=");
                rdContext.setBaseURL(baseUrl);
                rdContext.setImageDirectory(settingService.getSetting("birtImageDir", OpenXDataUtil.getApplicationDataDirectory() + "BIRT" + File.separator + "images"));
                rdContext.setSupportedImageFormats("PNG;GIF;JPG;BMP;SVG");

                contextMap.put(EngineConstants.APPCONTEXT_HTML_RENDER_CONTEXT, rdContext);

                options = new HTMLRenderOption();
                options.setOutputStream(baos);
                options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
                ((HTMLRenderOption) options).setEmbeddable(false);

                ((HTMLRenderOption) options).setImageHandler(new HTMLServerImageHandler());
            }

            task.setAppContext(contextMap);
            task.setRenderOption(options);
            task.run();
            task.close();

            return baos;
        } catch (Exception ex) {
            //ex.printStackTrace();
            log.error(ex.getMessage(), ex);
        }

        return null;
    }
}
