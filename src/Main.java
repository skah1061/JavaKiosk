public class Main {
    public static void main(String[] args) {
        McKiosk mcKiosk = new McKiosk();
        do {
            mcKiosk.KioskUse();
        } while (mcKiosk.num != 0);
    }
}