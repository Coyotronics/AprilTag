package com.coyotronics.frc2022.util;

public class Util {
    public static double MultiDeadBand(double val) {
        if(Math.abs(val - 1) < 0.01) val = 1;
        if(Math.abs(val) < 0.01) val = 0;
        if(Math.abs(val + 1) < 0.01) val = -1;
        return val;
    }

     public static<T>  T swap(T... args) {   // usage: z = swap(a, a=b, b=c, ... y=z);
        return args[0];
    }
     
}
