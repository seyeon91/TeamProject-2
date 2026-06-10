
/**
 * Products는 상품 목록 저장하는 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.09)
 */

// 모든 상품의 부모 클래스(추상 클래스)
// 직접 객체를 만들 수 없고, 반드시 자식 클래스를 통해 사용
public abstract class Products
{
    String barcode;
    String name;
    int price;
    
    // 생성자: 바코드, 상품명, 단가를 받아서 저장
    public Products(String b, String n, int p){
        barcode = b;
        name = n;
        price = p;
    }
    
    public abstract int calcPrice();
}