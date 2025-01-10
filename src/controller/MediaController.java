/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Cursor;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import jmusic.JMusicPlayerList;
import jmusic.JMusicSong;
import jmusic.MusicPlayerControl;
//import jmusic.player.view.AboutWindow;
import jmusic.util.UtilFunctions;
import model.ArtistDAO;
import model.ReleaseDAO;
import model.TrackDAO;
import view.JMain;

/**
 *
 * @author macig
 */
public class MediaController {
    
    ArtistDAO artistDAO;
    ReleaseDAO releaseDAO;
    TrackDAO trackDAO;

    private JMusicPlayerList musicList;
    
//    public float previousVolume = 0;
//    public float currentVolume = 0;
//    public boolean mute = false;
    
    /**
 * View media controller class for the JMain window
 * @author Ricardo Casanova
 * @version 1.0.0
 */

    private static boolean              iPressedThePauseButton;
    private static boolean              iPressedTheResumeButton;
    private static boolean              iMustRepeatASong;
    private static boolean              iMustRepeatASongFromTheBeginning;
    private static boolean              secondPress;
    private static Date                 theFirstClicMoment;
    private static int                  jListIndexSelected;
    private static JMusicPlayerList     list;
    
    private static DefaultListModel     model;
    /* the outlets */
    private static JMain          mainWindow;
    private static JButton              playButton;
    private static JList                listSongs;
    private static JLabel               songInfo;
    private static JCheckBoxMenuItem    repeatSong;
    private static JCheckBoxMenuItem    repeatSongsFromTheBeginning;
    private static JLabel               repeatSongIcon;
    private static JMenuItem            playOrPauseText;
    
    /**
     * Method to init the outlets
     * @param mainWindow
     * @param playButton The play button in the GUI
     * @param listSongs The JList with the list of the songs
     * @param songInfo The JLabel with the song's information
     * @param repeatSong The JCheckBoxMenuItem to repeat a song
     * @param repeatSongIcon The JLabel with the icon for the repeat song action
     * @param repeatSongsFromTheBeginning The JCheckBoxMenuItem to repeat all songs from the beginning
     * @param playOrPauseText The JMenuItem with the "Play" or "Pause" text
     */
    public static void initOutlets( JMain mainWindow, 
                                    JButton playButton, JList listSongs, 
                                    JLabel songInfo, 
                                    JCheckBoxMenuItem repeatSong, 
                                    JLabel repeatSongIcon, 
                                    JCheckBoxMenuItem repeatSongsFromTheBeginning, 
                                    JMenuItem playOrPauseText)
    {
        MediaController.mainWindow = mainWindow;
        MediaController.playButton = playButton;
        MediaController.listSongs  = listSongs;
        MediaController.songInfo   = songInfo;
        MediaController.repeatSong = repeatSong;
        MediaController.repeatSongIcon = repeatSongIcon;
        MediaController.repeatSongsFromTheBeginning = repeatSongsFromTheBeginning;
        MediaController.playOrPauseText = playOrPauseText;
    }
         
    /**
     * Method to get the current time
     * @return The current time (in a Date)
     */
    private static Date getCurrentTime()
    {
        return new Date();
    }
    
    /**
     * Method to verify if i'm doing a double clic
     * @return A boolean (i'm doing a double clic -true- or not -false-)
     */
    private static boolean iamDoingDoubleClicOverTheComponent()
    {
        /* if it's the second press over the component &&
         * the difference between the first clic moment and the second is <= 1 sec &&
         * i'm doing the clic over the same element in the JList
         * THEN -> i'm doing double clic! :)
         */
        return secondPress && ( getCurrentTime().getTime() - theFirstClicMoment.getTime() ) / 1000 <= 1 && jListIndexSelected == MediaController.listSongs.getSelectedIndex();
    }  
    
    /**
     * Method to validate the double clic event
     */
    public static void validateDoubleClic()
    {
        int indexSong;
        
        if (iamDoingDoubleClicOverTheComponent())
        {
            /* stop the actual song */
            MusicPlayerControl.stopSong();
            
            /* select the new song (index) from the JList */
            indexSong = MediaController.listSongs.getSelectedIndex();
            
            inactiveRepeatSong();
        
            /* change the song in JMusic */
            MusicPlayerControl.changeSongFromIndexSong(indexSong);
            
            /* did I press the pause button? mmm.. no */
            iPressedThePauseButton = false;
            /* and did I press the resume button? mmm.. no */
            iPressedTheResumeButton = false;
            
            /* second press is false again (waiting for the next double clic) */
            secondPress = false;
            
            /* change the buttons images */
            changeLogicButtons();
        }
        else
        {
            /* this is the first clic... i'm waiting for the next */
            secondPress = !secondPress;
            
            /* select the index in the JList */
            jListIndexSelected = MediaController.listSongs.getSelectedIndex();
            
            /* get the time for the first clic moment */
            theFirstClicMoment = getCurrentTime();
        }
    }
    
    /**
     * Method to change the buttons images
     */
    public static void changeLogicButtons()
    {
        /* did I press the pause button?... well, pause the song */
        if (iPressedThePauseButton)
            pauseSong();
        else
        {   
            /* did I press the resume button?... well, resume the song */
            if (iPressedTheResumeButton)
                resumeSong();
            else
                /* well... just play a song */
                playSong();
        }
        
        iPressedThePauseButton = !iPressedThePauseButton;
        
        /* if I didn't press the pause button, I'll change the image in the play button */
        if (iPressedThePauseButton)
        {
            try
            {
                playButton.setIcon(new ImageIcon(ImageIO.read(MediaController.class.getResource("/pause.png"))));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                playOrPauseText.setText(UtilFunctions.getPauseTextButton());
            }
        }
        else
        {
            /* if I pressed the pause button, I'll change the image in the play button */
            try
            {
                playButton.setIcon(new ImageIcon(ImageIO.read(MediaController.class.getResource("/play.png"))));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                playOrPauseText.setText(UtilFunctions.getPlayTextButton());
                iPressedTheResumeButton = true;
            }
        }
    }
    
