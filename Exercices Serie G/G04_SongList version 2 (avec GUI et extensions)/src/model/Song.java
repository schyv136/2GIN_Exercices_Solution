package model;

import java.util.Objects;

/**
 * Cette classe représente une chanson.
 *
 * @author Fred Faber
 * @version 29/1/2014
 */
public class Song {

    /**
     * la durée de la chanson en secondes
     */
    private int duration;
    /**
     * le nom de l'interprète
     */
    private String artist;
    /**
     * le titre
     */
    private String title;

    public Song(String pArtist, String pTitle, int pDuration) {
        title = pTitle;
        artist = pArtist;
        duration = pDuration;
    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return artist + " - " + title + " (" + duration + ")";
    }
    
    //**** Advanced: **********************************************************************
    //If you want 'equals' and 'contains' to work correctly: override equals and hashcode!
    //This can be done simply with 'Insert Code'!
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.duration;
        hash = 83 * hash + Objects.hashCode(this.artist);
        hash = 83 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (this.duration != other.duration) {
            return false;
        }
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    
}