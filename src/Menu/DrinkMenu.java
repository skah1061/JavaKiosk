package Menu;



public class DrinkMenu extends Menu{
//    Drink drink = new Drink() {
//        @Override
//        public String getName() {
//            return drink.getName();
//        }
//
//        @Override
//        public String getDesc() {
//            return drink.getDesc();
//        }
//
//        @Override
//        public int getPrice() {
//            return drink.getPrice();
//        }
//    };
    String name;
    String desc;
    int price;
    int count;
    public DrinkMenu(String name, String desc, int price, int count) {
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
