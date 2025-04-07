package org.javase;

public class MathLab {
    public double PI;

    public MathLab(){

    }

    public MathLab(double pi){
        PI = pi;
    }

    public MathLab(double pi,boolean print){
        PI = pi;

        if(print){
            System.out.println(PI);
        }
    }

    public double area(double r){
        double result = PI * Math.pow(r, 2);
        return result;
    }

    public void printMyName(){
        System.out.println("Hakim");
    }

}
