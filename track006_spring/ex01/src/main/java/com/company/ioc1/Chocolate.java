package com.company.ioc1;

public class Chocolate implements IceCream {
    @Override public String flavor() { return "Chocolate-flavor"; }
    @Override public String scoop()  { return "Chocolate-scoop"; }
    @Override public String melt()   { return "Chocolate-melt"; }
}
