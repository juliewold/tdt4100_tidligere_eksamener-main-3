package del1;

import java.util.HashMap;
import java.util.Map;

public class VoterCounter {

	private Map<String, Integer> votes = new HashMap<>();
	public static final String TIE_RESULT = "TIE";

	/**
	 * Register a candidate to the poll
	 * 
	 * @param candidate the new candidate to add
	 */
	public void addCandidate(String candidate) {
		votes.put(candidate, 0);

	}

	/**
	 * Vote on a given candidate
	 * 
	 * @param candidate the candidate to vote on
	 * 
	 * @throws IllegalArgumentException if the candidate is not registered
	 */
	public void castVote(String candidate) {
		if (!this.votes.containsKey(candidate)) {
			throw new IllegalArgumentException();
		}
		votes.replace(candidate, votes.get(candidate) + 1);
	}

	/**
	 * Prints all the results in an arbitrary order. The results should be on the
	 * format {candidate name}-{number of votes for the candidate} with each
	 * candidate on a new line
	 */
	public String getFormattedResults() {
		String s = "";
		for (String candidate : votes.keySet()) {
			s += (candidate + "-" + votes.get(candidate)) + "\n";
		}
		return s;
	}

	/**
	 * Get's the number of votes a candidate has received
	 * 
	 * @param candidate the candidate to get number of votes for
	 * @return the number of votes the candidate has received. null if the candidate
	 *         is not registered
	 */

	public Integer getNumberOfVotes(String candidate) {
		return votes.getOrDefault(candidate, null);
	}

	/**
	 *
	 * @return the name of the candidate who won the election. If two or more
	 *         candidates got the same number of maximum votes, return the
	 *         TIE_RESULT field. Return null if there is no candidates.
	 */

	public String getWinner() {
		int maxValue = 0;
		String winner = null;
		for (String candidate : votes.keySet()) {
			if (votes.get(candidate) > maxValue) {
				winner = candidate;
				maxValue = votes.get(candidate);
			}
		}
		for (String candidate : votes.keySet()) {
			if (votes.get(candidate) == maxValue && !winner.equals(candidate)) {
				return TIE_RESULT;
			}
		}
		return winner;
	}

	public static void main(String[] args) {
		String candidate1 = "CANDIDATE1";
		String candidate2 = "CANDIDATE2";
		VoterCounter counter = new VoterCounter();
		counter.addCandidate(candidate1);
		counter.addCandidate(candidate2);
		// Should print 0
		System.out.println(counter.getNumberOfVotes(candidate1));
		counter.castVote(candidate1);
		// Should print 1;
		System.out.println(counter.getNumberOfVotes(candidate1));
		// Should print CANDIDATE 1
		System.out.println(counter.getWinner());
		counter.castVote(candidate2);
		// Should print TIE
		System.out.println(counter.getWinner());
	}
}
