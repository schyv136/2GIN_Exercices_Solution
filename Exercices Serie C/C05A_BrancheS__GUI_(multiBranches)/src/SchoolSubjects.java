
import java.util.ArrayList;

/**
 * @author fred
 */
public class SchoolSubjects {
    private ArrayList<SchoolSubject> schoolSubjects = new ArrayList<>();

    public int size() {
        return schoolSubjects.size();
    }

    public Object[] toArray() {
        return schoolSubjects.toArray();
    }

    public SchoolSubject get(int index) {
        return schoolSubjects.get(index);
    }

    public boolean add(SchoolSubject e) {
        return schoolSubjects.add(e);
    }

    public SchoolSubject remove(int index) {
        return schoolSubjects.remove(index);
    }

    public void clear() {
        schoolSubjects.clear();
    }

    
    
    
}
