<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
    <div class="container mt-5">
      <h1 class="mb-4">Add Todo</h1>
      <form:form method="post" modelAttribute="todo" class="needs-validation">
        <div class="mb-3">
          <fieldset>
            <label for="description" class="form-label">Description:</label>
            <form:input
              path="description"
              id="description"
              class="form-control"
            />
            <form:errors path="description" cssClass="text-danger" />
          </fieldset>
          <fieldset>
            <label for="targetDate" class="form-label">Date:</label>
            <form:input
              path="targetDate"
              id="targetDate"
              class="form-control targetDate"
            />
            <form:errors path="targetDate" cssClass="text-danger" />
          </fieldset>
          <form:hidden path="id" />
          <form:hidden path="isDone" />
          <input type="submit" class="btn btn-success" />
        </div>
      </form:form>
    </div>
    <script type="text/javascript">
      $(document).ready(function () {
        $('#targetDate').datepicker({
          format: 'yyyy/mm/dd',
        });
      });
    </script>
    <%@ include file="common/footer.jspf" %>