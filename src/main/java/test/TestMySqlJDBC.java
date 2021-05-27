package test;

import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author Omar Lopez
 */
public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT * FROM persona";
            ResultSet  resultado = instruccion.executeQuery(sql);
            while (resultado.next()){
                System.out.print("Id Persona: "+ resultado.getInt("idPersona"));
                System.out.print(" Nonbre: "+ resultado.getString("nombre"));
                System.out.print(" Apellido : "+ resultado.getString("apellido"));
                System.out.print(" Email: "+ resultado.getString("email"));
                System.out.print(" Telefono: "+ resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
       
    }
}
