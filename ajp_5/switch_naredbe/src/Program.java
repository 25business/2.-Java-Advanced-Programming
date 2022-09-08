public class Program {
    public static void main(String[] args) {
        String naziv_meseca = "Mart";
        int broj_dana = switch (naziv_meseca) {
            case "Januar", "Mart", "Maj", "Jul", "Avgust", "Oktobar",
                    "Decembar" -> 31;
            case "April", "Jun", "Septembar", "Novembar" -> 30;
            case "Februar" -> 28;
            default -> -1;
        };
        System.out.println(broj_dana);
    }
}
