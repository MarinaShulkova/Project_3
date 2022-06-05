public class Estate {
    String name;
    String metro;
    String address;
    String type;
    double area;
    int price;
    float rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Estate(String name, String metro, String address, String type, double area, int price, float rate) {
        this.name = name;
        this.metro = metro;
        this.address = address;
        this.type = type;
        this.area = area;
        this.price = price;
        this.rate = rate;

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
