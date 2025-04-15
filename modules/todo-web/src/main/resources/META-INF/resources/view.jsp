<%@ include file="/init.jsp" %>

<div class="container-fluid">
 <div class="row">
  <div class="col-md-12">
   <h2><liferay-ui:message key="todo-list" /></h2>

   <portlet:renderURL var="addTodoItemURL">
    <portlet:param name="mvcPath" value="/edit_todo.jsp" />
    <portlet:param name="redirect" value="<%= currentURL %>" />
   </portlet:renderURL>

   <portlet:renderURL var="importTodosURL">
    <portlet:param name="mvcPath" value="/import_todos.jsp" />
    <portlet:param name="redirect" value="<%= currentURL %>" />
   </portlet:renderURL>

   <aui:button-row>
    <aui:button value="add-todo-item" onClick="<%= addTodoItemURL.toString() %>" />
    <aui:button value="import-from-excel" onClick="<%= importTodosURL.toString() %>" />
   </aui:button-row>

   <liferay-ui:search-container total="<%= todoItemLocalService.getTodoItemsCount() %>">
    <liferay-ui:search-container-results
      results="<%= todoItemLocalService.getTodoItems(
			  searchContainer.getStart(), searchContainer.getEnd()) %>"
    />

    <liferay-ui:search-container-row
      className="com.example.todo.model.TodoItem"
      modelVar="todoItem"
    >
     <liferay-ui:search-container-column-text
       name="title"
       value="<%= todoItem.getTitle() %>"
     />

     <liferay-ui:search-container-column-text
       name="due-date"
       value="<%= dateFormatDate.format(todoItem.getDueDate()) %>"
     />

     <liferay-ui:search-container-column-text
       name="priority"
       value="<%= String.valueOf(todoItem.getPriority()) %>"
     />

     <liferay-ui:search-container-column-text
       name="status"
     >
      <c:choose>
       <c:when test="<%= todoItem.isCompleted() %>">
        <span class="label label-success"><liferay-ui:message key="completed" /></span>
       </c:when>
       <c:otherwise>
        <span class="label label-warning"><liferay-ui:message key="pending" /></span>
       </c:otherwise>
      </c:choose>
     </liferay-ui:search-container-column-text>

     <liferay-ui:search-container-column-jsp
       path="/todo_actions.jsp"
     />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
   </liferay-ui:search-container>
  </div>
 </div>
</div>