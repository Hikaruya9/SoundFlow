/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import data.Artist;
import jmusic.JMusicPlayerList;
import java.util.ArrayList;
import java.util.Optional;
import jmusic.JMusicSong;
import model.ArtistDAO;

/**
 *
 * @author macig
 */
public class ArtistController {
    
    public ArtistDAO artistDAO;
    
    public ArtistController(ArtistDAO artistDAO){
        this.artistDAO = artistDAO;
    }
    
    public void add(String name, String about, String genre, String imagePath) {
        artistDAO.add(name, about, genre, imagePath);
    }
    
    public ArrayList<Artist> getById(int id){
        return artistDAO.getById(id);
    }
    
    public ArrayList<Artist> getByName(String name){
        return artistDAO.getByName(name);
    }
    
    public boolean delete(int id) {
        return artistDAO.delete(id);
    }
    
    public boolean updateImage(int id, String imagePath) {
        return artistDAO.updateImage(id, imagePath);
    }
    
    public boolean updateAbout(int id, String about) {
        return artistDAO.updateAbout(id, about);
    }
    
    public boolean updateName(int id, String name) {
        return artistDAO.updateName(id, name);
    }
    
    public boolean updateGenre(int id, String genre) {
        return artistDAO.updateGenre(id, genre);
    }
    
    public boolean updateAll(int id, String name, String genre, String about, String imagePath){
        return artistDAO.updateAll(id, name, genre, about, imagePath);
    }
}