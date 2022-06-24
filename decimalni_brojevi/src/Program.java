import java.math.BigDecimal;

public class Program {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal(3.14);
        BigDecimal bd2 = new BigDecimal("3.14");
        System.out.println(bd1);
        System.out.println(bd2);

        BigDecimal sabiranje = bd1.add(bd2);
        System.out.println(sabiranje);

        System.out.println(bd1.compareTo(bd2) == 1);
        System.out.println(bd1.compareTo(bd2) == 0);
        System.out.println(bd1.compareTo(bd2) == -1);
    }
}
