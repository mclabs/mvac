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
package org.openxdata.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for database accessing unit tests.
 * 
 * @author daniel
 * @author charles
 * @author Angel
 * @author Jonny Heggheim
 *
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:openxdata-test-applicationContext.xml"})
public abstract class BaseContextSensitiveTest {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private DataSource dataSource;
    private static IDataSet initialDataSet;
    private static final String INITIAL_XML_DATASET_LOCATION =
            "org/openxdata/include/initialInMemoryTestDataSet.xml";

    @BeforeClass
    public static void createInitialDataset() throws DataSetException, IOException {
        URL file = getInitalDatasetURL();
        initialDataSet = createDataset(file);
    }

    @Before
    public void runBeforeEachTest() throws Exception {
        initializeInMemoryDatabase();
        authenticate();
    }

    protected void initializeInMemoryDatabase() throws Exception {
        executeDataSet(initialDataSet);
    }

    private void authenticate() throws OpenXDataException {
        authenticationService.authenticate("admin", "admin");
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private void executeDataSet(IDataSet dataset) throws Exception {
        IDatabaseConnection dbUnitConn = createDBUnitConnection();

        turnOffTheDatabaseConstraints();
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, dataset);
        turnForeignKeyChecksBackOn();
    }

    private IDatabaseConnection createDBUnitConnection() throws DatabaseUnitException, SQLException {
        Connection connection = getConnection();
        IDatabaseConnection dbUnitConn = new DatabaseConnection(connection);
        // use the hsql datatypefactory so that boolean properties work correctly
        DatabaseConfig config = dbUnitConn.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());

        return dbUnitConn;
    }

    private void turnOffTheDatabaseConstraints() throws SQLException {
        String sql = "SET REFERENTIAL_INTEGRITY FALSE";
        executeSql(sql);
    }

    private void turnForeignKeyChecksBackOn() throws SQLException {
        String sql = "SET REFERENTIAL_INTEGRITY TRUE";
        executeSql(sql);
    }

    private void executeSql(String sql) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try {
            statement.execute();
        } finally {
            statement.close();
        }
    }

    private static URL getInitalDatasetURL() throws FileNotFoundException {
        URL file = ClassLoader.getSystemResource(INITIAL_XML_DATASET_LOCATION);
        if (file == null) {
            throw new FileNotFoundException("Unable to find '" + INITIAL_XML_DATASET_LOCATION + "' in the classpath");
        }
        return file;
    }

    private static IDataSet createDataset(URL file) throws IOException, DataSetException {
        final boolean dtdMetadata = false;
        final boolean columnSensing = true;
        final boolean caseSensitiveTableNames = false;

        return new FlatXmlDataSet(file, dtdMetadata, columnSensing, caseSensitiveTableNames);
    }
}
