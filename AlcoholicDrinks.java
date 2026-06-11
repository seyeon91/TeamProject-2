
/**
 * 계산시 주류세를 적용하는 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.12)
 */
public class AlcoholicDrinks extends Products implements TAX {
    
    /**
     * 주류 객체를 생성하는 생성자
     */
    public AlcoholicDrinks(String barcode, String name, int price){
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }
    
    /**
     * 주류의 세금을 계산한다. (부가세 10% + 주류세 30%)
     */
    public int calcTax(){
        return (int)(price * 0.4);
    }
}