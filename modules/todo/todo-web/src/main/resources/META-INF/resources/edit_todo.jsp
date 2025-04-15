<%@ include file="/init.jsp" %>

<%
    String redirect = ParamUtil.getString(request, "redirect");
    long todoItemId = ParamUtil.getLong(request, "todoItemId");
    TodoItem todoItem = null;

    if (todoItemId > 0) {
        todoItem = todoItemLocalService.getTodoItem(todoItemId);
    }
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
    <portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:actionURL name='<%= todoItem == null ? "addTodoItem" : "updateTodoItem" %>' var="editTodoItemURL" />

<aui:form action="<%= editTodoItemURL %>" method="post" name="fm">
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <aui:input name="todoItemId" type="hidden" value="<%= todoItemId %>" />

    <aui:model-context bean="<%= todoItem %>" model="<%= TodoItem.class %>" />

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <h2>
                    <c:choose>
                        <c:when test="<%= todoItem != null %>">
                            <liferay-ui:message key="edit-todo-item" />
                        </c:when>
                        <c:otherwise>
                            <liferay-ui:message key="add-todo-item" />
                        </c:otherwise>
                    </c:choose>
                </h2>

                <aui:fieldset>
                    <aui:input name="title" />
                    <aui:input name="description" type="textarea" />
                    <aui:input name="dueDate" type="date" />
                    <aui:select name="priority">
                        <aui:option value="1">Low</aui:option>
                        <aui:option value="2">Medium</aui:option>
                        <aui:option value="3">High</aui:option>
                    </aui:select>

                    <c:if test="<%= todoItem != null %>">
                        <aui:input name="completed" type="checkbox" />
                    </c:if>
                </aui:fieldset>

                <aui:button-row>
                    <aui:button type="submit" />
                    <aui:button type="cancel" onClick="<%= viewURL.toString() %>" />
                </aui:button-row>
            </div>
        </div>
    </div>
</aui:form>