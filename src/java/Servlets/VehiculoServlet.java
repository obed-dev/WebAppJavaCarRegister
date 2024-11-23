package Servlets;

import Controller.VehiculoController;
import Model.Vehiculo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/VehiculoServlet")
public class VehiculoServlet extends HttpServlet {

    private VehiculoController vehiculoController = new VehiculoController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("listar".equals(action)) {
            listarVehiculos(request, response);
        } else if ("agregar".equals(action)) {
            request.getRequestDispatcher("agregarVehiculo.jsp").forward(request, response);
        } else if ("editar".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Vehiculo vehiculo = vehiculoController.obtenerVehiculoPorId(id);
                if (vehiculo != null) {
                    request.setAttribute("vehiculo", vehiculo);
                    request.getRequestDispatcher("editarVehiculo.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Vehículo no encontrado.");
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al cargar el vehículo.");
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
        } else if ("eliminar".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                int resultado = vehiculoController.eliminarVehiculo(id);
                if (resultado > 0) {
                    response.sendRedirect("VehiculoServlet?action=listar");
                } else {
                    request.setAttribute("error", "No se pudo eliminar el vehículo.");
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al eliminar el vehículo.");
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("guardar".equals(action)) {
            try {
                String tipo = request.getParameter("tipo");
                String placa = request.getParameter("placa");
                String modelo = request.getParameter("modelo");
                String marca = request.getParameter("marca");
                int clienteId = Integer.parseInt(request.getParameter("cliente_id"));

                Vehiculo vehiculo = new Vehiculo(tipo, placa, modelo, marca, clienteId);
                int resultado = vehiculoController.agregarVehiculo(vehiculo);

                if (resultado > 0) {
                    response.sendRedirect("VehiculoServlet?action=listar");
                } else {
                    request.setAttribute("error", "No se pudo agregar el vehículo.");
                    request.getRequestDispatcher("agregarVehiculo.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al procesar la solicitud.");
                request.getRequestDispatcher("agregarVehiculo.jsp").forward(request, response);
            }
        } else if ("actualizar".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String tipo = request.getParameter("tipo");
                String placa = request.getParameter("placa");
                String modelo = request.getParameter("modelo");
                String marca = request.getParameter("marca");
                int clienteId = Integer.parseInt(request.getParameter("cliente_id"));

                Vehiculo vehiculo = new Vehiculo(id, tipo, placa, modelo, marca, clienteId);
                int resultado = vehiculoController.actualizarVehiculo(vehiculo);

                if (resultado > 0) {
                    response.sendRedirect("VehiculoServlet?action=listar");
                } else {
                    request.setAttribute("error", "No se pudo actualizar el vehículo.");
                    request.getRequestDispatcher("editarVehiculo.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al procesar la solicitud.");
                request.getRequestDispatcher("editarVehiculo.jsp").forward(request, response);
            }
        }
    }

    private void listarVehiculos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Vehiculo> vehiculos = vehiculoController.listarVehiculos();
            request.setAttribute("vehiculos", vehiculos);
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al listar los vehículos.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
