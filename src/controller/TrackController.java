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

    public void add(String title, String releaseTitle, String artistName, String trackLength, String audioFile, String coverImagePath) {
        trackDAO.add(title, releaseTitle, artistName, trackLength, audioFile, coverImagePath);
    }

    public ArrayList<Track> getById(int id) {
        return trackDAO.getById(id);
    }

    public ArrayList<Track> getByTitle(String title) {
        return trackDAO.getByTitle(title);
    }

    public boolean delete(int id) {
        return trackDAO.delete(id);
    }

    public boolean updateAll(int id, String title, String releaseTitle, String artistName, String trackLength, String audioFile, String coverImagePath) {
        return trackDAO.updateAll(id, title, releaseTitle, artistName, trackLength, audioFile, coverImagePath);
    }
}
