public class Candidate {
    private String name;
    private int id;

    public Candidate(String name) {
        this.name = name;
        this.id = name.equals("Candidate 1") ? 1 : 2; 
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
