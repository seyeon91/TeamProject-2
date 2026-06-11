
/**
 * 계산시 주류세를 적용하는 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.12)
 */
// 주류 클래스 : Products 상속, TAX 인터페이스 구현
public class AlcoholicDrinks extends Products implements TAX {
    
    public AlcoholicDrinks(String barcode, String name, int price){
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }
    // 부가세 10% + 주세 30% = 40% 적용 : 단가 * 1.4
    public int calTAX(){
        return (int)(price * 1.4);
    }
}