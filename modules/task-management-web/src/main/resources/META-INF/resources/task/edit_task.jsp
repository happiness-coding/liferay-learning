<%@ page import="com.liferay.task.management.service.TaskLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.task.management.model.Task" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="../init.jsp" %>

    <%
    Task task = null;
    long taskId = ParamUtil.getLong(request, "taskId");

    if (taskId > 0) {
        task = TaskLocalServiceUtil.getTask(taskId);
    }

    String title = BeanPropertiesUtil.getString(task, "title", "");
    String description = BeanPropertiesUtil.getString(task, "description", "");
    Date dueDate = (Date) BeanPropertiesUtil.getObject(task, "dueDate", Date.class);
    int status = BeanPropertiesUtil.getInteger(task, "status", 0);
    int priority = BeanPropertiesUtil.getInteger(task, "priority", 0);

    String redirect = ParamUtil.getString(request, "redirect");
    portletDisplay.setShowBackIcon(true);
    portletDisplay.setURLBack(redirect);

    String headerTitle = (task == null) ? "add-task" : "edit-task";
    %>

    <portlet:actionURL name='<%= (task == null) ? "/task/add_task" : "/task/update_task" %>' var="taskActionURL" />

    <div class="container-fluid">
        <h2><liferay-ui:message key="<%= headerTitle %>" /></h2>

        <aui:form action="<%= taskActionURL %>" method="post" name="fm">
            <aui:input name="<%= Constants.CMD %>" type="hidden" value='<%= (task == null) ? Constants.ADD : Constants.UPDATE %>' />
            <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
            <aui:input name="taskId" type="hidden" value="<%= taskId %>" />

            <aui:model-context bean="<%= task %>" model="<%= Task.class %>" />

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset>
                    <aui:input name="title" label="title">
                        <aui:validator name="required" />
                    </aui:input>

                    <aui:input name="description" type="textarea" label="description" />

                    <aui:input name="dueDate" type="date" label="due-date"
                               value='<%= dueDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(dueDate) : "" %>' />

                    <aui:select name="status" label="status">
                        <aui:option value="0" selected='<%= status == 0 %>'>
                            <liferay-ui:message key="open" />
                        </aui:option>
                        <aui:option value="1" selected='<%= status == 1 %>'>
                            <liferay-ui:message key="in-progress" />
                        </aui:option>
                        <aui:option value="2" selected='<%= status == 2 %>'>
                            <liferay-ui:message key="completed" />
                        </aui:option>
                    </aui:select>

                    <aui:select name="priority" label="priority">
                        <aui:option value="0" selected='<%= priority == 0 %>'>
                            <liferay-ui:message key="low" />
                        </aui:option>
                        <aui:option value="1" selected='<%= priority == 1 %>'>
                            <liferay-ui:message key="medium" />
                        </aui:option>
                        <aui:option value="2" selected='<%= priority == 2 %>'>
                            <liferay-ui:message key="high" />
                        </aui:option>
                    </aui:select>
                </aui:fieldset>
            </aui:fieldset-group>

            <aui:button-row>
                <aui:button type="submit" cssClass="btn-primary" />
                <aui:button type="cancel" href="<%= redirect %>" />
            </aui:button-row>
        </aui:form>
    </div>