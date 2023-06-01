import Menu.BurgerMenu;
import Menu.DrinkMenu;
import Menu.SideMenu;
import Menu.Menu;
import java.util.ArrayList;
import java.util.*;
enum status{    //상태를 나타낸 enum
    CATEGORY,
    MENU,
    ORDER,
    ADMIN,
}

public class McKiosk {
    int num;
    Menu menu = new Menu();     //메뉴들을 포함
    ArrayList<Order> shoppingBag = new ArrayList<Order>();      //장바구니
    static status stat = status.CATEGORY;          //최초 상태는 카테고리
    int watingCnt = 0;                      //주문 대기표

    int totalProfit = 0;
    ArrayList<Order> sellingFood = new ArrayList<Order>();  //총 판매된 음식 리스트
    public McKiosk() {

    }

    public void KioskUse() throws InterruptedException {    //상태에 따라 함수를 출력해준다.

        if (stat == status.CATEGORY) {
            chooseCategory();
        }
        else if(stat == status.MENU) {
            chooseMenu();
        }
        else if(stat == status.ORDER){
            showOrder();
        }
        else if (stat== status.ADMIN){
            showAdminstor();
        }


    }
    public void showAdminstor(){    //Admin페이지
        System.out.println("===총 판매 현황===");
        for(Order food:sellingFood){
            System.out.println(String.format("%-18s  W%,d,",food.menuName,food.price));
        }

        System.out.println("총 수익 : W"+ totalProfit);
        System.out.println("메뉴판으로 나가려면 아무키나 입력하세요.");
        choose();
        stat = status.CATEGORY;
    }
    public void showOrder() throws InterruptedException {           //주문목록을 보여주고 주문할 수 있는 함수
        int sum = 0;
        System.out.println("========장바구니========");

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(Order bag:shoppingBag){
            Integer cnt =  map.get(bag.menuName);
            if(cnt==null)
                map.put(bag.menuName,1);
            else
                map.put(bag.menuName,cnt+1);

            sum+=bag.getPrice();
        }
        for (String key: map.keySet())
        {
            int pay =0;
            for(Order bag:shoppingBag){
                if(key.equals(bag.menuName))
                    pay=bag.price;
            }
            System.out.print(String.format("%-18s|%d개|%8s",key,map.get(key),""));
            System.out.println(String.format("W%,d",pay*map.get(key)));

        }
        System.out.println("합계 : W"+sum);
        System.out.println("1. 주문하기     2. 메뉴판");
        int i = choose();
        switch (i){
            case 1 ->{
                watingCnt++;
                for(Order bag: shoppingBag){
                    sellingFood.add(new Order(bag.menuName, bag.price));
                }
                totalProfit += sum;
                shoppingBag.clear();
                System.out.println("주문 완료했습니다.");
                System.out.println("대기번호는 "+ watingCnt +"번 입니다.");
                System.out.println("잠시 뒤 메뉴판으로 이동됩니다...");
                stat = status.CATEGORY;
                Thread.sleep(3000);
                //주문
            }
            case 2 ->{
                stat = status.CATEGORY;
            }
            default ->{
                System.out.println("다시 선택해주세요.");
            }
        }

    }
    public void chooseOrder(){          //주문할지 물어보는 페이지
        System.out.println("1. 주문하기       2. 돌아가기");
        int i = choose();
        if (i ==1){
            shoppingBag.add(new Order(menu.getMenu().get(num-1).getName(), menu.getMenu().get(num-1).getPrice()));
            System.out.println(menu.getMenu().get(num-1).getName()+", "+ menu.getMenu().get(num-1).getPrice());
            //오더
            //장바구니 추가
            System.out.println("장바구니에 추가했습니다.");
            stat = status.CATEGORY;
        }
        else if(i == 2){
            System.out.println("취소했습니다.");
            stat = status.CATEGORY;
        }
        else{
            System.out.println("없는 숫자입니다.");
        }

    }
    public int choose() {   //입력받기 함수 int형을 리턴한다.
        System.out.print("선택 : ");
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }

    public void chooseCategory() {      //카테고리 중 선택시 메뉴 리스트를 초기화하고 다시 등록
        menu.printScreen();
        int choose = choose();
        num = choose;

        menu.getMenu().clear();
        switch (num) {  //initialize구문
            case 0 ->{
                stat = status.ADMIN;
            }
            case 1 -> {
                menu.getMenu().add(new BurgerMenu("베이컨 토마토 디럭스", "2장의 패티, 베이컨, 양상추, 토마토에 칠리 소스와 마요네즈가 들어간 버거.", 5500, 0));
                menu.getMenu().add(new BurgerMenu("빅맥", "참깨빵위에 순쇠고기 패티두장 특별한 소스 양상추 치즈피클 양파까지.", 4600, 1));
                menu.getMenu().add(new BurgerMenu("쿼터 파운드 치즈", "113g 묵직한 순쇠고기 패티에 고소한 베이컨과 특제 바비큐 소스로 스모키한 풍미 가득한 버거", 5200, 2));
                stat = status.MENU;
            }
            case 2 -> {
                menu.getMenu().add(new DrinkMenu("콜라", "모두가 아는 그 맛. 펩시말고 코카콜라", 2000, 0));
                menu.getMenu().add(new DrinkMenu("밀크 쉐이크", "우유와 아이스크림, 또는 얼린 우유로 만든 시원하고 달콤한 음식", 2500, 1));
                menu.getMenu().add(new DrinkMenu("오렌지 주스", "간단하게 먹을 수 있는 생과일 착즙 주스", 1500, 2));
                stat = status.MENU;
            }
            case 3 -> {
                menu.getMenu().add(new SideMenu("감자 튀김", "소금을 많이 뿌린 짭짤한 감자튀김", 1700, 0));
                menu.getMenu().add(new SideMenu("치킨 너겟", "순살치킨을 반죽과함께 튀긴요리", 2200, 1));
                menu.getMenu().add(new SideMenu("스낵 랩", "소시지와 스모키 베이컨 소스, 베이컨, 양상추 등을 얇은 또띠아로 감싼 메뉴", 1500, 2));
                stat = status.MENU;
            }
            case 4 ->{
                stat = status.ORDER;
            }
            case 5 ->{
                shoppingBag.clear();
                System.out.println("주문 취소 되었습니다.");
            }
            default -> {
                System.out.println("없는 번호 입니다.");
                stat = status.CATEGORY;
            }
        }//버거 음료 사이드 메뉴선택

    }
    public void chooseMenu(){               //메뉴화면을 출력하고 주문을 선택
        System.out.println("===============메뉴============");
        for(int j =0;j<menu.getMenu().size();j++) {
            menu.getMenu().get(j).printScreen();
        }

        num = choose();

        chooseOrder();
        ////////


    }
}