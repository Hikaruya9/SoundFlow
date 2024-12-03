/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Aluno
 */
public class Track {
    private int id;
    private String title;
    private String trackLength;
    private int artistId;
    private int releaseId;
    private String audioFile;
    
    public Track(){
        
    }
    
    public Track(int id, String title, String trackLength, int artistId, int releaseId, String audioFile) {
        this.id = id;
        this.title = title;
        this.trackLength = trackLength;
        this.artistId = artistId;
        this.releaseId = releaseId;
        this.audioFile = audioFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }
    
    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }
}