/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aluno
 */
public class Track {
    private int artistId;
    private String releaseId;
    private int id;
    private String title;
    private String trackLength;
    private String releaseImagePath;
    
    public Track(){
        
    }

    public Track(int artistId, String releaseId, int id, String title, String trackLength, String releaseImagePath) {
        this.artistId = artistId;
        this.releaseId = releaseId;
        this.id = id;
        this.title = title;
        this.trackLength = trackLength;
        this.releaseImagePath = releaseImagePath;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public int getTrackId() {
        return id;
    }

    public void setTrackId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(String trackLength) {
        this.trackLength = trackLength;
    }

    public String getReleaseImagePath() {
        return releaseImagePath;
    }

    public void setReleaseImagePath(String releaseImagePath) {
        this.releaseImagePath = releaseImagePath;
    }
}