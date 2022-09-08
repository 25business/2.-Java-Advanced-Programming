package test.eshop.products;

import java.math.BigDecimal;

public abstract class Product {
    protected String title;
    protected BigDecimal price;
    protected String image;
    protected BigDecimal discount;

    public Product(String title, BigDecimal price, String image, BigDecimal discount) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal priceWithDiscount() {
        // cena - cena * discount
        return price.subtract(price.multiply(discount));
    }
}
