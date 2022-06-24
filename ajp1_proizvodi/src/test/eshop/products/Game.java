package test.eshop.products;

import java.math.BigDecimal;

public class Game extends Product {
    private String aisn;
    private String manufacturer;
    private String platforms;

    public Game(String title, BigDecimal price, String image, BigDecimal discount, String aisn, String manufacturer, String platforms) {
        super(title, price, image, discount);
        this.aisn = aisn;
        this.manufacturer = manufacturer;
        this.platforms = platforms;
    }

    public String getAisn() {
        return aisn;
    }
    public void setAisn(String aisn) {
        this.aisn = aisn;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getPlatforms() {
        return platforms;
    }
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String toString() {
        BigDecimal discount_percentage = discount.multiply(new BigDecimal(100));
        return String.format("""
                -- Game --
                AISN: %s
                Title: %s
                Manufacturer: %s
                Platforms: %s
                Price: %.2f
                Discount: %.0f%%
                Price with Discount: %.2f""", aisn, title, manufacturer, platforms, price, discount_percentage, priceWithDiscount());
    }
}