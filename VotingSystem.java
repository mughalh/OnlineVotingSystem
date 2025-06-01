import java.util.*;

public class VotingSystem implements IVotingSystem {
    private LinkedList<Voter> voters = new LinkedList<>();
    private LinkedList<Candidate> candidates = new LinkedList<>();
    private Stack<Vote> votingStack = new Stack<>();
    private Queue<Voter> votingQueue = new LinkedList<>();
    private LinkedList<Integer> voteTally = new LinkedList<>(Arrays.asList(0, 0));

    // Constructor
    public VotingSystem() {
    }

    @Override
    public void addCandidate(String name) {
        candidates.add(new Candidate(name));
    }

    @Override
    public void startElection() {
        System.out.println("Election has started!");
    }

    @Override
    public void stopElection() {
        System.out.println("Election has ended.");
    }

    @Override
    public void castVote(String voterId, String candidateName) {
        Voter voter = findVoterById(voterId);
        Candidate candidate = findCandidateByName(candidateName);

        if (voter != null && candidate != null) {
            Vote vote = new Vote(voter, candidate);
            votingStack.push(vote);
            votingQueue.offer(voter);
            System.out.println("Vote casted for " + candidate.getName());
        } else {
            System.out.println("Invalid Voter ID or Candidate Name.");
        }
    }

    @Override
    public void displayResults() {
        int candidate1Votes = (int) votingStack.stream().filter(v -> v.getCandidate().getName().equals("Candidate 1")).count();
        int candidate2Votes = (int) votingStack.stream().filter(v -> v.getCandidate().getName().equals("Candidate 2")).count();

        voteTally.set(0, candidate1Votes);
        voteTally.set(1, candidate2Votes);

        System.out.println("Votes for Candidate 1: " + voteTally.get(0));
        System.out.println("Votes for Candidate 2: " + voteTally.get(1));

        String winner = voteTally.get(0) > voteTally.get(1) ? "Candidate 1" : "Candidate 2";
        System.out.println("The winner is: " + winner);
    }

    private Voter findVoterById(String voterId) {
        return voters.stream().filter(v -> v.getId().equals(voterId)).findFirst().orElse(null);
    }

    private Candidate findCandidateByName(String name) {
        return candidates.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }
}
