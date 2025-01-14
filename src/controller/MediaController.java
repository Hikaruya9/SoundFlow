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
    private boolean initPlayer = false;
    private boolean repeatSameSong;
    private int queueIndex;
    private int selectedIndex;
    private TrackDAO trackDAO;
    private ArrayList<Integer> songIDs = new ArrayList();
    private ArrayList<JMusicSong> playerListSongs;
    public JMusicPlayerList musicList;
    public JMusicSong song;

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
    private JButton repeatButton;

    public MediaController(TrackDAO trackDAO, JMusicPlayerList musicList) {
        this.trackDAO = trackDAO;
        this.musicList = musicList;
    }

    // Construtor limpo
    public MediaController() {

    }

    // Método para inicializar os objetos gráficos criados
    public void initOutlets(JList<Track> listSongs, JList listQueue, JButton playButton, JLabel songTitle, JLabel songArtist, JLabel songLength, JLabel songImage, JButton repeatButton) {
        this.listSongs = listSongs;
        this.listQueue = listQueue;
        this.playButton = playButton;
        this.songTitle = songTitle;
        this.songArtist = songArtist;
        this.songImage = songImage;
        this.songLength = songLength;
        this.repeatButton = repeatButton;
    }

    // Método para alterar as imagens do PlayButton e o estado da música
    public void changeLogicButtons() {
        if (musicList.size() > 0) {
            if (iPressedPauseButton) {
                pauseSong();
                playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));
                iPressedPauseButton = !iPressedPauseButton;
                iPressedResumeButton = !iPressedPauseButton;
            } else {
                if (iPressedResumeButton) {
                    resumeSong();
                    iPressedResumeButton = !iPressedResumeButton;
                } else {
                    playSong();
                    iPressedResumeButton = !iPressedResumeButton;
                    updateSongInfo();
                    MusicPlayerControl.changeSongFromIndexSong(selectedIndex);
                }
                playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));
                iPressedPauseButton = !iPressedPauseButton;
            }
        }
    }

    // Método que atualiza as informações da música tocada no JMain
    public void updateSongInfo() {
        ArrayList<Track> track = trackDAO.getById(songIDs.get(selectedIndex));

        for (Track t : track) {
            songTitle.setText(t.getTitle());
            songArtist.setText(t.getArtistName());
            songLength.setText(t.getTrackLength());
            songImage.setIcon(new javax.swing.ImageIcon(t.getCoverImagePath()));
        }
    }

    //Método para trazer as músicas do BD à lista de pesquisa
    public void insertSongIntoList(String title) {
        trackModel = new DefaultListModel();

        for (Track t : trackDAO.getByTitle(title)) {
            trackModel.addElement(t);
        }
        listSongs.setModel(trackModel);
    }

    //Método para inserir a música obtida à lista no JMusicPlayerList
    public void insertSongIntoPlayerList(int id) {
        songIDs.add(id);
        model = new DefaultListModel();
        ArrayList<Track> track = trackDAO.getById(id);

        for (Track t : track) {
            song = new JMusicSong(queueIndex, t.getAudioFile(), t.getTitle(), t.getArtistName(), t.getReleaseTitle());
        }
        musicList.addSongToPlayerList(song);
        insertSongsIntoQueue();
    }

    //Método para inserir as músicas na lista a ser tocada
    public void insertSongsIntoQueue() {
        Iterator listPlayerIterator = musicList.iterator();
        queueIndex = 0;

        while (listPlayerIterator.hasNext()) {
            song = (JMusicSong) listPlayerIterator.next();

            int numberSong = song.getNumberSong() + 1;
            String info = " " + numberSong + "    " + song.getSongName() + " - " + song.getArtist();
            model.add(queueIndex, info);
            queueIndex++;
        }
        listQueue.setModel(model);
    }

    // Método pra limpar a PlayerList atual
    public void clearPlayerList() {
        musicList = new JMusicPlayerList();
        MusicPlayerControl.loadSongs(musicList);
    }

    // Método para limpar a lista de músicas atual
    public void clearQueue() {
        if (musicList.size() > 0) {
            model.removeAllElements();
            listQueue.setModel(model);
            songIDs.removeAll(songIDs);
            queueIndex = 0;
            selectedIndex = 0;

            stopSong();
        }
    }

    // Método para mudar a música a ser tocada
    public void changeSongFromIndex() {
        stopSong();
        selectedIndex = listQueue.getSelectedIndex();
        MusicPlayerControl.changeSongFromIndexSong(selectedIndex);
        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));
        iPressedPauseButton = false;
        iPressedResumeButton = true;
        updateSongInfo();
    }

    // Método que inicializa o JMusicPlayerList
    public void initMusicPlayer() {
        if (!initPlayer) {
            /* Inicializa o MusicPlayer com o caminho pro diretório das músicas MP3 
            *
            * "C:/Users/Aluno/Documents/res/audio" || //"E:/Músicas/SoundFlow/audio"
             */
            MusicPlayerControl.initMusicPlayer("E:/Músicas/SoundFlow/audio", listQueue);

            MusicPlayerControl.loadSongs(musicList);

            inactiveRepeatSong();

            initPlayer = !initPlayer;
        }
    }

    // Método para tocar a música selecionada da lista
    public void playSong() {
        MusicPlayerControl.playAllSongs();
    }

    // Método para parar a música atual
    public void stopSong() {
        if (initPlayer) {
            MusicPlayerControl.stopSong();

            iPressedPauseButton = false;
            iPressedResumeButton = false;
            playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));
        }
    }

    // Método para pausar a música atual
    public void pauseSong() {
        MusicPlayerControl.pauseSong();
    }

    // Método para retomar a música atual
    public void resumeSong() {
        MusicPlayerControl.resumeSong();
    }

    // Método para prosseguir à música posterior na lista atual
    public void nextSong() {
        if (musicList.size() > 0) {
            inactiveRepeatSong();
            MusicPlayerControl.repeatSong(repeatSameSong);
            stopSong();
            MusicPlayerControl.nextSong();

            if (selectedIndex < musicList.size() - 1) {
                selectedIndex++;
            } else {
                selectedIndex = 0;
                MusicPlayerControl.changeSongFromIndexSong(0);
            }

            updateSongInfo();
            iPressedPauseButton = true;
            iPressedResumeButton = false;
            playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));
        }
    }

    // Método para voltar à música anterior na lista atual
    public void prevSong() {
        if (musicList.size() > 0) {
            inactiveRepeatSong();
            MusicPlayerControl.repeatSong(repeatSameSong);
            stopSong();
            MusicPlayerControl.prevSong();

            if (selectedIndex > 0) {
                selectedIndex--;
            } else {
                selectedIndex = musicList.size() - 1;
                MusicPlayerControl.changeSongFromIndexSong(musicList.size() - 1);
            }

            updateSongInfo();
            iPressedPauseButton = true;
            iPressedResumeButton = false;
            playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));
        }
    }

    // Método para desativar a reptição da música
    private void inactiveRepeatSong() {
        repeatSameSong = false;
        MusicPlayerControl.repeatSong(repeatSameSong);
    }

    // Método para repetir a música tocando
    public void repeatSong() {
        if (musicList.size() > 0) {
            repeatSameSong = !repeatSameSong;
            MusicPlayerControl.repeatSong(repeatSameSong);
            if (repeatSameSong) {
                repeatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repeatActive.png")));
            } else {
                repeatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repeat.png")));
            }
        }
    }

    // Método para embaralhar a lista de músicas
    public void shuffle() {
        if (musicList.size() > 0) {
            musicList.shuffle();

            MusicPlayerControl.updateOrderInPlayerList();

            clearQueue();

            insertSongsIntoQueue();

            playerListSongs = musicList.getPlayerList();

            for (JMusicSong s : playerListSongs) {
                for (Track t : trackDAO.getByInfo(s.getSongName(), s.getAlbum(), s.getArtist())) {
                    songIDs.add(t.getId());
                }
            }

            MusicPlayerControl.updateSelectedSongInList();

            selectedIndex = listQueue.getSelectedIndex();
        }
    }
}
