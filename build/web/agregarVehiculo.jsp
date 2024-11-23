<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Vehículo</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center mb-4">Agregar Vehículo</h1>
            <form action="VehiculoServlet" method="POST">
                <input type="hidden" name="action" value="guardar">
                
                <div class="mb-3">
                    <label for="tipo" class="form-label">Tipo:</label>
                    <input type="text" id="tipo" name="tipo" class="form-control" placeholder="Ingrese el tipo de vehículo" required>
                </div>
                
                <div class="mb-3">
                    <label for="placa" class="form-label">Placa:</label>
                    <input type="text" id="placa" name="placa" class="form-control" placeholder="Ingrese la placa" required>
                </div>
                
                <div class="mb-3">
                    <label for="modelo" class="form-label">Modelo:</label>
                    <input type="text" id="modelo" name="modelo" class="form-control" placeholder="Ingrese el modelo" required>
                </div>
                
                <div class="mb-3">
                    <label for="marca" class="form-label">Marca:</label>
                    <input type="text" id="marca" name="marca" class="form-control" placeholder="Ingrese la marca" required>
                </div>
                
                <div class="mb-3">
                    <label for="cliente_id" class="form-label">Cliente ID:</label>
                    <input type="number" id="cliente_id" name="cliente_id" class="form-control" placeholder="Ingrese el ID del cliente" required>
                </div>
                
                <button type="submit" class="btn btn-success">Guardar Vehículo</button>
                <a href="VehiculoServlet?action=listar" class="btn btn-secondary">Cancelar</a>
            </form>
        </div>
        <!-- Bootstrap JS Bundle -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
