package com.company.ioc1;

public class Vanilla implements IceCream {
    @Override public String flavor() { return "Vanilla-flavor"; }
    @Override public String scoop()  { return "Vanilla-scoop"; }
    @Override public String melt()   { return "Vanilla-melt"; }
}