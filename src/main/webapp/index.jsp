<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trang Đăng Nhập</title>

</head>
<body>
<div class="container">
  <h2>Đăng Nhập</h2>
  <form action="ControllerServlet" method="post">
    <label for="username">Tài Khoản:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Mật Khẩu:</label>
    <input type="password" id="password" name="password" required>

    <input  type="submit" value="Đăng Nhập">
    <input type="hidden" name="action" value="login">
  </form>
</div>
</body>
</html>