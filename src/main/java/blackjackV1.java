import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class blackjackV1 {
    public static void main(String[] args) throws Exception{
        blackjackV1 v1 = new blackjackV1();
        int[] record = {0, 0, 0};
        List<Integer> myCards = new ArrayList<>();
        List<Integer> dealerCards = new ArrayList<>();
        System.out.println("간단 카드 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);
        int game = 1;
        while (true) {
            int myCard = (int)(Math.random() * 11) + 1;
            int dealerCard = (int)(Math.random() * 11) + 1;
            myCards.add(myCard);
            dealerCards.add(dealerCard);
            System.out.println("\nGame " + game++);
            System.out.println("You   :" + v1.printCards(myCards));
            System.out.println("Dealer:" + v1.printCards(dealerCards));
            v1.winDrawLose(record, myCard, dealerCard);
            if (v1.oneMoreGame(sc) == 1) continue;
            else {
                System.out.println("게임을 종료합니다.\n플레이해주셔서 감사합니다.");
                break;}}
    }

    private void winDrawLose(int[] record, int myCard, int dealerCard) {
        if (myCard > dealerCard) {
            record[0]++;
            System.out.println("당신이 이겼습니다.");
        } else if (myCard < dealerCard) {
            record[1]++;
            System.out.println("딜러가 이겼습니다.");
        } else {
            record[2]++;
            System.out.println("비겼습니다.");
        }
        if (record[2] >= 1) {
            System.out.println("현재 전적: " + record[0] + "승 " + record[2] + "무 " + record[1] + "패");
        } else {
            System.out.println("현재 전적: " + record[0] + "승 " + record[1] + "패");
        }
    }

    public String printCards(List<Integer> cards) {
        StringBuilder sb = new StringBuilder();
        for (Integer card : cards) {
            sb.append(" [");
            if (card >= 10) {
                sb.append(card);
            } else sb.append(" ").append(card);
            sb.append("]");
        }
        return sb.toString();
    }

    public int oneMoreGame(Scanner sc) throws Exception{
        String s;
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
        if ((s = sc.nextLine().toLowerCase()).equals("y")) {
            return 1;
        } else if (s.equals("n")) {
            return -1;
        } else {
            System.out.println("잘못 입력하셨습니다.");
            return oneMoreGame(sc);
        }
    }
}
