package Controller;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private Connection conn = Conexion.getConnection();

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("email")
                );
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente obtenerClientePorId(int id) {
        Cliente cliente = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clientes WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public int agregarCliente(Cliente cliente) {
        int resultado = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO clientes (nombre, cedula, telefono, email) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCedula());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            resultado = -1;
        }
        return resultado;
    }

    public int eliminarCliente(int id) {
        int resultado = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM clientes WHERE id = ?");
            ps.setInt(1, id);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            resultado = -1;
        }
        return resultado;
    }

    public int actualizarCliente(Cliente cliente) {
        int resultado = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE clientes SET nombre = ?, cedula = ?, telefono = ?, email = ? WHERE id = ?"
            );
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCedula());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setInt(5, cliente.getId());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            resultado = -1;
        }
        return resultado;
    }
}
