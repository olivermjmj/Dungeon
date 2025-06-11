package com.nation.dungeon.util;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

    private MediaPlayer musicPlayer;

    public void playSound(String filePath) {
        try {
            Media sound = new Media(filePath);
            MediaPlayer effectPlayer = new MediaPlayer(sound);
            effectPlayer.play();
            effectPlayer.setOnEndOfMedia(effectPlayer::dispose);
        } catch(Exception e) {
            System.out.println("Error, could not play the sound effect from file path: " + e.getMessage());
        }
    }

    public void playMusic(String filePath) {

        if(this.musicPlayer != null) {
            this.musicPlayer.stop();
        }

        try {
            Media music = new Media(filePath);
            this.musicPlayer = new MediaPlayer(music);
            this.musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            this.musicPlayer.play();
        } catch (Exception e) {
            System.out.println("Error, could not play the music from file path: " + e.getMessage());
        }
    }

    public void stopMusic() {
        if(this.musicPlayer != null) {
            this.musicPlayer.stop();
        }
    }

}
