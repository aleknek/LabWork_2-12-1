package com.brainacad.oop.testnest1;

public class Main {

    public static void main(String[] args) {

        MyPhone myPhone = new MyPhone();
        myPhone.switchOn();

        System.out.println("Calling to:" + myPhone.call(1));

    }
}
