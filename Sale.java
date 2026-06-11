
/**
 * 판매 정보 저장 및 출력 위한 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.12)
 */
public class Sale
{
    static Sale[] saleDB = new Sale[100];
    static int dbCount = 0;
    
    String[] names = new String[10];
    int[] orig = new int[10], taxed = new int[10], qtys = new int[10];
    int count = 0; 

    /**
     * 거래에 상품 한 종류를 추가한다.
     * 추가 성공 시 true, 배열이 가득 차면 false 
     */
    public boolean addItem(String productName, int originalPrice, int taxedPrice, int quantity){
        try{
            names[count] = productName;
            orig[count] = originalPrice;
            taxed[count] = taxedPrice;
            qtys[count] = quantity;
            count++;
            return true;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("* 한 거래에는 상품을 최대 10종류까지만 담을 수 있습니다.");
            return false;
        }
    }
    
    /**
     * 현재 거래를 거래내역 DB에 저장한다.
     */
    public void save(){ 
        try{
            saleDB[dbCount] = this;
            dbCount++;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("* 거래내역 저장 공간(100건)이 가득 찼습니다.");
        }
    }
    
    /**
     * 총 결제금액을 계산한다.
     */
    public int getTotal() { 
        int total = 0;
        for (int i = 0; i < count; i++){
            total += orig[i] * qtys[i];
        }
        return total;
    }

    /**
     * 영수증을 출력한다. (상품 목록, 과세물품가액, 부가세, 거스름돈)
     */
    public void print(int cash) {
        System.out.println("      ---- 선문편의점 ----");
        System.out.println("================================");

        int totalOrig = 0;
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + "  " + qtys[i] + "  " + (orig[i]*qtys[i]) + "원");
            totalOrig += (orig[i] - taxed[i])* qtys[i];
        }
        
        int vat = getTotal() - totalOrig;

        System.out.println("================================");
        System.out.println("총 구 매 액    " + count + "   " + getTotal() + "원");
        System.out.println("--------------------------------");
        System.out.println("과세물품가액       " + totalOrig + "원");
        System.out.println("부  가  세        " + vat + "원");
        System.out.println("--------------------------------");
        System.out.println("* 결 제 금 액      " + getTotal() + "원");
        System.out.println("  현      금      " + cash + "원");
        System.out.println("  거  스  름  돈   " + (cash - getTotal()) + "원");
        System.out.println("--------------------------------");
    }
}