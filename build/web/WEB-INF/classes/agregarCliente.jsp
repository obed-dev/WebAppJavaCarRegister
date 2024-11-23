<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Cliente</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center mb-4">Agregar Cliente</h1>
            <form action="ClienteServlet" method="POST">
                <input type="hidden" name="action" value="guardar">
                
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Ingrese el nombre" required>
                </div>
                
                <div class="mb-3">
                    <label for="cedula" class="form-label">Cédula:</label>
                    <input type="text" id="cedula" name="cedula" class="form-control" placeholder="Ingrese la cédula" required>
                </div>
                
                <div class="mb-3">
                    <label for="telefono" class="form-label">Teléfono:</label>
                    <input type="text" id="telefono" name="telefono" class="form-control" placeholder="Ingrese el teléfono" required>
                </div>
                
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Ingrese el email" required>
                </div>
                
                <button type="submit" class="btn btn-success">Guardar Cliente</button>
                <a href="ClienteServlet?action=listar" class="btn btn-secondary">Cancelar</a>
            </form>
        </div>
        <!-- Bootstrap JS Bundle -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
