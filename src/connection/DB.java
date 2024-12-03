/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Aluno
 */
public class DB {
    
    private static final String URL = "jdcb://mysql/localhost:3306/soundflow_project";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            System.out.println("Falha na tentativa de conexão ao servidor!\n"+e.getMessage());
        }
        return connection;
    }
}