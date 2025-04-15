<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.todo.model.TodoItem" %>
<%@ page import="com.example.todo.service.TodoItemLocalService" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
    TodoItemLocalService todoItemLocalService = (TodoItemLocalService)request.getAttribute("todoItemLocalService");
    String currentURL = themeDisplay.getURLCurrent();
    java.text.DateFormat dateFormatDate = new SimpleDateFormat("MM/dd/yyyy");
%>