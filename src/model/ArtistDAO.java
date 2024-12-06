/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connection.DB;
import data.Artist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Aluno
 */
public class ArtistDAO {
    
    public void add(int id, String name, String about, String genre, String imagePath){
        String sql = "INSERT INTO artist(name,genre,about,image_path) VALUES(?,?,?,?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, name);
            stmt.setString(i++, about);
            stmt.setString(i++, genre);
            stmt.setString(i++, imagePath);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Optional<Artist> getById(int id){
        String sql = "SELECT id,name,genre,about,image_path FROM artist WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Artist a = new Artist(rs.getInt("id"),rs.getString("name"),rs.getString("genre"),rs.getString("about"),rs.getString("image_path"));
                return Optional.of(a);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
    
    public ArrayList<Artist> getByName(String name){
        ArrayList<Artist> artists = new ArrayList();
        String sql = "SELECT id,name,genre,about,image_path FROM artist WHERE name LIKE(?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "%"+name+"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Artist a = new Artist(rs.getInt("id"),rs.getString("name"),rs.getString("about"),rs.getString("genre"),rs.getString("image_path"));
                artists.add(a);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return artists;
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM artist WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateImage(int id, String imagePath) {
        String sql = "UPDATE artist SET image_path = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, imagePath);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateAbout(int id, String about) {
        String sql = "UPDATE artist SET about = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, about);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateName(int id, String name) {
        String sql = "UPDATE artist SET name = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, name);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateGenre(int id, String genre) {
        String sql = "UPDATE artist SET genre = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, genre);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateAll(int id, String name, String genre, String about, String imagePath){
        String sql = "UPDATE artist SET name = ?, about = ?, genre = ?, image_path = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, name);
            stmt.setString(i++, genre);
            stmt.setString(i++, about);
            stmt.setString(i++, imagePath);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}