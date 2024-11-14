<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>Welcome ${name}</h1>
    <div>Your Todos are</div>
    <table>
      <thead>
        <tr>
          <th>id</th>
          <th>username</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Done?</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${todos}" var="todo">
          <tr>
            <td>${todo.id}</td>
            <td>${todo.username}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.isDone}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
   
  </body>
</html>
