package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD {

	public static void main(String[]args) {
		
try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:postgresq://localhost:5434/Soldado","postgres", "16012004");
			System.out.println("Paso 1 conexion  completo");
			
		
			Statement miStatement= miConexion.createStatement(); 
			System.out.println("Paso 2 objeto para hacer consultas completo"); 
                        
                        Scanner teclado = new Scanner(System.in);
                        String consulta;
                        consulta = teclado.next();
                        switch (consulta){
                            case "SELECT":
                                String SelectSQL = "SELECT * FROM alumnos";
                                ResultSet miResultSet = miStatement.executeQuery("SelectSQL");
                                while(miResultSet.next()) {
				   
				System.out.println("id    : "+ miResultSet.getInt("id_plato")+
						           " Precio  : "+ miResultSet.getString("precio_plato")+
						           " Nombre : "+ miResultSet.getString("nombre_plato"));     
			
			}
                                break;
                            case "INSERT":
                                String InsertSQL = "INSERT INTO alumnos(nombre_alu, edad_alu, semestre_alu, clave_c1) VALUES('elpepe', '20', '7', '19')";
                                ResultSet miResultSet1 = miStatement.executeQuery("InsertSQL");
                                break;
                            case "UPDATE":
                                String UpdateSQL = "UPDATE alumnos SET \"semestre_alu\" = \"NULL\" WHERE \"nombre\" = \"NULL\" ";
                                ResultSet miResultSet2 = miStatement.executeQuery("UpdateSQL");
                                break;
                            case "DELETE":
                                String DeleteSQL = "Delete * FROM alumnos";
                                ResultSet miResultSet3 = miStatement.executeQuery("DeleteSQL");        
                                break;
                        }

			
		
			
			
		}catch(Exception e ) {
			System.out.println("Error");
			System.out.println(e.getMessage()); 
		}
	}
}
