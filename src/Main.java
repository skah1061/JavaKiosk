public class Main {
    public static void main(String[] args) {
        McKiosk mcKiosk = new McKiosk();
        while(true) {
            mcKiosk.KioskUse();
            if(mcKiosk.num == 0)
                break;
        }
    }
}