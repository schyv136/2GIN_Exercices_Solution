public class Cd extends SongList{
    
    private int capacity;
    
    public Cd(int capacity){
        this.capacity = capacity;
    }
    
    public void Cd(int seconds){
        capacity = seconds;
    }
    
    public void Cd(double minutes){
        capacity = (int)minutes*60;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getFreeCapacity(){
        return capacity - calculateDuration();
    }

    public void clearCd(){
        super.alSongs.clear();
    }
    
    @Override
    public boolean add(Song pSong){
        boolean result = false;
        
        if(pSong.getDuration() <= getFreeCapacity()){
            super.add(pSong);
            result = true;
        }else{
            result = false;
        }
        
        return result;
    }
    
}
