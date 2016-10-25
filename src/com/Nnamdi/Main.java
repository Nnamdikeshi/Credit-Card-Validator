package com.Nnamdi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Create a frame - the GUI window
        JFrame CCValidator = new JFrame("Credit Card Validator");

        //configure the JFrame / GUI window
        CCValidator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Create an object from this class - it's a JPanel,  which is a GUI component
        CCValidator ccGui = new CCValidator();

        //And add it to the JFrame
        CCValidator.add(ccGui);

        //Size the frame to fit the components it contains
        CCValidator.pack();

        //And show the window
        CCValidator.setVisible(true);

    }
}
