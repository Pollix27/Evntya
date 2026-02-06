package com.mycompany.DAO;

/**
 *
 * Ya solo hace falta conectar el LoginDAO con la base de datos o del SQL
 * 
 * @author pollix
 */
public class LoginDAO {
    public boolean validarUsuario(String matricula){
        
        String consulta = "SELECT * FROM ... "/*Ruta para la base de datos se conecte pueda comparar si es una matricula correcta*/;
    
        try (Connection conectar = DriverManager.getConnection("..."/*direccion con la base de datos del SQL, "cuenta", "contraseña"*/);
            PreparedStatement stmt = conectar.prepareStatement(consulta)) {
        
            stmt.setString(1, matricula);
        
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }    
    } 
}
