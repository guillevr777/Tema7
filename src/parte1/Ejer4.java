package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer4 {

	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "user";
		
		try (Connection con = DriverManager.getConnection(conexion,usuario,password)) {
			System.out.println("Conexion establecida con exito!");
			int res[];
			
			String sql = "INSERT INTO cursos VALUES (?,?,?,?)";
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setInt(1, 100);
			sentencia.setString(2, "Historia 1º");
			sentencia.setString(3, "Clase de historia");
			sentencia.setString(4, "2022");
			sentencia.addBatch();

			sentencia.setInt(1, 101);
			sentencia.setString(2, "Biología 1º");
			sentencia.setString(3, "Clase de biologia");
			sentencia.setString(4, "2005");
			sentencia.addBatch();
			
			sentencia.setInt(1, 102);
			sentencia.setString(2, "Educación Física 1º");
			sentencia.setString(3, "Clase de fisica");
			sentencia.setString(4, "2025");
			sentencia.addBatch();
			
			sentencia.setInt(1, 103);
			sentencia.setString(2, "Música 1º");
			sentencia.setString(3, "Clase de musica");
			sentencia.setString(4, "2001");
			sentencia.addBatch();
			
			sentencia.setInt(1, 104);
			sentencia.setString(2, "Tecnología 1º");
			sentencia.setString(3, "Clase de tecnologia");
			sentencia.setString(4, "1999");
			sentencia.addBatch();
			
			res = sentencia.executeBatch();
			
			String sql2 = "SELECT * FROM cursos";
			Statement sentencia2 = con.createStatement();
			ResultSet rs2 = sentencia.executeQuery(sql2);

			while (rs2.next()) {
				System.out.println(rs2.getInt("id_curso") + " " + rs2.getString("nombre") + " " + rs2.getString("descripcion") + " " + rs2.getString("año_escolar"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la BBDD! " + e);
		} 
	}
}
