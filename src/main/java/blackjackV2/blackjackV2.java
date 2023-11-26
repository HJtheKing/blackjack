package blackjackV2;

import java.util.*;

public class blackjackV2 {
    List<Integer> deck = createDeck();
    List<Integer> myCards = new ArrayList<>();
    List<Integer> dealerCards = new ArrayList<>();
    int[] record = {0, 0, 0};
    int money = 1000;
    int betting;
    int game = 1;
    public static void main(String[] args) throws Exception {
        blackjackV2 v2 = new blackjackV2();
        System.out.println("간단 카드 게임을 시작합니다.");
        v2.playGame(v2);
        System.out.println("\n" + v2.record[0] + "승 " + v2.record[1] + "무 " + v2.record[2] + "패로 " + v2.money + "원의 자산이 남았습니다.");
        System.out.println("플레이 해 주셔서 감사합니다.");
    }

    private void playGame(blackjackV2 v2) throws Exception {
        int dealerSum, mySum;
        do {
            if (deck.size() <= 10) deck = createDeck();
            v2.myCards.clear();
            v2.dealerCards.clear();
            System.out.println("현재 재산: " + v2.money);
            v2.betting = v2.yesOrNo(inputType.BET);
            System.out.println("\nGAME " + v2.game++);
            do {v2.selectCard(v2.myCards);
                v2.printCards("플레이어", v2.myCards);
                System.out.println("총합: " + (mySum = v2.getSum(v2.myCards)));
                if (mySum > 21) {
                    System.out.println("당신의 패배입니다. 현재 재산: " + (v2.money -= v2.betting));
                    v2.record[2]++;
                    break;}
                if (v2.getSum(v2.dealerCards) <= 16) v2.selectCard(v2.dealerCards);
            } while (v2.yesOrNo(inputType.CARD) == 1);
            if (mySum <= 21) {
                v2.printCards("딜러", v2.dealerCards);
                System.out.println("딜러의 카드 합계는 " + (dealerSum = v2.getSum(v2.dealerCards)) + "입니다.");
                v2.winDrawLose(mySum, dealerSum);}
        } while ((v2.money > 0) && (v2.yesOrNo(inputType.GAME) == 1));
    }

    private List<Integer> createDeck() {
        Integer[] arr = {
                1,2,3,4,5,6,7,8,9,10,
                1,2,3,4,5,6,7,8,9,10,
                1,2,3,4,5,6,7,8,9,10,
                1,2,3,4,5,6,7,8,9,10,
                11,11,11,11,11,11,11,11,11,11,11,11};
        List<Integer> deck = new ArrayList<Integer>(Arrays.asList(arr));
        Collections.shuffle(deck);
        return deck;
    }

    private void selectCard(List<Integer> cards) {
        Integer remove = deck.remove(deck.size() - 1);
        cards.add(remove);
    }

    private void printCards(String str, List<Integer> cards) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(": ");
        for (Integer card : cards) {
            sb.append("[")
                    .append(card < 10 ? " " + card : card)
                    .append("]");
        }
        System.out.println(sb);
    }

    private int getSum(List<Integer> myCards) {
        int sum = 0;
        for (Integer card : myCards) {
            sum += card;
        }
        return sum;
    }

    public int yesOrNo(inputType type) throws Exception{
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> typeMap = new HashMap<>();
        typeMap.put("y", 1);
        typeMap.put("n", 0);
        typeMap.put("codesquad", 9999);
        while (true) {
            System.out.print(type.getStr());
            String s = sc.nextLine();
            int i ;
            try {
                if (type == inputType.BET && ((i = Integer.parseInt(s)) % 100 == 0) && (i > 0) && (i <= money)) {
                    return i;
                }
                if (typeMap.get(s.toLowerCase()) == 9999) {
                    cheat(deck);
                    continue;
                }
                return typeMap.get(s.toLowerCase());
            } catch (Exception e) {System.out.println("잘못 입력하셨습니다.");}
        }
    }

    private void cheat(List<Integer> deck) {
        StringBuilder sb = new StringBuilder();
        sb.append("덱의 카드 ");
        for (int i = deck.size() - 1; i > deck.size() - 7; i--) {
            sb.append("[")
                    .append(deck.get(i) < 10 ? " " + deck.get(i) : deck.get(i))
                    .append("]");
        }
        System.out.println(sb);
    }

    private void winDrawLose(int mySum, int dealerSum) {
        int diff = mySum - dealerSum;
        HashMap<Integer, msgAndPrice> map = new HashMap<>();
        map.put(0, new msgAndPrice("승리", mySum == 21 ? betting * 2 : betting));
        map.put(1, new msgAndPrice("비김", 0));
        map.put(2, new msgAndPrice("패배", betting * -1));

        int i = (mySum == 21 || dealerSum > 21 || diff > 0) ? 0 : (diff == 0 ? 1 : 2);
        record[i]++;
        System.out.println(map.get(i).str);
        money += map.get(i).i;
        System.out.println("남은 자산: " + money);
    }
}

class msgAndPrice {
    String str;
    int i;

    public msgAndPrice(String str, int i) {
        this.str = str;
        this.i = i;
    }
}

