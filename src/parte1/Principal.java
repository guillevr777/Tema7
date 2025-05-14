package parte1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "user";
		
		try (Connection con = DriverManager.getConnection(conexion,usuario,password)) {
			System.out.println("Conexion establecida con exito!");
			
			String sql = "SELECT * FROM estudiantes";
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("id_estudiante") + " " + rs.getString("nombre"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al establecer la BBDD! " + e);
		}
	}
}
