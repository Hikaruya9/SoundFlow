/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connection.DB;
import data.Track;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class TrackDAO {
    
    public void add(String title, String releaseTitle, String artistName, String trackLength, String audioFile, String coverImagePath){
        String sql = "INSERT INTO track(title,release_title,artist_name,track_length,audio_file,cover_image_path) VALUES(?,?,?,?,?,?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, title);
            stmt.setString(i++, releaseTitle);
            stmt.setString(i++, artistName);
            stmt.setString(i++, trackLength);
            stmt.setString(i++, audioFile);
            stmt.setString(i++, coverImagePath);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Track> getById(int id){
        ArrayList<Track> track = new ArrayList();
        String sql = "SELECT id,title,release_title,artist_name,track_length,audio_file,cover_image_path FROM track WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Track t = new Track(rs.getInt("id"), rs.getString("title"), rs.getString("release_title"), rs.getString("artist_name"), rs.getString("track_length"), rs.getString("audio_file"), rs.getString("cover_image_path"));
                track.add(t);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return track;
    }
    
    public ArrayList<Track> getByTitle(String title){
        ArrayList<Track> tracks = new ArrayList();
        String sql = "SELECT id,title,release_title,artist_name,track_length,audio_file,cover_image_path FROM track WHERE title LIKE (?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "%"+title+"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Track t = new Track(rs.getInt("id"), rs.getString("title"), rs.getString("release_title"), rs.getString("artist_name"), rs.getString("track_length"), rs.getString("audio_file"), rs.getString("cover_image_path"));
                tracks.add(t);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return tracks;
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM track WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateAll(int id, String title, String releaseTitle, String artistName, String trackLength, String audioFile, String coverImagePath) {
        String sql = "UPDATE track SET title = ?, release_title = ?, artist_name = ?, track_length = ?, audio_file = ?, cover_image_path = ? WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, title);
            stmt.setString(i++, releaseTitle);
            stmt.setString(i++, artistName);
            stmt.setString(i++, trackLength);
            stmt.setString(i++, audioFile);
            stmt.setString(i++, coverImagePath);
            stmt.setInt(i++, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}