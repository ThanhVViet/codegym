package ss8_refactoring.ex;

public class Refactoring {
    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String[] scoreLabels = {"Love", "Fifteen", "Thirty", "Forty"};
        String score = "";

        if (m_score1 == m_score2) {
            if (m_score1 >= 3) {
                score = "Deuce";
            } else {
                score = scoreLabels[m_score1] + "-All";
            }
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (Math.abs(minusResult) == 1) {
                String leadingPlayer = (minusResult == 1) ? player1Name : player2Name;
                score = "Advantage " + leadingPlayer;
            } else {
                String winningPlayer = (minusResult > 1) ? player1Name : player2Name;
                score = "Win for " + winningPlayer;
            }
        } else {
            score = scoreLabels[m_score1] + "-" + scoreLabels[m_score2];
        }

        return score;
    }

}

