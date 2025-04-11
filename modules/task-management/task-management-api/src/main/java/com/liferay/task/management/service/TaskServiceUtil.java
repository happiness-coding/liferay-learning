package com.liferay.task.management.service;

import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.task.management.service.TaskService;

/**
 * Provides the remote service utility for Task. This utility wraps
 * <code>com.liferay.task.management.service.impl.TaskServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @see TaskService
 * @generated
 */
public class TaskServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.task.management.service.impl.TaskServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static TaskService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<TaskService> _serviceSnapshot =
		new Snapshot<>(TaskServiceUtil.class, TaskService.class);

}