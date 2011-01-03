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
package org.openxdata.server.database.liquibase.customchanges;

import java.sql.SQLException;

import liquibase.FileOpener;
import liquibase.change.custom.CustomSqlChange;
import liquibase.database.Database;
import liquibase.database.DatabaseConnection;
import liquibase.database.sql.RawSqlStatement;
import liquibase.database.sql.SqlStatement;
import liquibase.exception.CustomChangeException;
import liquibase.exception.InvalidChangeDefinitionException;
import liquibase.exception.SetupException;
import liquibase.exception.UnsupportedChangeException;

/**
 * Manages liquibase changeset [permissions_change_id_021] for mapping the
 * administrator role to the administrator user
 * 
 * Look at changeset permissions_change_id_021 in liquibase-update-to-latest.xml
 * 
 * @author Angel, Ronald
 */
public class AdminRoleMapToUser implements CustomSqlChange {

	private int userId = 0;
	private int roleId = 0;

	private String tableName = "user_role";

	private FileOpener fileOpener;

	private String userName = "admin";
	private String roleName = "Role_Administrator";

	@Override
	public SqlStatement[] generateStatements(Database database)
			throws UnsupportedChangeException, CustomChangeException {

		DatabaseConnection connection = database.getConnection();
		try {
			userId = processUserId(connection);
			roleId = processRoleId(connection);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		if (roleId == 0 || userId == 0)
			return null;

		return new SqlStatement[] { new RawSqlStatement("Insert Into "
				+ tableName + "(`user_id`, `role_id`)" + "Values(" + userId
				+ "," + roleId + ")") };
	}

	private int processRoleId(DatabaseConnection connection) throws SQLException {

		String roleTableName = "role";
		
		String productName = connection.getMetaData().getDatabaseProductName();
		//h2 requires the role table name to be quoted.
		if (productName.equals("H2"))
			roleTableName = "\"" + roleTableName + "\"";
		
		int id = 0;

		java.sql.Statement roleStatement = connection.createStatement();
		java.sql.ResultSet roleResultSet = roleStatement
				.executeQuery("SELECT role_id FROM " + roleTableName + " WHERE name LIKE '"
						+ roleName + "'");

		if (roleResultSet.first())
			id = roleResultSet.getInt("role_id");

		return id;
	}

	private int processUserId(DatabaseConnection conn) throws SQLException {

		int id = 0;

		java.sql.Statement statement = conn.createStatement();
		java.sql.ResultSet userResultSet = statement
				.executeQuery("SELECT user_id FROM users WHERE user_name LIKE '"
						+ userName + "'");

		if (userResultSet.first())
			id = userResultSet.getInt("user_id");

		return id;
	}

	@Override
	public String getConfirmationMessage() {
		return " {Mark - Custom Id=C001} Custom class updated " + tableName
				+ "By Angel";

	}

	@Override
	public void setFileOpener(FileOpener fileOpener) {

		if (this.fileOpener != null && fileOpener != null)
			this.fileOpener = fileOpener;

	}

	@Override
	public void setUp() throws SetupException {
	}

	@Override
	public void validate(Database database)
			throws InvalidChangeDefinitionException {
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}
