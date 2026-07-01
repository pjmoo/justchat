<%-- chat.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Chat</title>
</head>
<body>
<section>
  <form method="post">
    <input type="text" name="message" /><br>
    <select name="model">
      <%--                <option value="엄청난 모델">엄청난 모델</option>--%>
      <option value="gemini-3.1-flash-lite">잼나이</option>
    </select>
    <input type="submit" value="전송" />
  </form>
</section>
<section>
  <ul>
    <c:forEach var="c" items="${chat}">
      <li><c:out value="${c}" /></li>
    </c:forEach>
  </ul>
</section>
</body>
</html>