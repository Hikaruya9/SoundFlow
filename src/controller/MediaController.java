/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import jmusic.JMusicPlayerList;
import jmusic.JMusicSong;
import jmusic.MusicPlayerControl;
import model.ArtistDAO;
import model.ReleaseDAO;
import model.TrackDAO;

/**
 *
 * @author macig
 */
public class MediaController {
    
    ArtistDAO artistDAO;
    ReleaseDAO releaseDAO;
    TrackDAO trackDAO;

    private JMusicPlayerList musicList;
    
    public Clip clip;
    public float previousVolume = 0;
    public float currentVolume = 0;
    public FloatControl fc;
    public boolean mute = false;
           

    private void carregarMusicas() {
        // carregar as musicas
        JMusicSong song = new JMusicSong(1, "King Crimson - Epitath", "Epitath", "King Crimson", "In The Court Of The Crimson King");
        JMusicPlayerList musicList = new JMusicPlayerList();
        musicList.addSongToPlayerList(song);
        MusicPlayerControl.initMusicPlayer("E:/Músicas/SoundFlow/audio");
        MusicPlayerControl.loadSongs(musicList);
    }

//    public void minimizar() {
//        ((Stage) telaApp.getScene().getWindow()).toBack();
//    }
//
//    public void fechar() {
//        System.exit(0);
//    }

    public void mute() {
        
    }

    public void volume(URL url) {
        
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }catch(Exception e){
            System.out.println("Failed to associate JMusicSong to the sound, check log for more info: "+e.getMessage());
        }
        
    }
}
