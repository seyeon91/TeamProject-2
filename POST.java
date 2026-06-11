
/**
 * 상품 목록 저장, 바코드 인식 기능을 하는 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026. 06.11)
 */

public class POST{
    Products[] db = new Products [6]; //상품 DB 배열 
    Sale sale = new Sale();       //거래 정보 객체
    
    //생성자 : 상품 DB 초기화 및 목록 출력
    public POST() {
       String[] barcodes = {
            "8801094018702", "8801056251727", "8801056000332",
            "8801070004432", "8801080609322", "8801090000441"
        };
       String[] names = {
           "코카콜라 250ml", "칠성사이다 제로라임 500ml", "제주사랑 감귤사랑 1.5L",
           "카스캔 740ml", "참이슬후레쉬 360ml", "장수생막걸리 750ml"
       };
       int[] prices = {1700, 2300, 3800, 4500, 1900, 1430};
       
       for (int i = 0; i< 3; i++){
           db[i] = new Beverages(barcodes[i], names[i], prices[i]);
        }
       for (int i = 3; i < 6; i++){
           db[i] = new AlcoholicDrinks(barcodes[i], names[i], prices[i]);
        }
    
       System.out.println("====== 상품 목록 ======");
       for (int i = 0; i < db.length; i++){
            System.out.println("[" + db[i].barcode + "]" + db[i].name + " : " +db[i].price + "원");
        }
       System.out.println("=====================");
    }
}