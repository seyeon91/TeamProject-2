import java.util.Scanner;
/**
 * MyApp는 메인 클래스로 POST 생성 후 거래 1회 처리
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.12)
 */
public class MyApp
{
    /**
     * 바코드를 반복 입력 받아 거래를 처리하고 결제한다.
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        POST post = new POST();
        
        System.out.println("바코드 입력 (끝: 0)");
        while(true){
            System.out.print("바코드: ");
            String b = scan.next();
            if(b.equals("0")){
                break;
            }
            System.out.print("수량: ");
            
            if(post.scan(b, scan.nextInt()) == false){
                System.out.println("없는 바코드.");
            }
        }
        post.pay(scan); // 결제 + DB저장
    }
}