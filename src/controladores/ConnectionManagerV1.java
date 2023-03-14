package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionManagerV1 {

	private static Connection conexion = null;
	
	
	public static Connection getConexion () throws SQLException {
		// Si es la primera vez que accedemos a la conexi�n, debemos instanciarla
		if (conexion == null) {
			conectar();
		}
		// Compruebo si la conexi�n sigue estando activa
		while (!conexion.isValid(5)) {
			conectar();
		}
		
		return conexion;
	}
	
	
	
	private static void conectar () throws SQLException {
		String driver = JDBCPropiedades.getProperty("JDBC_DRIVER_CLASS");
		String user = JDBCPropiedades.getProperty("JDBC_USER");
		String password = JDBCPropiedades.getProperty("JDBC_PASSWORD");
		String host = JDBCPropiedades.getProperty("JDBC_HOST");
		String schema = JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME");
		String properties = JDBCPropiedades.getProperty("JDBC_PROPERTIES");

		
		try {
			Class.forName(driver);
		   
			conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);			   
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
	}
}
