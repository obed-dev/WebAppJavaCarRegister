package Controller;

import Model.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehiculoController {
    private Connection conn = Conexion.getConnection();

    public List<Vehiculo> listarVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM vehiculos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("placa"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("cliente_id")
                );
                vehiculos.add(vehiculo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    public Vehiculo obtenerVehiculoPorId(int id) {
        Vehiculo vehiculo = null;
        try {
            String sql = "SELECT * FROM vehiculos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vehiculo = new Vehiculo(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("placa"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("cliente_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehiculo;
    }

    public int agregarVehiculo(Vehiculo vehiculo) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO vehiculos (tipo, placa, modelo, marca, cliente_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vehiculo.getTipo());
            ps.setString(2, vehiculo.getPlaca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getMarca());
            ps.setInt(5, vehiculo.getClienteId());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            resultado = -1;
        }
        return resultado;
    }

    public int actualizarVehiculo(Vehiculo vehiculo) {
        int resultado = 0;
        try {
            String sql = "UPDATE vehiculos SET tipo = ?, placa = ?, modelo = ?, marca = ?, cliente_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vehiculo.getTipo());
            ps.setString(2, vehiculo.getPlaca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getMarca());
            ps.setInt(5, vehiculo.getClienteId());
            ps.setInt(6, vehiculo.getId());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            resultado = -1;
        }
        return resultado;
    }

    public int eliminarVehiculo(int id) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM vehiculos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            resultado = -1;
        }
        return resultado;
    }
}
