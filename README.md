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
