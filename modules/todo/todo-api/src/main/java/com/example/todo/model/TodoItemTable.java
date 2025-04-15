/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.todo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Todo_TodoItem&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItem
 * @generated
 */
public class TodoItemTable extends BaseTable<TodoItemTable> {

	public static final TodoItemTable INSTANCE = new TodoItemTable();

	public final Column<TodoItemTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Long> todoItemId = createColumn(
		"todoItemId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TodoItemTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Date> dueDate = createColumn(
		"dueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Boolean> completed = createColumn(
		"completed", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TodoItemTable, Integer> priority = createColumn(
		"priority", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private TodoItemTable() {
		super("Todo_TodoItem", TodoItemTable::new);
	}

}