<%--
  Created by IntelliJ IDEA.
  User: Khai Nguyen
  Date: 10/13/2023
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ord.example.tdtu.InforUser" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Output</title>
</head>

<style>
  body{
    display: flex;
    justify-content:center;
    align-items: center;
  }
  table {
    border-collapse: collapse;
    border-color: green;
  }

  td {
    padding: 12px 24px;
  }
  .field{
    color: #3e003e;
    font-weight : bold;
  }
  .property{
    color: #025202;
    font-weight : bold;
  }

</style>
<body>
<%
  InforUser inf = (InforUser) request.getAttribute("info");
  System.out.println(inf);

%>
<table border="1">
  <tbody>
  <tr>
    <td class ="field">Name</td>
    <td class="property"><%= inf.getUserName() %></td>
  </tr>
  <tr>
    <td class ="field">Email</td>
    <td class="property"><%= inf.getEmail() %></td>
  </tr>
  <tr>
    <td class ="field">Birthday</td>
    <td class="property"><%= inf.getBirthday() %></td>
  </tr>
  <tr>
    <td class ="field">Birthtime</td>
    <td class="property"><%= inf.getBirthtime() %></td>
  </tr>
  <tr>
    <td class ="field">Gender</td>
    <td class="property"><%= inf.getGender() %></td>
  </tr>
  <tr>
    <td class ="field">Country</td>
    <td class="property"><%= inf.getCountry() %></td>
  </tr>
  <tr>
    <td class ="field">IDE</td>
    <td class="property"><%= Arrays.toString(inf.getSelectedValues()) %></td>
  </tr>
  <tr>
    <td class ="field">Toeic Score</td>
    <td  class="property"><%= inf.getToeic() %></td>
  </tr>
  <tr>
    <td class ="field">Message</td>
    <td  class="property"><%= inf.getMessage() %></td>
  </tr>
  </tbody>
</table>

</body>
</html>
