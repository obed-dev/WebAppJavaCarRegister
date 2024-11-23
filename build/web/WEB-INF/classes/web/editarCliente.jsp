<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Cliente</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center mb-4">Editar Cliente</h1>
            <form action="ClienteServlet" method="POST">
                <input type="hidden" name="action" value="actualizar">
                <input type="hidden" name="id" value="${cliente.id}">
                
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" value="${cliente.nombre}" required>
                </div>
                
                <div class="mb-3">
                    <label for="cedula" class="form-label">Cédula:</label>
                    <input type="text" id="cedula" name="cedula" class="form-control" value="${cliente.cedula}" required>
                </div>
                
                <div class="mb-3">
                    <label for="telefono" class="form-label">Teléfono:</label>
                    <input type="text" id="telefono" name="telefono" class="form-control" value="${cliente.telefono}" required>
                </div>
                
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" value="${cliente.email}" required>
                </div>
                
                <button type="submit" class="btn btn-primary">Actualizar Cliente</button>
                <a href="ClienteServlet?action=listar" class="btn btn-secondary">Cancelar</a>
            </form>
        </div>
        <!-- Bootstrap JS Bundle -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
