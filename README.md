# blackjack
## v1
### 메서드 설명
- void **winDrawLose**(int[] record, int myCard, int dealerCard) : 승/무/패를 판단하고 전적을 int[] 값에 저장. 무가 1이 넘지 않을 경우 무 전적은 출력하지 않음.
- String **printCards**(List<Integer> cards) : 배열을 형식에 맞게 String 타입으로 반환.
- int **oneMoreGame**(Scanner sc) : 한 게임 더 할지 여부 체크, 잘못 입력한 경우 재귀호출로 해당 메서드 반복.

### 풀이
1. 승/무/패를 저장할 int 배열, 나와 딜러의 카드를 저장할 각각의 List<Integer> 생성.
2. Math.randon() 함수로 나와 딜러의 카드 숫자를 할당하고 List에 저장.
3. **winDrawLose** 메서드 통해 승/무/패 판단 및 전적 저장/출력.
4. **oneMoreGame** 메서드로 추가 게임 여부 입력 받고 while문을 나올지 반복할지 결정.

### 실행결과
- 뽑은 카드가 형식에 맞게 누적되어 출력.
- 카드패에 따른 승/무/패를 저장하며 전적을 출력.
- 추가 게임 진행 여부에 따라 프로그램 종료.

## v2
### 클래스 설명
- class **wdlMsgAndPrice** : 승/무/패 시 출력될 문구와 그에 따른 증감 금액을 저장하는 클래스.
- enum **inpuType** : 입력 값을 받기 전 띄울 출력 메세지를 저장.(카드를 더 받을지, 한 게임 더 할지, 얼마를 걸지)

### 메서드 설명
- void **playGame**(blackjackV2 v2) : 게임 진행 메서드.
- List<Integer> **createDeck**() : 덱 생성. 1~10 4장 11 12장 배열을 섞어서 반환.
- void **selectCard**(List<Integer> cards) : 덱에서 매개변수(나, 딜러)의 카드패에 한 장을 추가하고, 해당 카드는 덱에서 제거.
- void **printCards**(String str, List<Integer> cards) : 카드패를 형식에 맞게 출력.
- int **getSum**(List<Integer> myCards) : 카드패의 총합 반환.
- int **msgAndInput**(inputType type) : 입력 받기전 메세지 출력 후 받은 입력 값에 따른 값 반환. HashMap의 키 값으로 y, n, codesquad 등록하여 if문을 줄임.
- void **cheat**(List<Integer> deck) : 치트(카드 6장 출력).
- void **winDrawLose**(int mySum, int dealerSum) : 승/무/패를 판단하고 그에 따른 메세지와 자산, 전적 변경.<br/>HashMap의 value 값을 메세지(String)과 배팅에 따른 금액(int) 변수를 가진 클래스 **wdlMsgAndPrice**로 설정.

### 풀이
1. 외부 do-while을 통하여 사용자의 자산이 0원이 되거나 사용자가 게임을 그만하기 전까지 게임 반복.<br/>덱이 10장 이하면 새로운 덱을 생성.
2. 사용자와 딜러의 카드패를 초기화하고 현재 자산 출력 및 배팅 금액 입력(**msgAndInput(inputType.BET)**).
3. 내부 do-while을 통해 사용자의 카드패 총합이 21을 초과하거나, 사용자가 그만 받기를 원하기 전까지 카드를 받고(**selectCard**) 총합을 출력(**printCards**).<br/>21 초과시 패배 메세지와 패배 기록.
4. 사용자가 카드를 그만 받기로 하면 승/무/패를 판단, 전적과 자산에 반영(**windDrawLose**)

### 실행결과
- 게임을 그만두기 전까지 **playGame** 메서드 동작.
- 한 게임 더 할지, 카드를 더 받을지 메세지 출력 후 입력받을 때 치트를 사용하면 카드 6장을 출력하고 다시 메세지를 띄움.
- 자산이 0원이 되거나, 게임을 그만두면 총 전적과 함께 남은 자산 출력 후 프로그램 종료.
