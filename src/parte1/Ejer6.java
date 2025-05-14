package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utiles.Constantes;

public class Ejer6 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.conexion,Constantes.usuario,Constantes.password)) {
			System.out.println("Conexion establecida con exito!");
			int res[];
			
			String sql = "INSERT INTO calificaciones (id_estudiante,nota) VALUES (?,?)";
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setInt(1, 100);
			sentencia.setDouble(2, 2);
			sentencia.addBatch();
			
			res = sentencia.executeBatch();
			
			String sql2 = "SELECT * FROM calificaciones";
			Statement sentencia2 = con.createStatement();
			ResultSet rs2 = sentencia.executeQuery(sql2);

			while (rs2.next()) {
				System.out.println(rs2.getInt("id_estudiante") + " " + rs2.getDouble("nota"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la BBDD! " + e);
		} 
	}
}
