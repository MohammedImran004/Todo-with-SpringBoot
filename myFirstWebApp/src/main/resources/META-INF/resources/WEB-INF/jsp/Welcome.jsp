<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <!-- Include navigation -->
        <%@ include file="common/navigation.jspf" %>
        
        <!-- Welcome message -->
        <div class="text-center my-4">
            <h1>Welcome, Imran</h1>
        </div>
        
        <!-- Manage Todos Section -->
        <div class="text-center">
            <p>
                <a href="List-todos" class="btn btn-primary">
                    Manage Your Todos
                </a>
            </p>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
