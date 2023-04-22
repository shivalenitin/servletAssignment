<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Ebookshop Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Book Title</td>
     <td><input type="text" name="book_title" /></td>
    </tr>
    <tr>
     <td>Book Author</td>
     <td><input type="text" name="book_author" /></td>
    </tr>
    <tr>
     <td>Book Price</td>
     <td><input type="text" name="book_price" /></td>
    </tr>
    <tr>
     <td>Book Quantity</td>
     <td><input type="number" name="quantity" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>