package TP4_4.Boisson;

import TP4_3.Boisson.Boisson;

public class Colombia extends Boisson {
    public Colombia() {
        description = "Colombia";
    }

    @Override
    public double cout() {
        return 1.3;
    }
}