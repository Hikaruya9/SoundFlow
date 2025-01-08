/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connection.DB;
import data.Release;
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
public class ReleaseDAO {
    
    public void add(String title, String releaseDate, int trackNumber, String length, String imagePath, int artistId) {
        String sql = "INSERT INTO artist_release(title,release_date,track_number,release_length,image_path,artist_id) VALUES(?,?,?,?,?,?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, title);
            stmt.setString(i++, releaseDate);
            stmt.setInt(i++, trackNumber);
            stmt.setString(i++, length);
            stmt.setString(i++, imagePath);
            stmt.setInt(i++, artistId);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Release> getById(int id){
        ArrayList<Release> release = new ArrayList();
        String sql = "SELECT id,title,release_date,track_number,release_length,image_path,artist_id FROM artist_release WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Release r = new Release(rs.getInt("id"), rs.getString("title"), rs.getString("release_date"), rs.getInt("track_number"), rs.getString("release_length"), rs.getString("image_path"), rs.getInt("artist_id"));
                release.add(r);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return release;
    }
    
    public ArrayList<Release> getByTitle(String title){
        ArrayList<Release> releases = new ArrayList();
        String sql = "SELECT id,title,release_date,track_number,release_length,image_path,artist_id FROM artist_release WHERE title LIKE(?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "%"+title+"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Release r = new Release(rs.getInt("id"), rs.getString("title"), rs.getString("release_date"), rs.getInt("track_number"), rs.getString("release_length"), rs.getString("image_path"), rs.getInt("artist_id"));
                releases.add(r);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return releases;
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM artist_release WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateTitle(int id, String title) {
        String sql = "UPDATE artist_release SET title = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, title);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateReleaseDate(int id, String releaseDate) {
        String sql = "UPDATE artist_release SET release_date = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, releaseDate);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateTrackNumber(int id, int trackNumber) {
        String sql = "UPDATE artist_release SET track_number = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setInt(i++, trackNumber);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateReleaseLength(int id, String releaseLength) {
        String sql = "UPDATE artist_release SET title = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, releaseLength);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateImagePath(int id, String imagePath) {
        String sql = "UPDATE artist_release SET title = ? WHERE id = ?";
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
    
    public boolean updateArtistId(int id, int artistId) {
        String sql = "UPDATE artist_release SET title = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setInt(i++, artistId);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateAll(int id, String title, String releaseDate, int trackNumber, String releaseLength, String imagePath, int artistId) {
        String sql = "UPDATE artist_release SET title = ?, release_date = ?, track_number = ?, release_length = ?, image_path = ?, artist_id = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, title);
            stmt.setString(i++, releaseDate);
            stmt.setInt(i++, trackNumber);
            stmt.setString(i++, releaseLength);
            stmt.setString(i++, imagePath);
            stmt.setInt(i++, artistId);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}