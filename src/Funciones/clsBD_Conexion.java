
package Funciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class clsBD_Conexion {
    private Connection connection;

    // Método para obtener el estado de la conexión
    public boolean getEstado() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConexion() {
        return connection;
    }

    public void conectarBD() throws SQLException {
        // Aquí pones la URL, usuario y contraseña según tu base de datos
        String url = "jdbc:postgresql://localhost:5432/Banco";
        String usuario = "postgres";
        String contrasena = "Y43l4gu5t1n";
        connection = DriverManager.getConnection(url, usuario, contrasena);
    }

    public void desconectarBD() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


