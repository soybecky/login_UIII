package com.Platinum.Login;

import org.testng.annotations.Test;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

@Test
public class TestSqlSelenium {

	// Definir constantes para: driver JDBC, URL y credenciales de la BBDD
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost/bdlogin"; 
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Registrar el JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Abrir la Conexión
			System.out.println("Conectando a la BBDD...");
			conn = DriverManager.getConnection(DB_URL,"root","");
			// Ejecutar un QUERY
			System.out.println("Creando instrucción -statement-...");
			stmt = conn.createStatement();
			String sql = "";
			sql = "SELECT Rut, Nombre, Apellido, Telefono FROM bdlogin.persona";
			ResultSet rs = stmt.executeQuery(sql);			
			// rs.next() = "true" si aun hay mas registros, si no hay mas = "false"
			while(rs.next()) { 
				// Obtener resultado (fila) por nombre de columnas
				String Rut = rs.getString("Rut");
				String Nombre = rs.getString("Nombre");
				String Apellido = rs.getString("Apellido");
				String Telefono = rs.getString("Telefono");
				// Imprimir resultado (la fila )
				System.out.print("Rut: " + Rut);
				System.out.print(", Nombre: " + Nombre);
				System.out.print(", Apellido: " + Apellido);
				System.out.println(", Telefono: " + Telefono);
			}}
		// Limpiar ambiente para el cierre
		//rs.close();
		//stmt.close();
		//conn.close();
			 
		// Manejar errores con el JDBC
		catch(SQLException se) { se.printStackTrace(); }			
			
		// Manejar errores con la Class.forName
		catch(Exception e) { e.printStackTrace(); }
			
		// Cerrar Statement y Connection
		finally {
			try { if(stmt != null) stmt.close(); }
			catch(SQLException se2) { }	// AH, ya no se puede hacer más nada
			try { if(conn != null) conn.close(); }
			catch(SQLException se) { se.printStackTrace(); }
		} // end del finally try
		 // end del 1er try
		System.out.println("Listo, a su orden");
	} // end del main

}
