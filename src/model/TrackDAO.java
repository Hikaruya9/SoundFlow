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
import java.util.Optional;

/**
 *
 * @author Aluno
 */
public class TrackDAO {
    
    public void add(String title, String trackLength, String audioFile, int artistId, int releaseId){
        String sql = "INSERT INTO track(title,track_length,audio_file,artist_id,release_id) VALUES(?,?,?,?,?)";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            int i = 1;
            stmt.setString(i++, title);
            stmt.setString(i++, trackLength);
            stmt.setString(i++, audioFile);
            stmt.setInt(i++, artistId);
            stmt.setInt(i++, releaseId);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Optional<Track> getById(int id){
        String sql = "SELECT id,title,track_length,audio_file,artist_id,release_id FROM track WHERE id = ?";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Track t = new Track(rs.getInt("id"), rs.getString("title"), rs.getString("audio_file"), rs.getString("track_length"), rs.getInt("artist_id"), rs.getInt("release_id"));
                return Optional.of(t);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
    
    public ArrayList<Track> getByTitle(String title){
        ArrayList<Track> tracks = new ArrayList();
        String sql = "SELECT id,title,track_length";
        try(Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Track t = new Track(rs.getInt("id"), rs.getString("title"), rs.getString("audio_file"), rs.getString("track_length"), rs.getInt("artist_id"), rs.getInt("release_id"));
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
}