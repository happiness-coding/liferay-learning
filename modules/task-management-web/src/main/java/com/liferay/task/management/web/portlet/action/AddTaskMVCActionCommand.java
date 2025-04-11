package com.liferay.task.management.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.task.management.model.Task;
import com.liferay.task.management.service.TaskLocalService;
import com.liferay.task.management.web.constants.TaskManagementPortletKeys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + TaskManagementPortletKeys.TASK_MANAGEMENT,
        "mvc.command.name=/task/add_task"
    },
    service = MVCActionCommand.class
)
public class AddTaskMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        // Get parameters from the request
        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");
        String dueDateString = ParamUtil.getString(actionRequest, "dueDate");
        int status = ParamUtil.getInteger(actionRequest, "status");
        int priority = ParamUtil.getInteger(actionRequest, "priority");

        // Parse date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate = dueDateString.isEmpty() ? null : sdf.parse(dueDateString);

        // Get service context
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            actionRequest);

        // Add task
        Task task = _taskLocalService.createTask(0); // Create a new task with primary key 0
        task.setUserId(serviceContext.getUserId());
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setPriority(priority);
        _taskLocalService.addTask(task);

        // Set success message
        sendRedirect(actionRequest, actionResponse);
    }

    @Reference
    private TaskLocalService _taskLocalService;
}