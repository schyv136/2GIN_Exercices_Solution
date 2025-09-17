class Song {
    
    private int duration;
    private String artist;
    private String title;

    public Song(String artist, String title, int duration) {
        this.duration = duration;
        this.artist = artist;
        this.title = title;
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

    @Override
    public String toString() {
        return "[" + duration + "] " + artist + ": " + title;
    }
    
}
