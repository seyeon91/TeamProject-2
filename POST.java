 
/**
 * 상품 목록 저장, 바코드 인식 기능, 결제처리 기능을 하는 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.12)
 */
import java.util.Scanner;

public class POST {
    Products[] db = new Products [6]; 
    Sale sale = new Sale();    
    Sale[] saleDB = new Sale[100];
    int dbCount = 0;

    /**
     * 계산대(POST) 객체를 생성한다.
     * 상품 DB를 초기화하고 상품 목록을 출력한다.
     */
    public POST() {
        String[] barcodes = {
                "8801094018702", "8801056251727", "8801056000332",
                "8801070004432", "8801080609322", "8801090000441"
            };
        String[] names = {
                "코카콜라 250ml", "칠성사이다 제로라임 500ml", "제주사랑 감귤사랑 1.5L",
                "카스캔 740ml", "참이슬후레쉬 360ml", "장수생막걸리 750ml"
            };
        int[] prices = {1700,2300,3800,4500,1900,1430};
        
        for (int i = 0; i< 6; i++){
            if(i < 3){
                db[i] = new Beverages(barcodes[i], names[i], prices[i]);
            }
            else{
                db[i] = new AlcoholicDrinks(barcodes[i], names[i], prices[i]);
            }
        }

        System.out.println("====== 상품 목록 ======");
        for (int i = 0; i < db.length; i++){
            System.out.println("[" + db[i].barcode + "]" + db[i].name + " : " +db[i].price + "원");
        }
        System.out.println("=====================");
    }

    /**
     * 바코드로 상품을 검색해 거래(Sale)에 추가한다.
     * 
     * @param barcode 입력된 바코드
     * @param qty 수량
     * @return 상품을 찾으면 true, 없으면 false
     */
    public boolean scan(String barcode, int qty){
        for(int i = 0; i< db.length; i++){
            if(db[i].barcode.equals(barcode)){
                TAX item = (TAX) db[i];
                if(sale.addItem(db[i].name, db[i].price, item.calcTax(), qty)){
                    System.out.println(db[i].name + " x" + qty + " 추가됨");
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * 현재 거래를 거래내역 DB에 저장한다.
     */
    public void save(){
        try{
            saleDB[dbCount] = sale;
            dbCount++;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("* 거래내역 저장 공간(100건)이 가득 찼습니다.");
        }
    }
    
    /**
     * 결제를 처리한다.
     * 합계 출력 >> 현금 입력 >> 현금 부족 확인 >> 영수증 출력
     * 
     * @param scan 현금 입력을 받을 Scanner
     */
    public void pay(Scanner scan){
        System.out.println("합계 : " + sale.getTotal() + "원");
        System.out.println("받은 현금 : ");
        int cash = scan.nextInt();
        if (cash < sale.getTotal()){
            System.out.println("현금 부족! 취소");
            return;
        }
        sale.print(cash);
        save();
    }
}    