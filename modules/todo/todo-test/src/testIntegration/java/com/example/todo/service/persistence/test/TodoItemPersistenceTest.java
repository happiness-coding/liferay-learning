/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.todo.service.persistence.test;

import com.example.todo.exception.NoSuchItemException;
import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoItemLocalServiceUtil;
import com.example.todo.service.persistence.TodoItemPersistence;
import com.example.todo.service.persistence.TodoItemUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class TodoItemPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.example.todo.service"));

	@Before
	public void setUp() {
		_persistence = TodoItemUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TodoItem> iterator = _todoItems.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TodoItem todoItem = _persistence.create(pk);

		Assert.assertNotNull(todoItem);

		Assert.assertEquals(todoItem.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TodoItem newTodoItem = addTodoItem();

		_persistence.remove(newTodoItem);

		TodoItem existingTodoItem = _persistence.fetchByPrimaryKey(
			newTodoItem.getPrimaryKey());

		Assert.assertNull(existingTodoItem);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTodoItem();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TodoItem newTodoItem = _persistence.create(pk);

		newTodoItem.setUuid(RandomTestUtil.randomString());

		newTodoItem.setGroupId(RandomTestUtil.nextLong());

		newTodoItem.setCompanyId(RandomTestUtil.nextLong());

		newTodoItem.setUserId(RandomTestUtil.nextLong());

		newTodoItem.setUserName(RandomTestUtil.randomString());

		newTodoItem.setCreateDate(RandomTestUtil.nextDate());

		newTodoItem.setModifiedDate(RandomTestUtil.nextDate());

		newTodoItem.setTitle(RandomTestUtil.randomString());

		newTodoItem.setDescription(RandomTestUtil.randomString());

		newTodoItem.setDueDate(RandomTestUtil.nextDate());

		newTodoItem.setCompleted(RandomTestUtil.randomBoolean());

		newTodoItem.setPriority(RandomTestUtil.nextInt());

		_todoItems.add(_persistence.update(newTodoItem));

		TodoItem existingTodoItem = _persistence.findByPrimaryKey(
			newTodoItem.getPrimaryKey());

		Assert.assertEquals(existingTodoItem.getUuid(), newTodoItem.getUuid());
		Assert.assertEquals(
			existingTodoItem.getTodoItemId(), newTodoItem.getTodoItemId());
		Assert.assertEquals(
			existingTodoItem.getGroupId(), newTodoItem.getGroupId());
		Assert.assertEquals(
			existingTodoItem.getCompanyId(), newTodoItem.getCompanyId());
		Assert.assertEquals(
			existingTodoItem.getUserId(), newTodoItem.getUserId());
		Assert.assertEquals(
			existingTodoItem.getUserName(), newTodoItem.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTodoItem.getCreateDate()),
			Time.getShortTimestamp(newTodoItem.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTodoItem.getModifiedDate()),
			Time.getShortTimestamp(newTodoItem.getModifiedDate()));
		Assert.assertEquals(
			existingTodoItem.getTitle(), newTodoItem.getTitle());
		Assert.assertEquals(
			existingTodoItem.getDescription(), newTodoItem.getDescription());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTodoItem.getDueDate()),
			Time.getShortTimestamp(newTodoItem.getDueDate()));
		Assert.assertEquals(
			existingTodoItem.isCompleted(), newTodoItem.isCompleted());
		Assert.assertEquals(
			existingTodoItem.getPriority(), newTodoItem.getPriority());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByG_U() throws Exception {
		_persistence.countByG_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByG_U(0L, 0L);
	}

	@Test
	public void testCountByG_C() throws Exception {
		_persistence.countByG_C(
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByG_C(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		TodoItem newTodoItem = addTodoItem();

		TodoItem existingTodoItem = _persistence.findByPrimaryKey(
			newTodoItem.getPrimaryKey());

		Assert.assertEquals(existingTodoItem, newTodoItem);
	}

	@Test(expected = NoSuchItemException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<TodoItem> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Todo_TodoItem", "uuid", true, "todoItemId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "title", true, "description", true,
			"dueDate", true, "completed", true, "priority", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TodoItem newTodoItem = addTodoItem();

		TodoItem existingTodoItem = _persistence.fetchByPrimaryKey(
			newTodoItem.getPrimaryKey());

		Assert.assertEquals(existingTodoItem, newTodoItem);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TodoItem missingTodoItem = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTodoItem);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		TodoItem newTodoItem1 = addTodoItem();
		TodoItem newTodoItem2 = addTodoItem();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTodoItem1.getPrimaryKey());
		primaryKeys.add(newTodoItem2.getPrimaryKey());

		Map<Serializable, TodoItem> todoItems = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, todoItems.size());
		Assert.assertEquals(
			newTodoItem1, todoItems.get(newTodoItem1.getPrimaryKey()));
		Assert.assertEquals(
			newTodoItem2, todoItems.get(newTodoItem2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TodoItem> todoItems = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(todoItems.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		TodoItem newTodoItem = addTodoItem();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTodoItem.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TodoItem> todoItems = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, todoItems.size());
		Assert.assertEquals(
			newTodoItem, todoItems.get(newTodoItem.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TodoItem> todoItems = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(todoItems.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		TodoItem newTodoItem = addTodoItem();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTodoItem.getPrimaryKey());

		Map<Serializable, TodoItem> todoItems = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, todoItems.size());
		Assert.assertEquals(
			newTodoItem, todoItems.get(newTodoItem.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TodoItemLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<TodoItem>() {

				@Override
				public void performAction(TodoItem todoItem) {
					Assert.assertNotNull(todoItem);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		TodoItem newTodoItem = addTodoItem();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TodoItem.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"todoItemId", newTodoItem.getTodoItemId()));

		List<TodoItem> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		TodoItem existingTodoItem = result.get(0);

		Assert.assertEquals(existingTodoItem, newTodoItem);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TodoItem.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"todoItemId", RandomTestUtil.nextLong()));

		List<TodoItem> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		TodoItem newTodoItem = addTodoItem();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TodoItem.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("todoItemId"));

		Object newTodoItemId = newTodoItem.getTodoItemId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"todoItemId", new Object[] {newTodoItemId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTodoItemId = result.get(0);

		Assert.assertEquals(existingTodoItemId, newTodoItemId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TodoItem.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("todoItemId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"todoItemId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		TodoItem newTodoItem = addTodoItem();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newTodoItem.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		TodoItem newTodoItem = addTodoItem();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TodoItem.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"todoItemId", newTodoItem.getTodoItemId()));

		List<TodoItem> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(TodoItem todoItem) {
		Assert.assertEquals(
			todoItem.getUuid(),
			ReflectionTestUtil.invoke(
				todoItem, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(todoItem.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				todoItem, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected TodoItem addTodoItem() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TodoItem todoItem = _persistence.create(pk);

		todoItem.setUuid(RandomTestUtil.randomString());

		todoItem.setGroupId(RandomTestUtil.nextLong());

		todoItem.setCompanyId(RandomTestUtil.nextLong());

		todoItem.setUserId(RandomTestUtil.nextLong());

		todoItem.setUserName(RandomTestUtil.randomString());

		todoItem.setCreateDate(RandomTestUtil.nextDate());

		todoItem.setModifiedDate(RandomTestUtil.nextDate());

		todoItem.setTitle(RandomTestUtil.randomString());

		todoItem.setDescription(RandomTestUtil.randomString());

		todoItem.setDueDate(RandomTestUtil.nextDate());

		todoItem.setCompleted(RandomTestUtil.randomBoolean());

		todoItem.setPriority(RandomTestUtil.nextInt());

		_todoItems.add(_persistence.update(todoItem));

		return todoItem;
	}

	private List<TodoItem> _todoItems = new ArrayList<TodoItem>();
	private TodoItemPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}