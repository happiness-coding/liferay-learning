<%@ page import="com.liferay.task.management.model.Task" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ include file="../init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Task task = (Task)row.getObject();
long taskId = task.getTaskId();
String currentURL = themeDisplay.getURLCurrent();
%>

<liferay-ui:icon-menu direction="left-side" markupView="lexicon">
    <portlet:renderURL var="editURL">
        <portlet:param name="mvcRenderCommandName" value="/task/edit_task" />
        <portlet:param name="redirect" value="<%= currentURL %>" />
        <portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
    </portlet:renderURL>

    <liferay-ui:icon
        message="edit"
        url="<%= editURL %>"
    />

    <portlet:actionURL name="/task/delete_task" var="deleteURL">
        <portlet:param name="redirect" value="<%= currentURL %>" />
        <portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
    </portlet:actionURL>

    <liferay-ui:icon
        message="delete"
        url="<%= deleteURL %>"
    />
</liferay-ui:icon-menu>