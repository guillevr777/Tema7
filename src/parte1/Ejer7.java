package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejer7 {

	public static void main(String[] args) {
		
		String nombre = null;
		String apellido = null;
		int nacimiento = 0;
		int telefono = 0;
		String gmail = null;
		
		System.out.println("Dime los datos del alumno (nombre, apellido, nacimiento, telefono, email)");
		try (Connection con = DriverManager.getConnection(Constantes.conexion,Constantes.usuario,Constantes.password)) {
			int res[];
			
			String sql = "INSERT INTO (nombre,apellido,fecha_nacimiento,email,telefono) VALUES (?,?,?,?,?)";
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setInt(3, nacimiento);
			sentencia.setString(4, gmail);
			sentencia.setInt(5, telefono);
			sentencia.addBatch();
			
			res = sentencia.executeBatch();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar con la BBDD" + e);
		}
	}
}
