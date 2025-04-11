package com.liferay.task.management.service;

import com.liferay.task.management.service.TaskService;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class TaskServiceUtil {

    private static ServiceTracker<TaskService, TaskService> _serviceTracker;

    static {
        // Initialize the ServiceTracker to track the TaskService
        _serviceTracker = new ServiceTracker<>(
            FrameworkUtil.getBundle(TaskServiceUtil.class).getBundleContext(),
            TaskService.class, null);

        _serviceTracker.open();
    }

    public static TaskService getService() {
        return _serviceTracker.getService();
    }
}