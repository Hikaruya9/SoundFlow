/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import data.Track;
import java.util.ArrayList;
import model.TrackDAO;

/**
 *
 * @author macig
 */
public class TrackController {
    
    public TrackDAO trackDAO;
    
    public TrackController(TrackDAO trackDAO) {
        this.trackDAO = trackDAO;
    }
    
    public void add(String title, String trackLength, String audioFile, int artistId, int releaseId){
        trackDAO.add(title, trackLength, audioFile, artistId, releaseId);
    }
    
    public ArrayList<Track> getById(int id){
        return trackDAO.getById(id);
    }
    
    public ArrayList<Track> getByTitle(String title){
        return trackDAO.getByTitle(title);
    }
    
    public boolean delete(int id){
        return trackDAO.delete(id);
    }
    
    public boolean updateTitle(int id, String title) {
        return trackDAO.updateTitle(id, title);
    }
    
    public boolean updateTrackNumber(int id, String trackLength) {
        return trackDAO.updateTrackNumber(id, trackLength);
    }
    
    public boolean updateAudioFile(int id, String audioFile) {
        return trackDAO.updateAudioFile(id, audioFile);
    }
    
    public boolean updateReleaseId(int id, String releaseId) {
        return trackDAO.updateReleaseId(id, releaseId);
    }
    
    public boolean updateArtistId(int id, int artistId) {
        return trackDAO.updateArtistId(id, artistId);
    }
    
    public boolean updateAll(int id, String title, String trackLength, String audioFile, int releaseId, int artistId) {
        return trackDAO.updateAll(id, title, trackLength, audioFile, releaseId, artistId);
    }
}