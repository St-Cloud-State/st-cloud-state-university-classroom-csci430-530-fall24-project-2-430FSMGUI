import java.util.Scanner;

public class LoginState implements State {
    private WareContext context;

    public LoginState(WareContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login State: Choose Role");
        System.out.println("1. Login as Client");
        System.out.println("2. Login as Clerk");
        System.out.println("3. Login as Manager");

        int choice = scanner.nextInt();
        if (choice == 1) {
            context.setState(new ClientMenuState(context));
        } else if (choice == 2) {
            context.setState(new ClerkMenuState(context));
        } else if (choice == 3) {
            context.setState(new ManagerMenuState(context));
        } else {
            System.out.println("Invalid option.");
        }
    }
}
