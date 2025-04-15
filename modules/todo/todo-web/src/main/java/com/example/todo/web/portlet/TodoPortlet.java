package com.example.todo.web.portlet;

import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoItemLocalService;
import com.example.todo.web.constants.TodoPortletKeys;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
  immediate = true,
  property = {
    "com.liferay.portlet.display-category=category.sample",
    "com.liferay.portlet.header-portlet-css=/css/main.css",
    "com.liferay.portlet.instanceable=true",
    "javax.portlet.init-param.template-path=/",
    "javax.portlet.init-param.view-template=/view.jsp",
    "javax.portlet.name=" + TodoPortletKeys.TODO,
    "javax.portlet.resource-bundle=content.Language",
    "javax.portlet.security-role-ref=power-user,user"
  },
  service = Portlet.class
)
public class TodoPortlet extends MVCPortlet {

 @Override
 public void render(RenderRequest renderRequest, RenderResponse renderResponse)
   throws IOException, PortletException {
  renderRequest.setAttribute("todoItemLocalService", _todoItemLocalService);
  super.render(renderRequest, renderResponse);
 }

 @Reference
 private TodoItemLocalService _todoItemLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

 @Reference
 private Portal _portal;

 public void addTodoItem(ActionRequest actionRequest, ActionResponse actionResponse)
   throws Exception {

  long groupId = _portal.getScopeGroupId(actionRequest);
  long userId = _portal.getUserId(actionRequest);

  String title = ParamUtil.getString(actionRequest, "title");
  String description = ParamUtil.getString(actionRequest, "description");
  Date dueDate = ParamUtil.getDate(actionRequest, "dueDate",
    new SimpleDateFormat("yyyy-MM-dd"));
  int priority = ParamUtil.getInteger(actionRequest, "priority", 0);

  ServiceContext serviceContext = ServiceContextFactory.getInstance(
    TodoItem.class.getName(), actionRequest);

	 TodoItem todoItem = _todoItemLocalService.createTodoItem(
			 _counterLocalService.increment(TodoItem.class.getName()));
	 todoItem.setUserId(userId);
	 todoItem.setGroupId(groupId);
	 todoItem.setTitle(title);
	 todoItem.setDescription(description);
	 todoItem.setDueDate(dueDate);
	 todoItem.setPriority(priority);
	 todoItem.setCompleted(false);

// Then pass the single object to addTodoItem
	 _todoItemLocalService.addTodoItem(todoItem); }

 public void updateTodoItem(ActionRequest actionRequest, ActionResponse actionResponse)
   throws Exception {

  long todoItemId = ParamUtil.getLong(actionRequest, "todoItemId");
  String title = ParamUtil.getString(actionRequest, "title");
  String description = ParamUtil.getString(actionRequest, "description");
  Date dueDate = ParamUtil.getDate(actionRequest, "dueDate",
    new SimpleDateFormat("yyyy-MM-dd"));
  int priority = ParamUtil.getInteger(actionRequest, "priority", 0);
  boolean completed = ParamUtil.getBoolean(actionRequest, "completed", false);

  TodoItem todoItem = _todoItemLocalService.getTodoItem(todoItemId);

  // Update the todoItem object properties
  todoItem.setTitle(title);
  todoItem.setDescription(description);
  todoItem.setDueDate(dueDate);
  todoItem.setPriority(priority);
  todoItem.setCompleted(completed);

  // Save the updated todoItem
  _todoItemLocalService.updateTodoItem(todoItem);
 }

 public void deleteTodoItem(ActionRequest actionRequest, ActionResponse actionResponse)
   throws Exception {

  long todoItemId = ParamUtil.getLong(actionRequest, "todoItemId");

  _todoItemLocalService.deleteTodoItem(todoItemId);
 }

 public void toggleTodoItemStatus(ActionRequest actionRequest, ActionResponse actionResponse)
   throws Exception {

  long todoItemId = ParamUtil.getLong(actionRequest, "todoItemId");

  TodoItem todoItem = _todoItemLocalService.getTodoItem(todoItemId);
  todoItem.setCompleted(!todoItem.isCompleted());

  _todoItemLocalService.updateTodoItem(todoItem);
 }
}