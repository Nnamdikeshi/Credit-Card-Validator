package com.Nnamdi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nc0614dn on 10/25/2016.
 */
public class CCValidator extends JPanel{
    private JTextField cardNumberTextField;
    private JButton validateButton;
    private JButton quitButton;
    private JPanel rootPanel;
    private JLabel validMessageLabel;
    private JLabel instructionsLabel;

    CCValidator() {

        cardNumberTextField = new JTextField();
        instructionsLabel = new JLabel("Enter card number");
        validateButton = new JButton("Validate");
        quitButton = new JButton("Quit");
        validMessageLabel = new JLabel("Valid or not valid?");

        //configure layout manager to arrange components vertically
//        BoxLayout layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
//        setLayout(layoutManager);

        //And add components
        add(instructionsLabel);
        add(cardNumberTextField);
        add(validMessageLabel);
        add(validateButton);
        add(quitButton);

        //Listener for validate button
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ccNumber = cardNumberTextField.getText();
                boolean valid = isVisaCreditCardNumberValid(ccNumber);
                if (valid) {
                    validMessageLabel.setText("Credit card number is valid");
                } else {
                    validMessageLabel.setText("Credit card number is NOT valid");
                }

            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Show 'are you sure' dialog box
                int quit = JOptionPane.showConfirmDialog(CCValidator.this,
                        "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);

                //Check which option user selected, quit if user clicked ok
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }


    private boolean isVisaCreditCardNumberValid(String cc) {
        if (!cc.startsWith("4")) {
            return false;
        }

        if (cc.length() != 16) {
            return false;
        }


        int sum = 0;

        for (int i = 0; i < 16 ; i++ ) {
            int thisDigit = Integer.parseInt((cc.substring(i, i+1)));
            if (i % 2 == 1) {
                sum = sum + thisDigit;
            } else {
                int doubled = thisDigit * 2;
                if (doubled > 9 ) {
                    int toAdd = 1 + (doubled % 10);
                    sum = sum + toAdd;
                } else {
                    sum = sum + (thisDigit * 2);
                }
            }
        }

        if (sum % 10 == 0) {
            return true;
        }

        return false;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
