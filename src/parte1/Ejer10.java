package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utiles.Constantes;

public class Ejer10 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.conexion, Constantes.usuario, Constantes.password)) {
		    String sql = "SELECT E.nombre, E.fecha_nacimiento FROM estudiantes E " +
		                 "INNER JOIN matriculas M ON E.id_estudiante = M.id_estudiante " +
		                 "INNER JOIN cursos C ON M.id_curso = C.id_curso " +
		                 "WHERE C.año_escolar = ?";
		    
		    PreparedStatement sentencia = con.prepareStatement(sql);
		    sentencia.setInt(1, 2024);

		    ResultSet rs = sentencia.executeQuery();

		    while (rs.next()) {
				System.out.println(rs.getString("nombre") + " " + rs.getString("fecha_nacimiento"));
			}

		} catch (SQLException e) {
		    System.out.println("Error al conectar con la BBDD: " + e.getMessage());
		}

	}
}
