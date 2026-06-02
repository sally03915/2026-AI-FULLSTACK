package com.company.ioc2;

import org.springframework.stereotype.Component;

@Component("vanilla")
public class Vanilla implements IceCream {
    @Override public String flavor() { return "Vanilla-flavor"; }
    @Override public String scoop()  { return "Vanilla-scoop"; }
    @Override public String melt()   { return "Vanilla-melt"; }
}