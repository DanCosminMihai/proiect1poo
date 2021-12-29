package database;

public final class Gift {

  private String productName;
  private Double price;
  private String category;

  public Gift(String productName, Double price, String category) {
    this.productName = productName;
    this.price = price;
    this.category = category;
  }

  public String getProductName() {
    return productName;
  }

  public Double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "Gift{" +
        "productName='" + productName + '\'' +
        ", price=" + price +
        ", category='" + category + '\'' +
        '}';
  }
}
