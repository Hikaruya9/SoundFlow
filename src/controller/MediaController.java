/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import data.Track;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import jmusic.JMusicPlayerList;
import jmusic.JMusicSong;
import jmusic.MusicPlayerControl;
import model.TrackDAO;

/**
 * View media controller class for the JMain window
 *
 * @author macig
 */
public class MediaController {

    private boolean iPressedResumeButton = false;
    private boolean iPressedPauseButton = false;
    private boolean isActualSongComplete = true;
    private boolean iMustRepeatASong;
    private int queueIndex;
    public TrackDAO trackDAO;
    public JMusicPlayerList musicList;

    private DefaultListModel<Track> trackModel;
    private DefaultListModel model;
    /*Outlets*/
    private JList<Track> listSongs;
    private JList listQueue;
    private JButton playButton;
    private JLabel songTitle;
    private JLabel songArtist;
    private JLabel songImage;
    private JLabel songLength;

    public MediaController(TrackDAO trackDAO, JMusicPlayerList musicList) {
        this.trackDAO = trackDAO;
        this.musicList = musicList;
    }

    public MediaController() {

    }

    public void initOutlets(JList<Track> listSongs, JList listQueue, JButton playButton, JLabel songTitle, JLabel songArtist, JLabel songImage, JLabel songLength) {
        this.listSongs = listSongs;
        this.listQueue = listQueue;
        this.playButton = playButton;
        this.songTitle = songTitle;
        this.songArtist = songArtist;
        this.songImage = songImage;
        this.songLength = songLength;
    }

    /**
     * Method to change the buttons images
     *
     * @since JMusic 1.0.0
     */
    public void changeLogicButtons() {
        if (iPressedPauseButton) {
            pauseSong();
            playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));
            iPressedPauseButton = false;
            iPressedResumeButton = true;
        } else {
            if (iPressedResumeButton) {
                resumeSong();
                iPressedResumeButton = false;
            } else {
                playSong();
                iPressedResumeButton = true;
            }
            playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));
            iPressedPauseButton = true;
        }
    }

    public void updateSongInfo(JMusicSong song) {
//        songTitle.setText(song.getSongName());
//        songArtist.setText(song.getArtist());
//        songImage.setIcon(new javax.swing.ImageIcon("E:/Músicas/SoundFlow/cover/" + song.getArtist() + "/" + song.getAlbum() + ".png"));

//        ArrayList<Track> track = trackDAO.getById(id);
//
//        for (Track t : track) {
//        songTitle.setText(t.getTitle());
//        songArtist.setText(t.getArtistName());
//        songImage.setIcon(new javax.swing.ImageIcon(t.getCoverImagePath()));
//            songLength.setText(t.getTrackLength());
//        }
    }

    public void insertSongIntoList(String title) {
        trackModel = new DefaultListModel();

        for (Track t : trackDAO.getByTitle(title)) {
            trackModel.addElement(t);
        }
        listSongs.setModel(trackModel);
    }

    public void insertSongIntoPlayerList(int id) {
        model = new DefaultListModel();
        ArrayList<Track> track = trackDAO.getById(id);

        for (Track t : track) {
            JMusicSong song = new JMusicSong(queueIndex, t.getAudioFile(), t.getTitle(), t.getArtistName(), t.getReleaseTitle());
            musicList.addSongToPlayerList(song);
        }
        insertSongsIntoQueue();
    }

    public void insertSongsIntoQueue() {
        Iterator listPlayerIterator = musicList.iterator();
        queueIndex = 0;

        while (listPlayerIterator.hasNext()) {
            JMusicSong song = (JMusicSong) listPlayerIterator.next();

            int numberSong = song.getNumberSong() + 1;
            String info = " " + (numberSong) + "    " + song.getSongName() + " - " + song.getArtist();
            model.add(queueIndex, info);
            queueIndex++;
        }
        listQueue.setModel(model);
    }

    public void clearPlayerList() {
        musicList = new JMusicPlayerList();
    }

    public void clearQueue() {
//        stopSong();
        queueIndex = 0;

        model = (DefaultListModel) listQueue.getModel();
        model.removeAllElements();
    }

    public void changeSongFromIndex(int indexSong) {
        stopSong();
        MusicPlayerControl.changeSongFromIndexSong(indexSong);
    }

    public void initMusicPlayer(String directory, JMusicPlayerList songsList) {
        /* init the music player with the path of the mp3 songs */
        MusicPlayerControl.initMusicPlayer(directory, listSongs);

        musicList = songsList;

//        loadSongsInList();
        MusicPlayerControl.loadSongs(musicList);
    }

    /**
     * Method to play a song
     */
    public void playSong() {
        MusicPlayerControl.playSong();
    }

    /**
     * Method to stop a song
     */
    public void stopSong() {
        MusicPlayerControl.stopSong();
        iPressedResumeButton = false;
        iPressedPauseButton = false;
        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));
    }

    /**
     * Method to pause a song
     */
    public void pauseSong() {
        MusicPlayerControl.pauseSong();
    }

    /**
     * Method to resume a song
     */
    public void resumeSong() {
        MusicPlayerControl.resumeSong();
    }

    /**
     * Method to play the song
     */
    public void nextSong() {
        inactiveRepeatSong();
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        stopSong();
        MusicPlayerControl.nextSong();
    }

    /**
     * Method to play the prev song
     */
    public void prevSong() {
        inactiveRepeatSong();
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        stopSong();
        MusicPlayerControl.prevSong();
    }

    /**
     * Method to inactive the repeat song process
     */
    private void inactiveRepeatSong() {
        iMustRepeatASong = false;
        MusicPlayerControl.repeatSong(iMustRepeatASong);
    }

    /**
     * Method to repeat the actual song
     */
    public void repeatSong() {
        iMustRepeatASong = !iMustRepeatASong;
        MusicPlayerControl.repeatSong(iMustRepeatASong);

    }

    /**
     * Method to shuffle the list of songs
     */
    public void shuffle() {
        musicList.shuffle();

        MusicPlayerControl.updateOrderInPlayerList();

        clearQueue();

        insertSongsIntoQueue();

        MusicPlayerControl.updateSelectedSongInList();
    }
}
