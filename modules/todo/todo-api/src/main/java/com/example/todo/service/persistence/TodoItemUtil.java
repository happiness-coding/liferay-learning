/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.todo.service.persistence;

import com.example.todo.model.TodoItem;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the todo item service. This utility wraps <code>com.example.todo.service.persistence.impl.TodoItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemPersistence
 * @generated
 */
public class TodoItemUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TodoItem todoItem) {
		getPersistence().clearCache(todoItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TodoItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TodoItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TodoItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TodoItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TodoItem update(TodoItem todoItem) {
		return getPersistence().update(todoItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TodoItem update(
		TodoItem todoItem, ServiceContext serviceContext) {

		return getPersistence().update(todoItem, serviceContext);
	}

	/**
	 * Returns all the todo items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching todo items
	 */
	public static List<TodoItem> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the todo items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public static List<TodoItem> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TodoItem> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByUuid_First(
			String uuid, OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByUuid_First(
		String uuid, OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByUuid_Last(
			String uuid, OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByUuid_Last(
		String uuid, OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where uuid = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchItemException if a todo item with the primary key could not be found
	 */
	public static TodoItem[] findByUuid_PrevAndNext(
			long todoItemId, String uuid,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByUuid_PrevAndNext(
			todoItemId, uuid, orderByComparator);
	}

	/**
	 * Removes all the todo items where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of todo items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching todo items
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the todo item where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchItemException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByUUID_G(String uuid, long groupId)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the todo item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the todo item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the todo item where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the todo item that was removed
	 */
	public static TodoItem removeByUUID_G(String uuid, long groupId)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of todo items where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching todo items
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching todo items
	 */
	public static List<TodoItem> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public static List<TodoItem> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TodoItem> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchItemException if a todo item with the primary key could not be found
	 */
	public static TodoItem[] findByUuid_C_PrevAndNext(
			long todoItemId, String uuid, long companyId,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByUuid_C_PrevAndNext(
			todoItemId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the todo items where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching todo items
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the todo items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching todo items
	 */
	public static List<TodoItem> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the todo items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public static List<TodoItem> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the todo items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todo items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TodoItem> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByGroupId_First(
			long groupId, OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first todo item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByGroupId_First(
		long groupId, OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByGroupId_Last(
			long groupId, OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByGroupId_Last(
		long groupId, OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where groupId = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchItemException if a todo item with the primary key could not be found
	 */
	public static TodoItem[] findByGroupId_PrevAndNext(
			long todoItemId, long groupId,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByGroupId_PrevAndNext(
			todoItemId, groupId, orderByComparator);
	}

	/**
	 * Removes all the todo items where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of todo items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching todo items
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the todo items where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching todo items
	 */
	public static List<TodoItem> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the todo items where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public static List<TodoItem> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the todo items where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todo items where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<TodoItem> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo item in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByG_U_First(
			long groupId, long userId,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first todo item in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchItemException if a todo item with the primary key could not be found
	 */
	public static TodoItem[] findByG_U_PrevAndNext(
			long todoItemId, long groupId, long userId,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByG_U_PrevAndNext(
			todoItemId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the todo items where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of todo items where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching todo items
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns all the todo items where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @return the matching todo items
	 */
	public static List<TodoItem> findByG_C(long groupId, boolean completed) {
		return getPersistence().findByG_C(groupId, completed);
	}

	/**
	 * Returns a range of all the todo items where groupId = &#63; and completed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public static List<TodoItem> findByG_C(
		long groupId, boolean completed, int start, int end) {

		return getPersistence().findByG_C(groupId, completed, start, end);
	}

	/**
	 * Returns an ordered range of all the todo items where groupId = &#63; and completed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByG_C(
		long groupId, boolean completed, int start, int end,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, completed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todo items where groupId = &#63; and completed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public static List<TodoItem> findByG_C(
		long groupId, boolean completed, int start, int end,
		OrderByComparator<TodoItem> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, completed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first todo item in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByG_C_First(
			long groupId, boolean completed,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByG_C_First(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the first todo item in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByG_C_First(
		long groupId, boolean completed,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchItemException if a matching todo item could not be found
	 */
	public static TodoItem findByG_C_Last(
			long groupId, boolean completed,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByG_C_Last(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the last todo item in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static TodoItem fetchByG_C_Last(
		long groupId, boolean completed,
		OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchItemException if a todo item with the primary key could not be found
	 */
	public static TodoItem[] findByG_C_PrevAndNext(
			long todoItemId, long groupId, boolean completed,
			OrderByComparator<TodoItem> orderByComparator)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByG_C_PrevAndNext(
			todoItemId, groupId, completed, orderByComparator);
	}

	/**
	 * Removes all the todo items where groupId = &#63; and completed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 */
	public static void removeByG_C(long groupId, boolean completed) {
		getPersistence().removeByG_C(groupId, completed);
	}

	/**
	 * Returns the number of todo items where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @return the number of matching todo items
	 */
	public static int countByG_C(long groupId, boolean completed) {
		return getPersistence().countByG_C(groupId, completed);
	}

	/**
	 * Caches the todo item in the entity cache if it is enabled.
	 *
	 * @param todoItem the todo item
	 */
	public static void cacheResult(TodoItem todoItem) {
		getPersistence().cacheResult(todoItem);
	}

	/**
	 * Caches the todo items in the entity cache if it is enabled.
	 *
	 * @param todoItems the todo items
	 */
	public static void cacheResult(List<TodoItem> todoItems) {
		getPersistence().cacheResult(todoItems);
	}

	/**
	 * Creates a new todo item with the primary key. Does not add the todo item to the database.
	 *
	 * @param todoItemId the primary key for the new todo item
	 * @return the new todo item
	 */
	public static TodoItem create(long todoItemId) {
		return getPersistence().create(todoItemId);
	}

	/**
	 * Removes the todo item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item that was removed
	 * @throws NoSuchItemException if a todo item with the primary key could not be found
	 */
	public static TodoItem remove(long todoItemId)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().remove(todoItemId);
	}

	public static TodoItem updateImpl(TodoItem todoItem) {
		return getPersistence().updateImpl(todoItem);
	}

	/**
	 * Returns the todo item with the primary key or throws a <code>NoSuchItemException</code> if it could not be found.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item
	 * @throws NoSuchItemException if a todo item with the primary key could not be found
	 */
	public static TodoItem findByPrimaryKey(long todoItemId)
		throws com.example.todo.exception.NoSuchItemException {

		return getPersistence().findByPrimaryKey(todoItemId);
	}

	/**
	 * Returns the todo item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item, or <code>null</code> if a todo item with the primary key could not be found
	 */
	public static TodoItem fetchByPrimaryKey(long todoItemId) {
		return getPersistence().fetchByPrimaryKey(todoItemId);
	}

	/**
	 * Returns all the todo items.
	 *
	 * @return the todo items
	 */
	public static List<TodoItem> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the todo items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of todo items
	 */
	public static List<TodoItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the todo items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of todo items
	 */
	public static List<TodoItem> findAll(
		int start, int end, OrderByComparator<TodoItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todo items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of todo items
	 */
	public static List<TodoItem> findAll(
		int start, int end, OrderByComparator<TodoItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the todo items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of todo items.
	 *
	 * @return the number of todo items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TodoItemPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TodoItemPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TodoItemPersistence _persistence;

}