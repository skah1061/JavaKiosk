import Menu.BurgerMenu;
import Menu.DrinkMenu;
import Menu.SideMenu;
import Menu.Menu;
import java.util.ArrayList;
import java.util.*;
enum status{
    CATEGORY,
    MENU,
    ORDER,
}

public class McKiosk {
    int num;
    Menu menu = new Menu();
    ArrayList<Order> shoppingBag = new ArrayList<Order>();
    static status stat = status.CATEGORY;


    public McKiosk() {

    }

    public void KioskUse(){
        menu.printScreen();
        if (stat == status.CATEGORY) {
            chooseCategory(choose());
        }
        else if(stat == status.MENU) {
            chooseMenu();
        }
        else if(stat == status.ORDER){
            //메뉴 장바구니
        }


    }
    public void chooseOrder(){
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
    public int choose() {
        System.out.print("선택 : ");
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }

    public void chooseCategory(int choose) {
        num = choose;

        menu.getMenu().clear();
        switch (num) {  //initialize구문
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
            default -> {
                System.out.println("없는 번호 입니다.");
                stat = status.CATEGORY;
            }
        }//버거 음료 사이드 메뉴선택

    }
    public void chooseMenu(){
        System.out.println("===============메뉴============");
        for(int j =0;j<menu.getMenu().size();j++) {
            menu.getMenu().get(j).printScreen();
        }

        num = choose();

        chooseOrder();
//        switch (num){
//            case 1:
//                menu.getMenu().get(0).printScreen();
//                stat = status.ORDER;
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            default:


    }
}