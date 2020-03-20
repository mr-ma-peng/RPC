package com.nuwf.serviceimpl;


public class ComPutingServicesImpl implements ComPutingServices {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public String log(String string) {
        return string;
    }
}
