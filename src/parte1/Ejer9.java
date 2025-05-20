package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utiles.Constantes;

public class Ejer9 {

	public static void main(String[] args) {
		
		try (Connection con = DriverManager.getConnection(Constantes.conexion,Constantes.usuario,Constantes.password)) {
			int res[];
			
			String sql = "SELECT * FROM estudiantes";
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("nombre") + " " + rs.getString("fecha_nacimiento"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al conectar con la BBDD" + e);
		}
	}
}
