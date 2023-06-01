package Menu;



public class BurgerMenu extends Menu{
//    Burger burger = new Burger() {
//        @Override
//        public String getName() {
//            return burger.getName();
//        }
//
//        @Override
//        public String getDesc() {
//            return burger.getDesc();
//        }
//
//        @Override
//        public int getPrice() {
//            return burger.getPrice();
//        }
//    };
    String name;
    String desc;
    int price;
    int count;
    public BurgerMenu(String name, String desc, int price,int count) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.count = count;
    }

    @Override
    public void printScreen() {
        System.out.println(String.format("%d. %-18s ||W%,d",(count+1),name,price));
        System.out.println("- "+desc);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getPrice(){
        return price;
    }
}