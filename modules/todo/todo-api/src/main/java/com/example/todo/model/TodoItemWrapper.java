/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.todo.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TodoItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItem
 * @generated
 */
public class TodoItemWrapper
	extends BaseModelWrapper<TodoItem>
	implements ModelWrapper<TodoItem>, TodoItem {

	public TodoItemWrapper(TodoItem todoItem) {
		super(todoItem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("todoItemId", getTodoItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("dueDate", getDueDate());
		attributes.put("completed", isCompleted());
		attributes.put("priority", getPriority());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long todoItemId = (Long)attributes.get("todoItemId");

		if (todoItemId != null) {
			setTodoItemId(todoItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Boolean completed = (Boolean)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}
	}

	@Override
	public TodoItem cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this todo item.
	 *
	 * @return the company ID of this todo item
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the completed of this todo item.
	 *
	 * @return the completed of this todo item
	 */
	@Override
	public boolean getCompleted() {
		return model.getCompleted();
	}

	/**
	 * Returns the create date of this todo item.
	 *
	 * @return the create date of this todo item
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this todo item.
	 *
	 * @return the description of this todo item
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the due date of this todo item.
	 *
	 * @return the due date of this todo item
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the group ID of this todo item.
	 *
	 * @return the group ID of this todo item
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this todo item.
	 *
	 * @return the modified date of this todo item
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this todo item.
	 *
	 * @return the primary key of this todo item
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this todo item.
	 *
	 * @return the priority of this todo item
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the title of this todo item.
	 *
	 * @return the title of this todo item
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the todo item ID of this todo item.
	 *
	 * @return the todo item ID of this todo item
	 */
	@Override
	public long getTodoItemId() {
		return model.getTodoItemId();
	}

	/**
	 * Returns the user ID of this todo item.
	 *
	 * @return the user ID of this todo item
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this todo item.
	 *
	 * @return the user name of this todo item
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this todo item.
	 *
	 * @return the user uuid of this todo item
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this todo item.
	 *
	 * @return the uuid of this todo item
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this todo item is completed.
	 *
	 * @return <code>true</code> if this todo item is completed; <code>false</code> otherwise
	 */
	@Override
	public boolean isCompleted() {
		return model.isCompleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this todo item.
	 *
	 * @param companyId the company ID of this todo item
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets whether this todo item is completed.
	 *
	 * @param completed the completed of this todo item
	 */
	@Override
	public void setCompleted(boolean completed) {
		model.setCompleted(completed);
	}

	/**
	 * Sets the create date of this todo item.
	 *
	 * @param createDate the create date of this todo item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this todo item.
	 *
	 * @param description the description of this todo item
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the due date of this todo item.
	 *
	 * @param dueDate the due date of this todo item
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the group ID of this todo item.
	 *
	 * @param groupId the group ID of this todo item
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this todo item.
	 *
	 * @param modifiedDate the modified date of this todo item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this todo item.
	 *
	 * @param primaryKey the primary key of this todo item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this todo item.
	 *
	 * @param priority the priority of this todo item
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the title of this todo item.
	 *
	 * @param title the title of this todo item
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the todo item ID of this todo item.
	 *
	 * @param todoItemId the todo item ID of this todo item
	 */
	@Override
	public void setTodoItemId(long todoItemId) {
		model.setTodoItemId(todoItemId);
	}

	/**
	 * Sets the user ID of this todo item.
	 *
	 * @param userId the user ID of this todo item
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this todo item.
	 *
	 * @param userName the user name of this todo item
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this todo item.
	 *
	 * @param userUuid the user uuid of this todo item
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this todo item.
	 *
	 * @param uuid the uuid of this todo item
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TodoItemWrapper wrap(TodoItem todoItem) {
		return new TodoItemWrapper(todoItem);
	}

}