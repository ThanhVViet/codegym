import java.util.Scanner;

public class Q_or_q {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are playing a game! Press q or Q to quit");
        String response = scanner.next();

        if (!response.equals("q") && !response.equals("Q")) {
            System.out.println("YOu are still playing the game *pew pew*");
        } else {
            System.out.println("You quit the game");
        }
    }
}
