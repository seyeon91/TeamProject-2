
/**
 * 판매 정보 저장및 출력 위한 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.09)
 */
public class Sale
{
    String[] names = new String[10]; // 상품명 배열
    int[] orig = new int[10]; // 세전 단가 배열
    int[] taxed = new int[10]; // 세후 단가 배열
    int[] qtys = new int[10]; // 수량 배열
    boolean[] alcohol = new boolean[10]; // 주류 여부 배열 (true: 주류, false: 음료수)
    int count = 0; // 현재 담긴 상품 수

    // 상품 추가 메소드
    // n: 상품명, o: 세전단가, t: 세후단가, q: 수량, a: 주류여부
    public void addItem(String n, int o, int t, int q, boolean a){
        names[count] = n;
        orig[count] = o;
        taxed[count] = t;
        qtys[count] = q;
        alcohol[count] = a;
        count++;
    }
    
    // 총 결제금액 계산 : 세후단가 * 수량의 합계 
    public int getTotal() { 
        int total = 0;
        for (int i = 0; i < count; i++){
            total += taxed[i] * qtys[i];
        }
        return total;
    }