
/**
 * 계산시 부가세를 적용하는 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.09)
 */
// 음료수 클래스 : Products 상속, TAX 인터페이스 구현
public class Beverages extends Products implements TAX {
    
    public Beverages(String barcode, String name, int price){
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }
    //부가세 10% 적용 : 단가 * 0.1
    public int calcTax(){
        return (int)(price * 0.1);
    }

}