package com.liferay.task.management.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.task.management.model.Task;

import java.util.List;

/**
 * Provides the utility for the TaskLocalService. This utility wraps
 * <code>com.liferay.task.management.service.impl.TaskLocalServiceImpl</code> and is the
 * primary access point for service operations in application layer code running
 * on the local server.
 *
 * <p>
 * Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalService
 * @generated
 */
public class TaskLocalServiceUtil {

    public static Task addTask(Task task) {
        return getService().addTask(task);
    }

    public static Task createTask(long taskId) {
        return getService().createTask(taskId);
    }

    public static Task deleteTask(long taskId) throws PortalException {
        return getService().deleteTask(taskId);
    }

    public static Task deleteTask(Task task) {
        return getService().deleteTask(task);
    }

    public static Task fetchTask(long taskId) {
        return getService().fetchTask(taskId);
    }

    public static Task getTask(long taskId) throws PortalException {
        return getService().getTask(taskId);
    }

    public static List<Task> getTasks(int start, int end) {
        return getService().getTasks(start, end);
    }

    public static int getTasksCount() {
        return getService().getTasksCount();
    }

    public static Task updateTask(Task task) {
        return getService().updateTask(task);
    }

    public static List<Task> getTasksByUuidAndCompanyId(
        String uuid, long companyId, int start, int end,
        OrderByComparator<Task> orderByComparator) {

        return getService().getTasksByUuidAndCompanyId(
            uuid, companyId, start, end, orderByComparator);
    }

    public static String getOSGiServiceIdentifier() {
        return getService().getOSGiServiceIdentifier();
    }

    public static TaskLocalService getService() {
        return _service;
    }

    public static void setService(TaskLocalService service) {
        _service = service;
    }

    private static volatile TaskLocalService _service;
}