import Menu.BurgerMenu;

import java.util.ArrayList;

public class Order {
    String menuName;
    int price;
    public Order(String menuName, int price){
        this.menuName = menuName;
        this.price = price;
    }
    public void showOrderList(){
        System.out.println(menuName +"   |   W"+ price);
    }

    public int getPrice() {
        return price;
    }
}
