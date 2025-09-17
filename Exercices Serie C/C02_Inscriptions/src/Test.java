
public class Test {

    public static void main(String[] args) {
        Participant josy = new Participant("Josy", "Muller", 1980);
        Participant poli = new Participant("Poli", "Klein", 1985);
        Participant mary = new Participant("Mary", "Nemo", 1978);
        Participants participants = new Participants();
        participants.add(josy);
        participants.add(poli);
        participants.add(mary);

        for (int i = 0; i < participants.size(); i++) {
            System.out.println(participants.get(i));
        }

        System.out.println("------------------");
        participants.remove(0);

        for (int i = 0; i < participants.size(); i++) {
            System.out.println(participants.get(i));
        }
    }
}
