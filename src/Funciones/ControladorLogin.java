package Funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorLogin {
    private clsBD_Conexion conexionBD;

    public ControladorLogin(clsBD_Conexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    public boolean validarLogin(String numeroTarjeta, String claveTarjeta) {
        // Consulta SQL para buscar en la tabla Cuentas, usando parámetros
        String query = "SET search_path TO banco; " +
                       "SELECT * FROM banco.cuentas WHERE NUMEROTARJETA = ? AND CLAVETARJETA = ?";

        try {
            // Obtener conexión
            Connection conexion = conexionBD.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(query);

            // Establecer los parámetros para la consulta
            stmt.setString(1, numeroTarjeta);
            stmt.setString(2, claveTarjeta);

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Si la consulta devuelve más de 0 registros, el login es válido
                return true; // Devuelve true si existe al menos un registro
            } else {
                System.out.println("No se encontró un registro con los datos proporcionados.");
            }
        } catch (SQLException e) {
            // Imprimir el error completo para mejor depuración
            e.printStackTrace();
        }
        return false; // Devuelve false si no se encuentra el registro o hay un error
    }
}

