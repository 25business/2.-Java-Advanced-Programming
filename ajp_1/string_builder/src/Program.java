public class Program {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        /*sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println(sb);*/
        /*
        if(3 < 5) {
            sb.append("1");
        }
        if(5 > 7) {
            sb.append("2");
        }
        if(8 == 8) {
            sb.append("3");
        }
        System.out.println(sb);
         */
        sb.append("Hello World!");
        sb.delete(6,11);
        sb.insert(6,"beautiful ");
        System.out.println(sb.toString().toUpperCase());
    }
}
