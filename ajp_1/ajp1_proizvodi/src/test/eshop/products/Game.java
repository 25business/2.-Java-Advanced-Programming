package test.eshop.products;

import java.math.BigDecimal;

// TODO: Prikazati cenu umanjenu za discount u ispisu

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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("""
                -- Game --
                AISN: %s
                Title: %s
                Manufacturer: %s
                Platforms: %s
                Price: %.2f""", aisn, title, manufacturer, platforms, price));
        if(discount_percentage.doubleValue() > 0) {
            sb.append(String.format("""
                    \nDiscount: %.0f%%
                    Price with discount: %.2f""", discount_percentage,
                    priceWithDiscount()));
        }
        return sb.toString();
    }
}
