/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.task.management.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.task.management.model.Task;
import com.liferay.task.management.model.TaskModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Task service. Represents a row in the &quot;TaskManagement_Task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TaskModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskImpl
 * @generated
 */
@JSON(strict = true)
public class TaskModelImpl extends BaseModelImpl<Task> implements TaskModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task model instance should use the <code>Task</code> interface instead.
	 */
	public static final String TABLE_NAME = "TaskManagement_Task";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"taskId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"title", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"dueDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"priority", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dueDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("priority", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table TaskManagement_Task (uuid_ VARCHAR(75) null,taskId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,description VARCHAR(75) null,dueDate DATE null,status INTEGER,priority INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table TaskManagement_Task";

	public static final String ORDER_BY_JPQL = " ORDER BY task.taskId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY TaskManagement_Task.taskId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TASKID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public TaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _taskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Task.class;
	}

	@Override
	public String getModelClassName() {
		return Task.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Task, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Task, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Task, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Task)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Task, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Task, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Task)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Task, Object>> getAttributeGetterFunctions() {
		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Task, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Task, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Task, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Task, Object>>();

			attributeGetterFunctions.put("uuid", Task::getUuid);
			attributeGetterFunctions.put("taskId", Task::getTaskId);
			attributeGetterFunctions.put("groupId", Task::getGroupId);
			attributeGetterFunctions.put("companyId", Task::getCompanyId);
			attributeGetterFunctions.put("userId", Task::getUserId);
			attributeGetterFunctions.put("userName", Task::getUserName);
			attributeGetterFunctions.put("createDate", Task::getCreateDate);
			attributeGetterFunctions.put("modifiedDate", Task::getModifiedDate);
			attributeGetterFunctions.put("title", Task::getTitle);
			attributeGetterFunctions.put("description", Task::getDescription);
			attributeGetterFunctions.put("dueDate", Task::getDueDate);
			attributeGetterFunctions.put("status", Task::getStatus);
			attributeGetterFunctions.put("priority", Task::getPriority);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Task, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Task, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Task, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Task, String>)Task::setUuid);
			attributeSetterBiConsumers.put(
				"taskId", (BiConsumer<Task, Long>)Task::setTaskId);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Task, Long>)Task::setGroupId);
			attributeSetterBiConsumers.put(
				"companyId", (BiConsumer<Task, Long>)Task::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Task, Long>)Task::setUserId);
			attributeSetterBiConsumers.put(
				"userName", (BiConsumer<Task, String>)Task::setUserName);
			attributeSetterBiConsumers.put(
				"createDate", (BiConsumer<Task, Date>)Task::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate", (BiConsumer<Task, Date>)Task::setModifiedDate);
			attributeSetterBiConsumers.put(
				"title", (BiConsumer<Task, String>)Task::setTitle);
			attributeSetterBiConsumers.put(
				"description", (BiConsumer<Task, String>)Task::setDescription);
			attributeSetterBiConsumers.put(
				"dueDate", (BiConsumer<Task, Date>)Task::setDueDate);
			attributeSetterBiConsumers.put(
				"status", (BiConsumer<Task, Integer>)Task::setStatus);
			attributeSetterBiConsumers.put(
				"priority", (BiConsumer<Task, Integer>)Task::setPriority);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getTaskId() {
		return _taskId;
	}

	@Override
	public void setTaskId(long taskId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_taskId = taskId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public Date getDueDate() {
		return _dueDate;
	}

	@Override
	public void setDueDate(Date dueDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dueDate = dueDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalStatus() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("status"));
	}

	@JSON
	@Override
	public int getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(int priority) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_priority = priority;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Task.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Task.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Task toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Task>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TaskImpl taskImpl = new TaskImpl();

		taskImpl.setUuid(getUuid());
		taskImpl.setTaskId(getTaskId());
		taskImpl.setGroupId(getGroupId());
		taskImpl.setCompanyId(getCompanyId());
		taskImpl.setUserId(getUserId());
		taskImpl.setUserName(getUserName());
		taskImpl.setCreateDate(getCreateDate());
		taskImpl.setModifiedDate(getModifiedDate());
		taskImpl.setTitle(getTitle());
		taskImpl.setDescription(getDescription());
		taskImpl.setDueDate(getDueDate());
		taskImpl.setStatus(getStatus());
		taskImpl.setPriority(getPriority());

		taskImpl.resetOriginalValues();

		return taskImpl;
	}

	@Override
	public Task cloneWithOriginalValues() {
		TaskImpl taskImpl = new TaskImpl();

		taskImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		taskImpl.setTaskId(this.<Long>getColumnOriginalValue("taskId"));
		taskImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		taskImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		taskImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		taskImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		taskImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		taskImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		taskImpl.setTitle(this.<String>getColumnOriginalValue("title"));
		taskImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		taskImpl.setDueDate(this.<Date>getColumnOriginalValue("dueDate"));
		taskImpl.setStatus(this.<Integer>getColumnOriginalValue("status"));
		taskImpl.setPriority(this.<Integer>getColumnOriginalValue("priority"));

		return taskImpl;
	}

	@Override
	public int compareTo(Task task) {
		long primaryKey = task.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Task)) {
			return false;
		}

		Task task = (Task)object;

		long primaryKey = task.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Task> toCacheModel() {
		TaskCacheModel taskCacheModel = new TaskCacheModel();

		taskCacheModel.uuid = getUuid();

		String uuid = taskCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			taskCacheModel.uuid = null;
		}

		taskCacheModel.taskId = getTaskId();

		taskCacheModel.groupId = getGroupId();

		taskCacheModel.companyId = getCompanyId();

		taskCacheModel.userId = getUserId();

		taskCacheModel.userName = getUserName();

		String userName = taskCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			taskCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			taskCacheModel.createDate = createDate.getTime();
		}
		else {
			taskCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			taskCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			taskCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		taskCacheModel.title = getTitle();

		String title = taskCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			taskCacheModel.title = null;
		}

		taskCacheModel.description = getDescription();

		String description = taskCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			taskCacheModel.description = null;
		}

		Date dueDate = getDueDate();

		if (dueDate != null) {
			taskCacheModel.dueDate = dueDate.getTime();
		}
		else {
			taskCacheModel.dueDate = Long.MIN_VALUE;
		}

		taskCacheModel.status = getStatus();

		taskCacheModel.priority = getPriority();

		return taskCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Task, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Task, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Task, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Task)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Task>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Task.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _taskId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _title;
	private String _description;
	private Date _dueDate;
	private int _status;
	private int _priority;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Task, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Task)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("taskId", _taskId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("dueDate", _dueDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("priority", _priority);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("taskId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("title", 256L);

		columnBitmasks.put("description", 512L);

		columnBitmasks.put("dueDate", 1024L);

		columnBitmasks.put("status", 2048L);

		columnBitmasks.put("priority", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Task _escapedModel;

}