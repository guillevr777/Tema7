package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer1 {

	public static void main(String[] args) {
		
		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "user";
		
		try (Connection con = DriverManager.getConnection(conexion,usuario,password)) {
			System.out.println("Conexion establecida con exito!");
			
			String sql = "INSERT into estudiantes (id_estudiante,nombre,apellido,fecha_nacimiento,email,telefono) values (101,'Guillermo','Villanueva','2025-05-13','guillevr7@gmail.com',627189704)";
			Statement sentencia = con.createStatement();
			int rs = sentencia.executeUpdate(sql);
			
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
