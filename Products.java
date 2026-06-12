
/**
 * Products는 상품 목록 저장하는 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.12)
 */

public abstract class Products
{
    String barcode;
    String name;
    int price;

    /**
     * 상품의 세금을 계산하는 추상 메소드
     * 
     * @return 계산된 세금(원)
     */
    public abstract int calcTax();
}