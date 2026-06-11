
/**
 * 세금정보 인터페이스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.12)
 */
// 세금 계산 규칙을 강제하는 인터페이스
// Beverages, AlcoholicDrinks 가 반드시 calcPrice() 를 구현하도록 약속
public interface TAX
{
    /**
     * 세금을 계산하는 메소드 (구현 클래스가 반드시 정의한다)
     */
    int calcTax();
}