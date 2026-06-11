
/**
 * 판매 정보 저장 및 출력 위한 클래스
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
    
    // 영수증 출력 메소드
    // cash: 손님에게 받은 현금
    public void print(int cash) {
        System.out.println("---- 선문편의점 ----");
        System.out.println("--------------------------------");
        
        // 담은 상품 목록 출력
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + "  " + qtys[i] + "  " + (taxed[i]*qtys[i]) + "원");
            if (alcohol[i]){
                System.out.println("  * 부가세(10%) + 주세(30%) 포함");
            }
            else{
                System.out.println("  * 부가세(10%) 포함");
            }
        }
        
        // 과세물품가액(세전 합계)과 세액(세금 합계) 계산
        int totalOrig = 0, totalTax = 0;
        for (int i =0; i < count; i++) {
            totalOrig += orig[i] * qtys[i];             // 세전 합계
            totalTax += (taxed[i] - orig[i]) * qtys[i]; // 세금 합계
        }
        
        System.out.println("--------------------------------");
        System.out.println("총 구매액    " + count + "  " + getTotal() + "원");
        System.out.println("--------------------------------");
        System.out.println("과세물품가액  " + totalOrig + "원");
        System.out.println("부가세       " + totalTax + "원");
        System.out.println("--------------------------------");
        System.out.println("결제 금액    " + getTotal() + "원");
        System.out.println("현금        " + cash + "원");
        System.out.println("거스름돈     " + (cash - getTotal()) + "원");
        System.out.println("--------------------------------");
    }
}