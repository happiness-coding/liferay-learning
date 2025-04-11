package com.liferay.task.management.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.task.management.service.TaskLocalService;
import com.liferay.task.management.web.constants.TaskManagementPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + TaskManagementPortletKeys.TASK_MANAGEMENT,
        "mvc.command.name=/task/delete_task"
    },
    service = MVCActionCommand.class
)
public class DeleteTaskMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        long taskId = ParamUtil.getLong(actionRequest, "taskId");

        _taskLocalService.deleteTask(taskId);

        sendRedirect(actionRequest, actionResponse);
    }

    @Reference
    private TaskLocalService _taskLocalService;
}