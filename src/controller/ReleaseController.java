/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import data.Release;
import java.util.ArrayList;
import java.util.Optional;
import model.ReleaseDAO;

/**
 *
 * @author macig
 */
public class ReleaseController {
    
    public ReleaseDAO releaseDAO;
    
    public ReleaseController(ReleaseDAO releaseDAO) {
        this.releaseDAO = releaseDAO;
    }
    
    public void add(String title, String releaseDate, int trackNumber, String length, String imagePath, int artistId) {
        releaseDAO.add(title, releaseDate, trackNumber, length, imagePath, artistId);
    }
    
    public ArrayList<Release> getById(int id){
        return releaseDAO.getById(id);
    }
    
    public ArrayList<Release> getByTitle(String title){
        return releaseDAO.getByTitle(title);
    }
    
    public boolean delete(int id){
        return releaseDAO.delete(id);
    }
    
    public boolean updateTitle(int id, String title) {
        return releaseDAO.updateTitle(id, title);
    }
    
    public boolean updateReleaseDate(int id, String releaseDate) {
        return releaseDAO.updateReleaseDate(id, releaseDate);
    }
    
    public boolean updateTrackNumber(int id, int trackNumber) {
        return releaseDAO.updateTrackNumber(id, trackNumber);
    }
    
    public boolean updateReleaseLength(int id, String releaseLength) {
        return releaseDAO.updateReleaseLength(id, releaseLength);
    }
    
    public boolean updateImagePath(int id, String imagePath) {
        return releaseDAO.updateImagePath(id, imagePath);
    }
    
    public boolean updateArtistId(int id, int artistId) {
        return releaseDAO.updateArtistId(id, artistId);
    }
    
    public boolean updateAll(int id, String title, String releaseDate, int trackNumber, String releaseLength, String imagePath, int artistId) {
        return releaseDAO.updateAll(id, title, releaseDate, trackNumber, releaseLength, imagePath, artistId);
    }
}