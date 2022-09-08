package test.eshop.products;

import java.math.BigDecimal;

// TODO: Prikazati cenu umanjenu za discount u ispisu

public class Book extends Product {
    private String isbn;
    private String authors;
    private int pages;

    public Book(String title, BigDecimal price, String image, BigDecimal discount, String isbn, String authors, int pages) {
        super(title, price, image, discount);
        this.isbn = isbn;
        this.authors = authors;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String toString() {
        BigDecimal discount_percentage = discount.multiply(new BigDecimal(100));

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("""
                -- Book --
                ISBN: %s
                Title: %s
                Author(s): %s
                Pages: %d
                Price: %.2f
                """, isbn, title, authors, pages, price));
        if(discount_percentage.doubleValue() > 0) {
            sb.append(String.format("""
                    Discount: %.0f%%
                    Price with discount: %.2f""", discount_percentage,
                    priceWithDiscount()));
        }
        return sb.toString();
    }
}
