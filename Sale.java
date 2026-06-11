
/**
 * 판매 정보 저장 및 출력 위한 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.09)
 */
public class Sale
{
    static Sale[] saleDB = new Sale[100]; // 거래내역 DB
    static int dbCount = 0;

    String[] names = new String[10];
    int[] orig = new int[10], taxed = new int[10], qtys = new int[10];
    int count = 0; // 현재 담긴 상품 수

    // 상품 추가 메소드
    // n: 상품명, o: 세전단가, t: 세후단가, q: 수량, a: 주류여부
    public boolean addItem(String n, int o, int t, int q, boolean a){
        names[count] = n;
        orig[count] = o;
        taxed[count] = t;
        qtys[count] = q;
        count++;
        return true;
    }

    public void save(){ //거래수 저장
        saleDB[dbCount] = this;
        dbCount++;
    }
    // 총 결제금액 계산 : 세후단가 * 수량의 합계 
    public int getTotal() { 
        int total = 0;
        for (int i = 0; i < count; i++){
            total += orig[i] * qtys[i];
        }
        return total;
    }

    // 영수증 출력 메소드
    // cash: 손님에게 받은 현금
    public void print(int cash) {
        System.out.println("      ---- 선문편의점 ----");
        System.out.println("================================");

        // 상품 목록 + 과세물품가액(세전 합계) 누적
        int totalOrig = 0;
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + "  " + qtys[i] + "  " + (orig[i]*qtys[i]) + "원");
            totalOrig += (orig[i] - taxed[i])* qtys[i];
        }
        
        // 부가세 = 결제금액 - 과세물품가액 (주류세 + 부가세 합산) 
        int vat = getTotal() - totalOrig;

        System.out.println("================================");
        System.out.println("총 구매액    " + count + "  " + getTotal() + "원");
        System.out.println("--------------------------------");
        System.out.println("과세물품가액  " + totalOrig + "원");
        System.out.println("부가세       " + vat + "원");
        System.out.println("--------------------------------");
        System.out.println("결제 금액    " + getTotal() + "원");
        System.out.println("현금        " + cash + "원");
        System.out.println("거스름돈     " + (cash - getTotal()) + "원");
        System.out.println("--------------------------------");
    }
}