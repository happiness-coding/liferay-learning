package com.liferay.task.management.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.task.management.web.constants.TaskManagementPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/task/view.jsp",
        "javax.portlet.name=" + TaskManagementPortletKeys.TASK_MANAGEMENT,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class TaskManagementPortlet extends MVCPortlet {
}