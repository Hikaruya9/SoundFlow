/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
public class ReleaseDAO {
    
    public void add(String title) {
        String sql = "INSERT INTO artist_release(title,release_date,track_number,release_length,image_path,artist_id) VALUES(?,?,?,?,?,?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, title);
        }catch(SQLException e){
            
        }
    }
    
}