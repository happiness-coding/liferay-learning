<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ include file="/init.jsp" %>

<%
  ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
  TodoItem todoItem = (TodoItem)row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
  <portlet:renderURL var="editURL">
    <portlet:param name="mvcPath" value="/edit_todo.jsp" />
    <portlet:param name="redirect" value="<%= currentURL %>" />
    <portlet:param name="todoItemId" value="<%= String.valueOf(todoItem.getTodoItemId()) %>" />
  </portlet:renderURL>

  <liferay-ui:icon
          message="edit"
          url="<%= editURL %>"
  />

  <portlet:actionURL name="toggleTodoItemStatus" var="toggleStatusURL">
    <portlet:param name="redirect" value="<%= currentURL %>" />
    <portlet:param name="todoItemId" value="<%= String.valueOf(todoItem.getTodoItemId()) %>" />
  </portlet:actionURL>

  <liferay-ui:icon
          message='<%= todoItem.isCompleted() ? "mark-as-pending" : "mark-as-completed" %>'
          url="<%= toggleStatusURL %>"
  />

  <portlet:actionURL name="deleteTodoItem" var="deleteURL">
    <portlet:param name="redirect" value="<%= currentURL %>" />
    <portlet:param name="todoItemId" value="<%= String.valueOf(todoItem.getTodoItemId()) %>" />
  </portlet:actionURL>

  <liferay-ui:icon-delete
          url="<%= deleteURL %>"
  />
</liferay-ui:icon-menu>
