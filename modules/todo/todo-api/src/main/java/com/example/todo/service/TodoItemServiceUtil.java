/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.todo.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for TodoItem. This utility wraps
 * <code>com.example.todo.service.impl.TodoItemServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemService
 * @generated
 */
public class TodoItemServiceUtil {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to <code>com.example.todo.service.impl.TodoItemServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    public static String getOSGiServiceIdentifier() {
        return getService().getOSGiServiceIdentifier();
    }

    public static TodoItemService getService() {
        return _serviceTracker.getService();
    }

    private static final ServiceTracker<TodoItemService, TodoItemService> _serviceTracker;

    static {
        Bundle bundle = FrameworkUtil.getBundle(TodoItemService.class);

        ServiceTracker<TodoItemService, TodoItemService> serviceTracker = null;

        if (bundle != null) {
            serviceTracker = new ServiceTracker<TodoItemService, TodoItemService>(
                bundle.getBundleContext(), TodoItemService.class, null);

            serviceTracker.open();
        }

        _serviceTracker = serviceTracker;
    }
}