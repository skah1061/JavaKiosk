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
        System.out.println("1. =========Burger========");
        System.out.println("2. =========Drink=========");
        System.out.println("3. =========Side==========");
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
}