<%@ page import="com.liferay.task.management.service.TaskLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ include file="../init.jsp" %>

<div class="container-fluid">
    <h2><liferay-ui:message key="task-list" /></h2>

    <portlet:renderURL var="addTaskURL">
        <portlet:param name="mvcRenderCommandName" value="/task/edit_task" />
        <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:renderURL>

    <aui:button-row>
        <aui:button href="<%= addTaskURL %>" value="add-task" cssClass="btn-primary" />
    </aui:button-row>

    <liferay-ui:search-container
        emptyResultsMessage="no-tasks-found"
        total="<%= TaskLocalServiceUtil.getTasksCount(scopeGroupId) %>">

        <liferay-ui:search-container-results
            results="<%= TaskLocalServiceUtil.getTasks(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
        />

        <liferay-ui:search-container-row
            className="com.liferay.task.management.model.Task"
            keyProperty="taskId"
            modelVar="task">

            <liferay-ui:search-container-column-text
                name="title"
                property="title"
            />

            <liferay-ui:search-container-column-text
                name="due-date"
                value="<%= task.getDueDate() != null ? DateUtil.getDate(task.getDueDate(), \"yyyy-MM-dd\", locale) : StringPool.BLANK %>"
            />

            <liferay-ui:search-container-column-text
                name="status">
                <span class="badge <%= task.getStatus() == 0 ? \"badge-info\" : (task.getStatus() == 1 ? \"badge-warning\" : \"badge-success\") %>">
                    <liferay-ui:message key='<%= task.getStatus() == 0 ? "open" : (task.getStatus() == 1 ? "in-progress" : "completed") %>' />
                </span>
            </liferay-ui:search-container-column-text>

            <liferay-ui:search-container-column-text
                name="priority">
                <span class="badge <%= task.getPriority() == 0 ? \"badge-secondary\" : (task.getPriority() == 1 ? \"badge-primary\" : \"badge-danger\") %>">
                    <liferay-ui:message key='<%= task.getPriority() == 0 ? "low" : (task.getPriority() == 1 ? "medium" : "high") %>' />
                </span>
            </liferay-ui:search-container-column-text>

            <liferay-ui:search-container-column-jsp
                path="/task/task_actions.jsp"
                align="right"
            />
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator markupView="lexicon" />
    </liferay-ui:search-container>
</div>