    /**
     * Method to init the list songs
     * @param removeAllElements Boolean to determinate if I want to remove all elements in the list
     */
    private static void initTheListSongsAndRemoveAllElements(boolean removeAllElements)
    {
        if (removeAllElements)
            MediaController.listSongs.removeAll();
        
        model = new DefaultListModel();
        MediaController.listSongs.setModel(model);
    }
    
    /**
     * Method to load song int the list
     */
    private static void loadSongsInList()
    {
        Iterator listPlayerIterator = list.iterator();
        int i = 0;
        
        while (listPlayerIterator.hasNext()) 
        {
            JMusicSong song = (JMusicSong) listPlayerIterator.next();
            
            int numberSong = song.getNumberSong() + 1;
            String info = "" + numberSong + " " + song.getSongName();
            model.add(i, info);
            i++;
        }
    }
    
    /**
     * Method to init the music player
     * @param directory The directory path
     * @param songsList The song list
     */
    public static void initMusicPlayer(String directory, JMusicPlayerList songsList)
    {
        /* init the music player with the path of the mp3 songs */
        MusicPlayerControl.initMusicPlayer(directory, listSongs, songInfo);
        
        list = songsList;
        
        initTheListSongsAndRemoveAllElements(true);

        loadSongsInList();
   
        MusicPlayerControl.loadSongs(list);
        iPressedThePauseButton = false;
        iPressedTheResumeButton = false;
        secondPress = false; 
        
        inactiveRepeatSong();
        inactiveRepeatSongsFromTheBeginning();
    }
    
    /**
     * Method to play a song
     */
    public static void playSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MusicPlayerControl.playAllSongs();
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to pause a song
     */
    public static void pauseSong()
    {
        MusicPlayerControl.pauseSong();
    }
    
    /**
     * Method to resume a song
     */
    public static void resumeSong()
    {
        MusicPlayerControl.resumeSong();
    }
    
    /**
     * Method to stop a song
     */
    public static void stopSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MusicPlayerControl.stopSong();
        iPressedThePauseButton = false;
        iPressedTheResumeButton = false;
        try
        {
            playButton.setIcon(new ImageIcon(ImageIO.read(MediaController.class.getResource("/play.png"))));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to play the song
     */
    public static void nextSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        inactiveRepeatSong();
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        repeatSong.setSelected(iMustRepeatASong);
        MusicPlayerControl.nextSong();
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to play the prev song
     */
    public static void prevSong()
    {
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        inactiveRepeatSong();
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        repeatSong.setSelected(iMustRepeatASong);
        MusicPlayerControl.prevSong();
        mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Method to inactive the repeat song process
     */
    private static void inactiveRepeatSong()
    {
        iMustRepeatASong = false;
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        repeatSong.setSelected(false);
        MediaController.repeatSongIcon.setVisible(iMustRepeatASong); 
    }
    
    /**
     * Method to repeat the actual song
     */
    public static void repeatSong()
    {
        iMustRepeatASong = !iMustRepeatASong;
        MusicPlayerControl.repeatSong(iMustRepeatASong);
        
        MediaController.repeatSongIcon.setVisible(iMustRepeatASong);    
    }
    
    /**
     * Method to inactive the repeat songs from the beginning process
     */
    private static void inactiveRepeatSongsFromTheBeginning()
    {
        iMustRepeatASongFromTheBeginning = false;
        MusicPlayerControl.repeatSongsFromTheBeginning(iMustRepeatASongFromTheBeginning);
        repeatSongsFromTheBeginning.setSelected(false);
    }
    
    /**
     * Method to repeat all songs from the beginning
     */
    public static void repeatSongsFromTheBeginning()
    {
        iMustRepeatASongFromTheBeginning = !iMustRepeatASongFromTheBeginning;
        MusicPlayerControl.repeatSongsFromTheBeginning(iMustRepeatASongFromTheBeginning);
    }
    
    /**
     * Method to shuffle the list of songs
     */
    public static void shuffle()
    {
        list.shuffle();
        
        MusicPlayerControl.updateOrderInPlayerList();
        
        initTheListSongsAndRemoveAllElements(true);
        
        loadSongsInList();
        
        MusicPlayerControl.updateSelectedSongInList();   
    }

//    private void carregarMusicas() {
//        // carregar as musicas
////        JMusicSong song = new JMusicSong(1, "King Crimson - Epitath", "Epitath", "King Crimson", "In The Court Of The Crimson King");
////        JMusicPlayerList musicList = new JMusicPlayerList();
////        musicList.addSongToPlayerList(song);
////        MusicPlayerControl.initMusicPlayer("E:/Músicas/SoundFlow/audio");
////        MusicPlayerControl.loadSongs(musicList);
//    }
//
//
//    public void mute() {
//        
//    }
//
//    public void volume(URL url) {
//        
////        try{
////            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
////            clip = AudioSystem.getClip();
////            clip.open(sound);
////            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
////        }catch(Exception e){
////            System.out.println("Failed to associate JMusicSong to the sound, check log for more info: "+e.getMessage());
////        }
//        
//    }
}
