package blackjackV2;

public enum inputType {
    CARD("카드를 더 받겠습니까? (Y / N) "),
    GAME("한 게임 더 하시겠습니까? (Y / N) "),
    BET("얼마를 거시겠습니까? ");

    private String str;
    inputType(String str) {
        this.str = str;
    }
    public String getStr() {
        return str;
    }
}
