package edu.nguyenvanson.domain;

public class SparePart {

    private String idSparePart;
    private String nameSparePart;
    private String quantity;
    private String price;
    private String menuDate;
    private String description;

    public SparePart() {
    }

    public SparePart(String idSparePart, String nameSparePart, String quantity, String price, String menuDate, String description) {
        this.idSparePart = idSparePart;
        this.nameSparePart = nameSparePart;
        this.quantity = quantity;
        this.price = price;
        this.menuDate = menuDate;
        this.description = description;
    }

    public String getIdSparePart() {
        return idSparePart;
    }

    public void setIdSparePart(String idSparePart) {
        this.idSparePart = idSparePart;
    }

    public String getNameSparePart() {
        return nameSparePart;
    }

    public void setNameSparePart(String nameSparePart) {
        this.nameSparePart = nameSparePart;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(String menuDate) {
        this.menuDate = menuDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
