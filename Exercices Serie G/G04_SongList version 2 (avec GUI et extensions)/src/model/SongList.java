package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Cette classe représente une liste de chanson. 
 * Elle ne peut contenir deux fois
 * la même chanson.
 *
 * @author Fred Faber
 * @version 29/1/2014
 */
public class SongList {

    private ArrayList<Song> alSongs = new ArrayList<>();

    public int calculateDuration() {
        int total = 0;
        for (int i = 0; i < alSongs.size(); i++) {
            total = total + alSongs.get(i).getDuration();
        }
        return total;
    }

    public boolean add(Song pSong) {
        if (!alSongs.contains(pSong)) {
            return alSongs.add(pSong);
        } else {
            return false;
        }
    }

    public Song get(int index) {
        return alSongs.get(index);
    }

    public Song findLongestSong() { //not used
        Song result = null;
        if (alSongs.size() > 0) {
            result = alSongs.get(0);
            for (int i = 0; i < alSongs.size(); i++) {
                Song song = alSongs.get(i);
                if (song.getDuration() > result.getDuration()) {
                    result = alSongs.get(i);
                }
            }
        }
        return result;
    }

    public int findIndexOfLongestSong() {
        int result = -1;
        if (alSongs.size() > 0) {
            result = 0;
            for (int i = 0; i < alSongs.size(); i++) {
                Song song = alSongs.get(i);
                if (song.getDuration() > alSongs.get(result).getDuration()) {
                    result = i;
                }
            }
        }
        return result;
    }

    public void sort() {
        for (int i = 0; i < alSongs.size() - 1; i++) {
            int indexOfMinimum = i;
            for (int j = i; j < alSongs.size(); j++) {
                String songJ = alSongs.get(j).getArtist() + alSongs.get(j).getTitle();
                String songMin = alSongs.get(indexOfMinimum).getArtist() + alSongs.get(indexOfMinimum).getTitle();
                if (songJ.compareTo(songMin) < 0) {
                    indexOfMinimum = j;
                }
            }
            Song help = alSongs.get(i);
            alSongs.set(i, alSongs.get(indexOfMinimum));
            alSongs.set(indexOfMinimum, help);
        }
    }

    public Cd compileCd(String artist, int capacity) {
        Cd cd = new Cd(capacity);
        for (int i = 0; i < alSongs.size(); i++) {
            Song song = alSongs.get(i);
            if (artist.equals(song.getArtist())
                    && song.getDuration() <= cd.getFreeCapacity()) //optional because also checked inside add method
            {
                cd.add(song);
            }
        }
        return cd;
    }

    public Object[] toArray() {
        return alSongs.toArray();
    }

    //============================= version deluxe ================================
    
    public void saveToTextFile(String fileName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < alSongs.size(); i++) {
                Song song = alSongs.get(i);
                out.println(song.getArtist() + ":" + song.getTitle() + ":" + song.getDuration());
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void loadFromTextFile(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            alSongs.clear();
            String line;
            while ((line = in.readLine()) != null) {
                String[] strings = line.split(":");
                Song song = new Song(strings[0], strings[1], Integer.valueOf(strings[2]));
                add(song);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
