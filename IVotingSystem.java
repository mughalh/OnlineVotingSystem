public interface IVotingSystem {
    void addCandidate(String name);
    void startElection();
    void stopElection();
    void castVote(String voterId, String candidateName);
    void displayResults();
}
