package com.company.ioc1;
import lombok.Data;
@Data  // lombok Ãß°¡~!
public class IceCreamShop {
    private String shopName;
    private IceCream iceCream;

    public IceCreamShop() { super(); }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public IceCream getIceCream() { return iceCream; }
    public void setIceCream(IceCream iceCream) { this.iceCream = iceCream; }

    public String serveFlavor() { return shopName + ">" + iceCream.flavor(); }
    public String serveScoop()  { return shopName + ">" + iceCream.scoop(); }
    public String serveMelt()   { return shopName + ">" + iceCream.melt(); }

    public void print() {
        System.out.println(serveFlavor());
        System.out.println(serveScoop());
        System.out.println(serveMelt());
    }
}