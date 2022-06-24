package test.eshop.products;

import java.math.BigDecimal;

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
        return String.format("""
                -- Book --
                ISBN: %s
                Title: %s
                Author(s): %s
                Pages: %d
                Price: %.2f
                Discount: %.0f%%
                Price with Discount: %.2f""", isbn, title, authors, pages, price, discount_percentage, priceWithDiscount());
    }
}