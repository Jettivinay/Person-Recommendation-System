<!DOCTYPE html>
<html>
<head>
    <title>Dating App</title>
</head>
<body>
    <h1>Welcome to the Dating App</h1>
    <form action="/recommendations" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <label for="interests">Interests (comma-separated):</label>
        <input type="text" id="interests" name="interests" required><br><br>

        <button type="submit">Get Recommendations</button>
    </form>
</body>
</html>