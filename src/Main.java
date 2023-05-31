public class Main {
    public static void main(String[] args) throws InterruptedException {
        McKiosk mcKiosk = new McKiosk();
        do {
            System.out.println("---------------------------------------------------");
            mcKiosk.KioskUse();
        } while (mcKiosk.num != 0);
    }
}