package Servlets;

import Controller.ClienteController;
import Model.Cliente;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    private ClienteController clienteController = new ClienteController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("listar".equals(action)) {
            List<Cliente> clientes = clienteController.listarClientes();
            request.setAttribute("clientes", clientes);
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }else if ("agregar".equals(action)) {
            request.getRequestDispatcher("agregarCliente.jsp").forward(request, response);
        } else if ("editar".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Cliente cliente = clienteController.obtenerClientePorId(id);
                if (cliente != null) {
                    request.setAttribute("cliente", cliente);
                    request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Cliente no encontrado.");
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al cargar el cliente.");
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
        } else if ("eliminar".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                int resultado = clienteController.eliminarCliente(id);
                if (resultado > 0) {
                    response.sendRedirect("ClienteServlet?action=listar");
                } else {
                    request.setAttribute("error", "No se pudo eliminar el cliente.");
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al eliminar el cliente.");
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("guardar".equals(action)) {
            String nombre = request.getParameter("nombre");
            String cedula = request.getParameter("cedula");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            Cliente cliente = new Cliente(0, nombre, cedula, telefono, email);
            clienteController.agregarCliente(cliente);
            response.sendRedirect("ClienteServlet?action=listar");
        } else if ("actualizar".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String cedula = request.getParameter("cedula");
                String telefono = request.getParameter("telefono");
                String email = request.getParameter("email");

                Cliente cliente = new Cliente(id, nombre, cedula, telefono, email);
                int resultado = clienteController.actualizarCliente(cliente);

                if (resultado > 0) {
                    response.sendRedirect("ClienteServlet?action=listar");
                } else {
                    request.setAttribute("error", "No se pudo actualizar el cliente.");
                    request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Error al procesar la solicitud.");
                request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
            }
        }
    }
}
