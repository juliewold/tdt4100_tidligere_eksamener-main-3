package del1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class VoterCounterTest {
	
	private VoterCounter counter;
	final String CANDIDATE_1 = "Candidate1";
	final String CANDIDATE_2 = "Candidate2";
	final String CANDIDATE_3 = "Candidate3";
	
	@BeforeEach
	public void setup() {
		counter = new VoterCounter();
		counter.addCandidate(CANDIDATE_1);
		counter.addCandidate(CANDIDATE_2);
		counter.addCandidate(CANDIDATE_3);

	}
	
	private boolean matchAll(String source, String...strings) {
		for (String string : strings) {
			if (!source.contains(string)) {
				return false;
			}
		}
		return true;
	}

	
	@Test
	public void testAddCandidate() {
		Assertions.assertEquals(0, counter.getNumberOfVotes(CANDIDATE_1));
	}
	
	@Test
	public void testNotRegisteredCandidateHasNullVotes() {
		Assertions.assertNull(counter.getNumberOfVotes("test"));
	}
	
	@Test
	public void testCastVote() {
		counter.castVote(CANDIDATE_1);
		counter.castVote(CANDIDATE_2);
		counter.castVote(CANDIDATE_1);
		Assertions.assertEquals(2, counter.getNumberOfVotes(CANDIDATE_1));
		Assertions.assertEquals(1, counter.getNumberOfVotes(CANDIDATE_2));
	}
	
	@Test
	public void testCastVoteThrowsWhenInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> counter.castVote("invalid"));
	}
	
	@Test
	public void testGetWinnerWhenNoCandidates() {
		Assertions.assertNull(new VoterCounter().getWinner());
	}
	
	@Test
	public void testGetWinner() {
		counter.castVote(CANDIDATE_1);
		counter.castVote(CANDIDATE_2);
		counter.castVote(CANDIDATE_1);
		Assertions.assertEquals(CANDIDATE_1, counter.getWinner());
	}
	
	@Test
	public void testGetTieResult() {
		counter.castVote(CANDIDATE_1);
		counter.castVote(CANDIDATE_2);
		counter.castVote(CANDIDATE_1);
		counter.castVote(CANDIDATE_2);
		counter.castVote(CANDIDATE_3);

		Assertions.assertEquals(VoterCounter.TIE_RESULT, counter.getWinner());
	}
	
	@Test
	public void testGetFormattedResultsContainsAllCandidates() {
		Assertions.assertTrue(matchAll(counter.getFormattedResults(), CANDIDATE_1, CANDIDATE_2, CANDIDATE_3));
	}
	
	@Test
	public void testGetResultsNoVotes() {
		String expectedCandidate1Result = CANDIDATE_1 + "-" + "0";
		String expectedCandidate2Result = CANDIDATE_2 + "-" + "0";
		String expectedCandidate3Result = CANDIDATE_3 + "-" + "0";
		Assertions.assertTrue(matchAll(counter.getFormattedResults(), expectedCandidate1Result, expectedCandidate2Result, expectedCandidate3Result));
	}
	
	@Test
	public void testGetResultsWithVotes() {
		counter.castVote(CANDIDATE_1);
		counter.castVote(CANDIDATE_2);
		counter.castVote(CANDIDATE_1);
		counter.castVote(CANDIDATE_2);
		counter.castVote(CANDIDATE_3);
		String expectedCandidate1Result = CANDIDATE_1 + "-" + "2";
		String expectedCandidate2Result = CANDIDATE_2 + "-" + "2";
		String expectedCandidate3Result = CANDIDATE_3 + "-" + "1";
		Assertions.assertTrue(matchAll(counter.getFormattedResults(), expectedCandidate1Result, expectedCandidate2Result, expectedCandidate3Result));
	}
	

}
