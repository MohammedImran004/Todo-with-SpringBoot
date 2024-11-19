<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add Todo</title>
    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="container mt-5">
      <h1 class="mb-4">Add Todo</h1>
      <form:form method="post" modelAttribute="todo" class="needs-validation">
        <div class="mb-3">
          <label for="description" class="form-label">Description:</label>
          <form:input
            path="description"
            id="description"
            class="form-control"
          />
          <form:errors path="description" cssClass="text-danger" />
          <form:hidden path="id" />
          <form:hidden path="isDone" />
          <input type="submit" class="btn btn-success">
        </div>
        <div>
        </div>
      </form:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
