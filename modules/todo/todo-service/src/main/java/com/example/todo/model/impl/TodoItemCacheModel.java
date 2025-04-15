/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.todo.model.impl;

import com.example.todo.model.TodoItem;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TodoItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodoItemCacheModel
	implements CacheModel<TodoItem>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodoItemCacheModel)) {
			return false;
		}

		TodoItemCacheModel todoItemCacheModel = (TodoItemCacheModel)object;

		if (todoItemId == todoItemCacheModel.todoItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, todoItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", todoItemId=");
		sb.append(todoItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", completed=");
		sb.append(completed);
		sb.append(", priority=");
		sb.append(priority);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TodoItem toEntityModel() {
		TodoItemImpl todoItemImpl = new TodoItemImpl();

		if (uuid == null) {
			todoItemImpl.setUuid("");
		}
		else {
			todoItemImpl.setUuid(uuid);
		}

		todoItemImpl.setTodoItemId(todoItemId);
		todoItemImpl.setGroupId(groupId);
		todoItemImpl.setCompanyId(companyId);
		todoItemImpl.setUserId(userId);

		if (userName == null) {
			todoItemImpl.setUserName("");
		}
		else {
			todoItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			todoItemImpl.setCreateDate(null);
		}
		else {
			todoItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			todoItemImpl.setModifiedDate(null);
		}
		else {
			todoItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			todoItemImpl.setTitle("");
		}
		else {
			todoItemImpl.setTitle(title);
		}

		if (description == null) {
			todoItemImpl.setDescription("");
		}
		else {
			todoItemImpl.setDescription(description);
		}

		if (dueDate == Long.MIN_VALUE) {
			todoItemImpl.setDueDate(null);
		}
		else {
			todoItemImpl.setDueDate(new Date(dueDate));
		}

		todoItemImpl.setCompleted(completed);
		todoItemImpl.setPriority(priority);

		todoItemImpl.resetOriginalValues();

		return todoItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		todoItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		dueDate = objectInput.readLong();

		completed = objectInput.readBoolean();

		priority = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(todoItemId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(dueDate);

		objectOutput.writeBoolean(completed);

		objectOutput.writeInt(priority);
	}

	public String uuid;
	public long todoItemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long dueDate;
	public boolean completed;
	public int priority;

}