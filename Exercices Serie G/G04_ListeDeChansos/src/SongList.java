
import java.util.ArrayList;

public class SongList {
    
    protected ArrayList<Song> alSongs = new ArrayList<>();
    
    public int calculateDuration(){
        int duration = 0;
        
        for(int i = 0; i < alSongs.size(); i++){
            duration += alSongs.get(i).getDuration();
        }
        
        return duration;
    }
    
    public Song get(int index){
        return alSongs.get(index);
    }
    
    public boolean add(Song pSong){
        
        alSongs.add(pSong);
        return true;
        
    }
    
    public void remove(int index){
        alSongs.remove(index);
    }
    
    public int size(){
        return alSongs.size();
    }
    
    public Object[] toArray(){
        return alSongs.toArray();
    }
    
}
