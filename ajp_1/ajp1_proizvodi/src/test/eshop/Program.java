package test.eshop;
import test.eshop.products.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList();
        products.add(new Book(
                "Java: The Complete Reference, Twelfth Edition",
                new BigDecimal(59.99),
                "https://images-na.ssl-images-amazon.com/images/I/518nd4I7r9L._SX397_BO1,204,203,200_.jpg",
                new BigDecimal(0.15),
                "978-1260463415",
                "Herbert Schildt",
                1280
                ));
        products.add(new Game("Project Highrise Architects Edition",
                new BigDecimal(22.99),
                "https://m.media-amazon.com/images/I/612E4EleCDS._SL1000_.jpg",
                new BigDecimal(0.2),
                "B07FB4DL37",
                "Kalypso Media",
                "PC, PS4, Switch"
                ));
        products.add(new Game("Crash Bandicoot N. Sane Trilogy",
                new BigDecimal(49.99),
                "https://m.media-amazon.com/images/I/81YLvhC9PtL._SL1500_.jpg",
                new BigDecimal(0.0),
                "B07BB4R214",
                "Activision",
                "PC, PS4, Switch"
        ));
        products.add(new Book(
                "Java Network Programming: Developing Networked Applications 4th Edition",
                new BigDecimal(39.73),
                "https://images-na.ssl-images-amazon.com/images/I/51GlcnPpPTL._SX379_BO1,204,203,200_.jpg",
                new BigDecimal(0.45),
                "978-1449357672",
                "Elliotte Rusty Harold",
                508
        ));
        products.add(new Book(
                "Introduction to Java Programming and Data Structures, Comprehensive Version",
                new BigDecimal(100.90),
                "https://images-na.ssl-images-amazon.com/images/I/51e9TDkMtyL._SX387_BO1,204,203,200_.jpg",
                new BigDecimal(0),
                "978-0136520238",
                "Y. Daniel Liang",
                1240
        ));
        products.add(new Game("HOLLOW KNIGHT",
                new BigDecimal(32.99),
                "https://m.media-amazon.com/images/I/61P0liUftYL._SL1215_.jpg",
                new BigDecimal(0.0),
                "B07TKY9N62",
                "Fangamer",
                "PS4, PC, Switch"
        ));

        System.out.println("=== ALL PRODUCTS ===");
        for(Product product: products) {
            System.out.println(product);
        }

        System.out.println("=== BOOKS ===");
        for(Product product: products) {

            if(product instanceof Book book) {
                System.out.println(book);
            }
        }

        System.out.println("=== BOOKS (more than 1000 pages) ===");
        for(Product product: products) {
            if((product instanceof Book book) && (book.getPages() > 1000)) {
                System.out.println(book);
            }
        }


        System.out.println("=== GAMES ===");
        for(Product product : products) {
            if( product instanceof Game game) {
                System.out.println(game);
            }
        }

        System.out.println("=== GAMES (Activision) ===");
        for(Product product : products) {
            if( (product instanceof Game game) && (game.getManufacturer().equals("Activision"))) {
                System.out.println(game);
            }
        }


    }
}
