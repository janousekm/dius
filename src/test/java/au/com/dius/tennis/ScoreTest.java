package au.com.dius.tennis;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {

	@Test
	public void addPoint() {
		assertEquals(Score.THIRTY, Score.FIFTEEN.addPoint());
		assertEquals(Score.FORTY, Score.FORTY.addPoint());
	}

	@Test
	public void isMax() {
		Assert.assertTrue(Score.FORTY.isMax());
		Assert.assertFalse(Score.FIFTEEN.isMax());
	}

	@Test
	public void getPointDiff() {
		assertEquals(2, Score.THIRTY.getPointDiff(Score.ZERO));
		assertEquals(1, Score.THIRTY.getPointDiff(Score.FORTY));
		assertEquals(0, Score.THIRTY.getPointDiff(Score.THIRTY));
	}
}