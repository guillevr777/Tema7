package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer3 {

	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "user";
		
		try (Connection con = DriverManager.getConnection(conexion,usuario,password)) {
			System.out.println("Conexion establecida con exito!");
			int res[];
			
			String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setInt(1, 101);
			sentencia.addBatch();
			
			sentencia.setInt(1, 40);
			sentencia.addBatch();
			
			res = sentencia.executeBatch();
			
			String sql2 = "SELECT * FROM estudiantes";
			Statement sentencia2 = con.createStatement();
			ResultSet rs2 = sentencia.executeQuery(sql2);

			while (rs2.next()) {
				System.out.println(rs2.getInt("id_estudiante") + " " + rs2.getString("nombre"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la BBDD! " + e);
		} 
	}
}
