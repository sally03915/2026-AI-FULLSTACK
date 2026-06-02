package com.company.ioc2;

import org.springframework.stereotype.Component;

@Component("choco")
public class Chocolate implements IceCream {
    @Override public String flavor() { return "Chocolate-flavor"; }
    @Override public String scoop()  { return "Chocolate-scoop"; }
    @Override public String melt()   { return "Chocolate-melt"; }
}
