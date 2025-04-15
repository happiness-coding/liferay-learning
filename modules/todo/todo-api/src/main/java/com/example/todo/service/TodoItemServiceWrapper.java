/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.todo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodoItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemService
 * @generated
 */
public class TodoItemServiceWrapper
	implements ServiceWrapper<TodoItemService>, TodoItemService {

	public TodoItemServiceWrapper() {
		this(null);
	}

	public TodoItemServiceWrapper(TodoItemService todoItemService) {
		_todoItemService = todoItemService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _todoItemService.getOSGiServiceIdentifier();
	}

	@Override
	public TodoItemService getWrappedService() {
		return _todoItemService;
	}

	@Override
	public void setWrappedService(TodoItemService todoItemService) {
		_todoItemService = todoItemService;
	}

	private TodoItemService _todoItemService;

}