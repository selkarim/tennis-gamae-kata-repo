import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

//@RunWith(Parameterized.class)
public class TennisTest {
    private final Tennis tennis = new Tennis("djokovic", "Nadal");
    /*@Parameterized.Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },
                { 1, 1, "Fifteen-All" },
                { 2, 2, "Thirty-All"},
                { 3, 3, "Deuce"},
                { 4, 4, "Deuce"},

                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                { 0, 3, "Love-Forty"},
                { 4, 0, "Win for player1"},
                { 0, 4, "Win for player2"},

                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, "Win for player1"},
                { 1, 4, "Win for player2"},

                { 3, 2, "Forty-Thirty"},
                { 2, 3, "Thirty-Forty"},
                { 4, 2, "Win for player1"},
                { 2, 4, "Win for player2"},

                { 4, 3, "Advantage player1"},
                { 3, 4, "Advantage player2"},
                { 5, 4, "Advantage player1"},
                { 4, 5, "Advantage player2"},
                { 15, 14, "Advantage player1"},
                { 14, 15, "Advantage player2"},

                { 6, 4, "Win for player1"},
                { 4, 6, "Win for player2"},
                { 16, 14, "Win for player1"},
                { 14, 16, "Win for player2"},
        });
    }*/

    @Test
    public void shouldReturnLoveAll() {
        scoreShouldBe("Love All");
    }

    @Test
    public void shouldReturnFifteenLove() {
        getPlayerOneScoreTimes(1);
        scoreShouldBe("Fifteen Love");
    }

    @Test
    public void shouldReturnThirtyLove() {
        getPlayerOneScoreTimes(2);
        scoreShouldBe("Thirty Love");
    }

    @Test
    public void shouldReturnFortyLove() {
        getPlayerOneScoreTimes(3);
        scoreShouldBe("Forty Love");
    }

    @Test
    public void shouldReturnPlayerOneAdvantage() {
        givenDeuce();
        getPlayerOneScoreTimes(1);
        scoreShouldBe("djokovic Advantage");
    }

    @Test
    public void shouldReturnLoveFifteen() {
        getPlayerTwoScoreTimes(1);
        scoreShouldBe("Love Fifteen");
    }

    @Test
    public void shouldReturnLoveThirty() {
        getPlayerTwoScoreTimes(2);
        scoreShouldBe("Love Thirty");
    }

    @Test
    public void shouldReturnLoveForty() {
        getPlayerTwoScoreTimes(3);
        scoreShouldBe("Love Forty");
    }

    @Test
    public void shouldReturnPlayerTwoAdvantage() {
        givenDeuce();
        getPlayerTwoScoreTimes(1);
        scoreShouldBe("Nadal Advantage");
    }

    @Test
    public void shouldReturnFifteenAll() {
        getPlayerTwoScoreTimes(1);
        getPlayerOneScoreTimes(1);
        scoreShouldBe("Fifteen All");
    }

    @Test
    public void shouldReturnThirtyALL() {
        getPlayerTwoScoreTimes(2);
        getPlayerOneScoreTimes(2);
        scoreShouldBe("Thirty All");
    }

    @Test
    public void shouldReturnDeuce() {
        givenDeuce();
        scoreShouldBe("Deuce");
    }

    private void getPlayerOneScoreTimes(int scoreTimes) {
        for (int i = 0; i < scoreTimes; i++) {
            tennis.playerOneScored();
        }
    }

    private void getPlayerTwoScoreTimes(int scoreTimes) {
        for (int i = 0; i < scoreTimes; i++) {
            tennis.playerTwoScored();
        }
    }

    private void scoreShouldBe(String expectedScore) {
        Assertions.assertEquals(expectedScore, tennis.getScore());
    }

    private void givenDeuce() {
        getPlayerTwoScoreTimes(3);
        getPlayerOneScoreTimes(3);
    }

}

