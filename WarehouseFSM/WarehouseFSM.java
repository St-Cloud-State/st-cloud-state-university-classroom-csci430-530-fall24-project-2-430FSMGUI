public class WarehouseFSM {
    public static void main(String[] args) {
        Context context = new Context();

        while (true) {
            context.handle();
        }
    }
}

