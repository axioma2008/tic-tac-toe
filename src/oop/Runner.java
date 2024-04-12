package oop;

import test.Puppy;

public class Runner {
    public static void main(String[] args) {
        Kitten kitten = new Kitten();
        Puppy puppy = new Puppy();
        kitten.breathe();
        puppy.breathe();
    }
}
