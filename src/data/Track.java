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
    private String releaseTitle;
    private String artistName;
    private String trackLength;
    private String audioFile;
    private String coverImagePath;
    
    public Track(){
        
    }

    public Track(int id, String title, String release_title, String artist_name, String trackLength, String audioFile, String cover_image_path) {
        this.id = id;
        this.title = title;
        this.releaseTitle = release_title;
        this.artistName = artist_name;
        this.trackLength = trackLength;
        this.audioFile = audioFile;
        this.coverImagePath = cover_image_path;
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

    public String getReleaseTitle() {
        return releaseTitle;
    }

    public void setReleaseTitle(String releaseTitle) {
        this.releaseTitle = releaseTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(String trackLength) {
        this.trackLength = trackLength;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }
    
    @Override
    public String toString() {
        return "   " + getId() + "           "
                        + getTitle() + "                                          "
                        + getArtistName() + "                                                   "
                        + getReleaseTitle() + "                                                           "
                        + getTrackLength();
    }
}