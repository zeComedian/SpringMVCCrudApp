<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>
<body>
<h1>Users List</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>phone number</th>
    </tr>
    <#list users as user>
    <tr>
        <td><a href="/userById/${user.id}">${user.id}</a></td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.phoneNumber}</td>
        <td><a href="/delete/${user.id}">DELETE</a></td>
    </tr>
    </#list>
</table>
<a href="/addUser">Add new User</a>

</body>
</html>