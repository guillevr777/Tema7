package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utiles.Constantes;

public class Ejer8 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int id = 0;
		
		System.out.println("Dime los datos del alumno (id)");
		id = reader.nextInt();
		
		try (Connection con = DriverManager.getConnection(Constantes.conexion,Constantes.usuario,Constantes.password)) {
			int res[];
			
			String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setInt(1, id);
			sentencia.addBatch();
			
			res = sentencia.executeBatch();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar con la BBDD" + e);
		}
	}
}
