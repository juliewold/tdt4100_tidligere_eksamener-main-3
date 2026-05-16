package part1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketballComparatorsTest {

	private Comparator<Player> heightComparator;
	private Comparator<Player> trueShootingPercentageComparatorComparator;

	private Player player1, player2, player3;

	@BeforeEach
	void setUp() throws Exception {
		heightComparator = BasketballComparators.getHeightComparator();
		trueShootingPercentageComparatorComparator = BasketballComparators.getTrueShootingPercentageComparator();

		final List<PlayerGameStat> stats1 = List.of(
				new PlayerGameStat(38, 20, 5), // TS% = 0.8559 = 85.59%
				new PlayerGameStat(3, 1, 0) // TS% = 1.5 = 150%
				);
		final List<PlayerGameStat> stats2 = List.of(
				new PlayerGameStat(38, 20, 5), // TS% = 0.8559 = 85.59%
				new PlayerGameStat(4, 1, 0) // TS% = 2.0 = 200%
				);

		player1 = new Player("Joe", 220, stats1);
		player2 = new Player("Joe2", 205, stats1);
		player3 = new Player("John", 210, stats2);
	}

	@Test
	void testHeightComparator() {
		assertTrue(heightComparator.compare(player1, player2) < 0);
		assertTrue(heightComparator.compare(player1, player3) < 0);
		assertTrue(heightComparator.compare(player3, player2) < 0);
	}

	@Test
	void testTrueShootingPercentageComparator() {
		assertTrue(trueShootingPercentageComparatorComparator.compare(player3, player1) < 0);
		assertTrue(trueShootingPercentageComparatorComparator.compare(player3, player2) < 0);
	}

	@Test
	void testTrueShootingPercentageComparator_sameTS() {
		assertTrue(trueShootingPercentageComparatorComparator.compare(player1, player2) < 0);
		assertTrue(trueShootingPercentageComparatorComparator.compare(player2, player1) > 0);
	}

	@Test
	void testTrueShootingPercentageComparator_same() {
		assertTrue(trueShootingPercentageComparatorComparator.compare(player1, player1) == 0);
		assertTrue(trueShootingPercentageComparatorComparator.compare(player2, player2) == 0);
		assertTrue(trueShootingPercentageComparatorComparator.compare(player3, player3) == 0);
	}
}
