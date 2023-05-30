package Menu;



public class SideMenu extends Menu{
//    Side side = new Side() {
//        @Override
//        public String getName() {
//            return side.getName();
//        }
//
//        @Override
//        public String getDesc() {
//            return side.getDesc();
//        }
//
//        @Override
//        public int getPrice() {
//            return side.getPrice();
//        }
//    };
    String name;
    String desc;
    int price;
    int count;
    public SideMenu(String name, String desc, int price, int count) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.count = count;
    }
    @Override
    public void printScreen() {
        System.out.println((count+1) +" "+name +" || W"+price);
        System.out.println("- "+desc);
    }

}
