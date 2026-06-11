import java.util.Scanner;
/**
 * MyApp은 코드 작동을 위한 메인 클래스
 *
 * @author (2025320070_복창희, 2025320038_윤세연, 2023320022_편규빈, 2023320004_호준수)
 * @version (2026.06.09)
 */
// POST 객체를 생성하고 바코드 입력 루프 실행
public class MyApp
{
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
        post.pay(scan);
    }
}