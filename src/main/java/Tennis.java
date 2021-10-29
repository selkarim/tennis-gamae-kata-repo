import java.util.HashMap;

public class Tennis {

    private int playerOneScoreTimes;
    private int playerTwoScoreTimes;
    private final String playerOneName;
    private final String playerTwoName;

    final HashMap<Integer, String> LOOKUP_SCORE = new HashMap<>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    public Tennis(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {

        if (playerOneScoreTimes != playerTwoScoreTimes) {
            if (playerOneScoreTimes > 3 || playerTwoScoreTimes > 3) {
                if (Math.abs(playerOneScoreTimes - playerTwoScoreTimes) == 1) {
                    return getadvantagedPlayer() + " Advantage";
                }
            }
            return String.format("%s %s", LOOKUP_SCORE.get(playerOneScoreTimes), LOOKUP_SCORE.get(playerTwoScoreTimes));

        }

        if (playerOneScoreTimes >= 3)
            return "Deuce";
        return String.format("%s All", LOOKUP_SCORE.get(playerOneScoreTimes));

    }

    public void playerOneScored() {
        playerOneScoreTimes++;
    }

    public void playerTwoScored() {
        playerTwoScoreTimes++;
    }

    public String getadvantagedPlayer() {
        return playerOneScoreTimes > playerTwoScoreTimes ? playerOneName : playerTwoName;
    }
}
