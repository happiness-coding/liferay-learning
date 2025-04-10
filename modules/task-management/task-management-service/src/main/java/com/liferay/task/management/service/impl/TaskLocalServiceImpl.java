package com.liferay.task.management.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.task.management.model.Task;
import com.liferay.task.management.service.base.TaskLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
    property = "model.class.name=com.liferay.task.management.model.Task",
    service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

    public Task addTask(
        long userId, String title, String description,
        Date dueDate, int status, int priority,
        ServiceContext serviceContext) throws PortalException {

        long groupId = serviceContext.getScopeGroupId();
        User user = userLocalService.getUser(userId);

        long taskId = counterLocalService.increment();

        Task task = taskPersistence.create(taskId);

        // Set audit fields
        task.setCompanyId(user.getCompanyId());
        task.setUserId(userId);
        task.setUserName(user.getFullName());
        task.setGroupId(groupId);

        Date now = new Date();
        task.setCreateDate(serviceContext.getCreateDate(now));
        task.setModifiedDate(serviceContext.getModifiedDate(now));

        // Set task fields
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setPriority(priority);

        return taskLocalService.updateTask(task);
    }

    public Task updateTask(
        long taskId, String title, String description,
        Date dueDate, int status, int priority,
        ServiceContext serviceContext) throws PortalException {

        Task task = taskPersistence.findByPrimaryKey(taskId);

        task.setModifiedDate(new Date());
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setPriority(priority);

        return taskLocalService.updateTask(task);
    }

    public List<Task> getTasksByGroupId(long groupId) {
        return taskPersistence.findByGroupId(groupId);
    }

    public List<Task> getTasksByUserId(long userId) {
        return taskPersistence.findByUserId(userId);
    }

    public List<Task> getTasksByStatus(int status) {
        return taskPersistence.findByStatus(status);
    }
}