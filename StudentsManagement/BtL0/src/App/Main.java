package App;
import java.util.Scanner;

import static Utils.PrintUtil.*;
import static Utils.SwitchUtil.arrayListStudent;
import static Utils.SwitchUtil.arrayStudent;

public class Main {
    public static void main(String[] args) {
        while (true) {
        showMenu();
            try {
                Scanner sc = new Scanner(System.in);
                int n = Integer.parseInt(sc.nextLine());
                switch (n) {
                    case 1 -> arrayStudent();
                    case 2 -> arrayListStudent();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Reselect !!!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }
}