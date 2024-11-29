package Utils;

public class PrintUtil {
    public static void showMenu() {
        System.out.println("\t\t\t\t|=================MENU================");
        System.out.println("\t\t\t\t| \t  1.List Students(Array)");
        System.out.println("\t\t\t\t| \t  2.List Students(ArrayList)");
        System.out.println("\t\t\t\t| \t  0.Exit");
        System.out.println("\t\t\t\t|=====================================");
        System.out.print("Choose: ");
    }
    public static void menuStudentArray(){
        System.out.println("\t\t\t\t|=================Array===============");
        System.out.println("\t\t\t\t| \t 1.Input List Students");
        System.out.println("\t\t\t\t| \t 2.Show List Students");
        System.out.println("\t\t\t\t| \t 3.Search ID");
        System.out.println("\t\t\t\t| \t 4.Update ID");
        System.out.println("\t\t\t\t| \t 5.Delete ID");
        System.out.println("\t\t\t\t| \t 6.Synchronize data to ArrayList");
        System.out.println("\t\t\t\t| \t 0.Go back");
        System.out.println("\t\t\t\t|=====================================");
        System.out.print("Choose: ");

    }
    public static void menuStudentArrayList(){
        System.out.println();
        System.out.println("\t\t\t\t|==============ArrayList==============");
        System.out.println("\t\t\t\t| \t 1.Input List Students(ArrayList)");
        System.out.println("\t\t\t\t| \t 2.Show List Students(ArrayList)");
        System.out.println("\t\t\t\t| \t 3.Search ID(ArrayList)");
        System.out.println("\t\t\t\t| \t 4.Update ID(ArrayList)");
        System.out.println("\t\t\t\t| \t 5.Delete ID(ArrayList)");
        System.out.println("\t\t\t\t| \t 6.Show list percentCentiliter DESC ");
        System.out.println("\t\t\t\t| \t 7.Show list percentMedianScore ");
        System.out.println("\t\t\t\t| \t 8.Show list student according to rank");
        System.out.println("\t\t\t\t| \t 9.Read from file ");
        System.out.println("\t\t\t\t| \t 10.Write to file ");
        System.out.println("\t\t\t\t| \t 0.Go back");
        System.out.println("\t\t\t\t|=====================================");
        System.out.print("Choose: ");
    }

    public static void showTitle(){
        System.out.printf("%s %3s %19s %14s %14s %9s %12s %13s %14s %4s %11s",
                "ID","Name","Birthday","Address","Height","Weight","StudentID","University","YearStart","GPA","Rank");
        System.out.println();
    }
    public static void updateItem(){
        System.out.println("1.Name\t2.Birthday\t3.Address\t4.Weight\t5.Height\t6.University\t7.YearStart\t8.GPA");
        System.out.print("Choose: ");
    }
    public static void rankStudent(){
        System.out.println("Rank student: ");
        System.out.println("1.POOL\t2.WEAK\t3.AVERAGE\t4.GOOD\t5.VERY_GOOD\t6.EXCELLENT;");
        System.out.print("Choose: ");

    }
}
