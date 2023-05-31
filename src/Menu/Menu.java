package Menu;

import java.util.ArrayList;

public class Menu {
//    BurgerMenu burgerMenu = new BurgerMenu();
//    DrinkMenu drinkMenu = new DrinkMenu();
//    SideMenu sideMenu = new SideMenu();
//
    ArrayList<Menu> menuArrayList = new ArrayList<Menu>();

    public Menu() {

    }

    public void printScreen() {
        System.out.println("=========Category=========");
        System.out.println("1. Burger");
        System.out.println("2. Drink");
        System.out.println("3. Side");
        System.out.println("========Order Menu========");
        System.out.println("4. Order");
        System.out.println("5. Cancel");
    }
//    public BurgerMenu getBurgerMenu(){
//        return burgerMenu;
//    }
//
//    public DrinkMenu getDrinkMenu(){
//        return drinkMenu;
//    }
//    public SideMenu getSideMenu(){
//        return sideMenu;
//    }
//
    public ArrayList<Menu> getMenu(){
        return menuArrayList;
    }
    public String getName(){
        return null;
    }
    public int getPrice(){
        return 0;
    }
}
