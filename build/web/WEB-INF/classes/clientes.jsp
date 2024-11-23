<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cliente"%>
<%@page import="Model.Vehiculo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gestión de Clientes y Vehículos</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center mb-4">Gestión de Clientes y Vehículos</h1>
            
            <!-- Tabla de Clientes -->
            <h2 class="mb-3">Clientes</h2>
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Cédula</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                        if (clientes != null && !clientes.isEmpty()) {
                            for (Cliente cliente : clientes) {
                    %>
                    <tr>
                        <td><%= cliente.getId() %></td>
                        <td><%= cliente.getNombre() %></td>
                        <td><%= cliente.getCedula() %></td>
                        <td><%= cliente.getTelefono() %></td>
                        <td><%= cliente.getEmail() %></td>
                        <td>
                            <a href="ClienteServlet?action=editar&id=<%= cliente.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                            <a href="ClienteServlet?action=eliminar&id=<%= cliente.getId() %>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                    <% 
                            }
                        } else { 
                    %>
                    <tr>
                        <td colspan="6" class="text-center">No hay clientes disponibles.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <div class="mb-4">
                <a href="ClienteServlet?action=agregar" class="btn btn-success">Agregar Cliente</a>
                <a href="ClienteServlet?action=listar" class="btn btn-secondary">Actualizar Tabla</a>
            </div>

            <!-- Tabla de Vehículos -->
            <h2 class="mb-3">Vehículos</h2>
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th>Placa</th>
                        <th>Modelo</th>
                        <th>Marca</th>
                        <th>Cliente ID</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Vehiculo> vehiculos = (List<Vehiculo>) request.getAttribute("vehiculos");
                        if (vehiculos != null && !vehiculos.isEmpty()) {
                            for (Vehiculo vehiculo : vehiculos) {
                    %>
                    <tr>
                        <td><%= vehiculo.getId() %></td>
                        <td><%= vehiculo.getTipo() %></td>
                        <td><%= vehiculo.getPlaca() %></td>
                        <td><%= vehiculo.getModelo() %></td>
                        <td><%= vehiculo.getMarca() %></td>
                        <td><%= vehiculo.getClienteId() %></td>
                        <td>
                            <a href="VehiculoServlet?action=editar&id=<%= vehiculo.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                            <a href="VehiculoServlet?action=eliminar&id=<%= vehiculo.getId() %>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                    <% 
                            }
                        } else { 
                    %>
                    <tr>
                        <td colspan="7" class="text-center">No hay vehículos disponibles.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <div>
                <a href="VehiculoServlet?action=agregar" class="btn btn-success">Agregar Vehículo</a>
                <a href="VehiculoServlet?action=listar" class="btn btn-secondary">Actualizar Tabla</a>
            </div>
        </div>

        <!-- Bootstrap JS Bundle -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
