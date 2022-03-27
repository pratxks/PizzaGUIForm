/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaguiform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class PizzaGUIFrame extends JFrame
{
    private JPanel pizzaFormMainPanel;
    private JPanel pizzaFormTopPanel;
    private JPanel pizzaFormBottmPanel;
    private JPanel pizzaFormCrustPanel;
    private JPanel pizzaFormTypePanel;
    private JPanel pizzaFormToppingPanel;
    private JPanel pizzaFormReceiptPanel;
    private JPanel pizzaFormControlPanel;
    
    private JRadioButton crustThinRadioButton;
    private JRadioButton crustRegularRadioButton;
    private JRadioButton crustDeepdishRadioButton;
    
    private JLabel pizzaTypeLabel;
    private JComboBox pizzaTypeOptionBox;
    
    private JCheckBox pizzaFormToppingPepperoni;
    private JCheckBox pizzaFormToppingSausage;
    private JCheckBox pizzaFormToppingMushrooms;
    private JCheckBox pizzaFormToppingOnions;
    private JCheckBox pizzaFormToppingCheese;
    private JCheckBox pizzaFormToppingPeppers;
    
    private JTextArea pizzaFormOrderDisplay;
    
    private JButton pizzaFormOrderButton;
    private JButton pizzaFormClearButton;
    private JButton pizzaFormQuitButton;
    
    private double pizzaFormBaseOrderPrice;
    private double pizzaFormToppingsPrice;
    
    private double pizzaTypePrices[] = {0.0, 8.0, 12.0, 16.0, 20.0}; 
       
    public PizzaGUIFrame()
    {
        setTitle("Pizza Order Form");
    }
    
    public void SetPizzaFormFrameDisplay()
    {
        pizzaFormMainPanel = new JPanel();
        
        pizzaFormTopPanel = new JPanel();
        
        pizzaFormBottmPanel = new JPanel();
        
        pizzaFormMainPanel.setLayout(new BorderLayout());
        
        pizzaFormTopPanel.setLayout(new BorderLayout());
        
        pizzaFormBottmPanel.setLayout(new BorderLayout());
        
        createPizzaFormCrustPanel();
        createPizzaFormTypePanel();
        createPizzaFormToppingPanel();
        createPizzaFormOrderPanel();
        createPizzaFormControlPanel();
        
        pizzaFormTopPanel.add(pizzaFormCrustPanel, BorderLayout.NORTH);
        pizzaFormTopPanel.add(pizzaFormTypePanel, BorderLayout.CENTER);
        pizzaFormTopPanel.add(pizzaFormToppingPanel, BorderLayout.SOUTH);
        
        pizzaFormBottmPanel.add(pizzaFormReceiptPanel, BorderLayout.NORTH);
        pizzaFormBottmPanel.add(pizzaFormControlPanel, BorderLayout.SOUTH);
            
        pizzaFormMainPanel.add(pizzaFormTopPanel, BorderLayout.NORTH);
        pizzaFormMainPanel.add(pizzaFormBottmPanel, BorderLayout.SOUTH);
        
        add(pizzaFormMainPanel);
    }
    
    private void ResetSelection()
    {
        crustThinRadioButton.setSelected(false);
        crustRegularRadioButton.setSelected(false);
        crustDeepdishRadioButton.setSelected(false);

        pizzaTypeOptionBox.setSelectedIndex(0);

        pizzaFormToppingPepperoni.setSelected(false);
        pizzaFormToppingSausage.setSelected(false);
        pizzaFormToppingMushrooms.setSelected(false);
        pizzaFormToppingOnions.setSelected(false);
        pizzaFormToppingCheese.setSelected(false);
        pizzaFormToppingPeppers.setSelected(false);

        pizzaFormOrderDisplay.setText("");
        
        pizzaFormBaseOrderPrice = 0.0;
        pizzaFormToppingsPrice = 0.0;
    }
    
    private void createPizzaFormCrustPanel()
    {
        pizzaFormCrustPanel = new JPanel();
        
        GridLayout crustGridLayout = new GridLayout(1, 4);

        crustGridLayout.setHgap(10);
        crustGridLayout.setVgap(10);

        pizzaFormCrustPanel.setLayout(crustGridLayout);
        
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        Border crustPanelBorder = BorderFactory.createTitledBorder(blueLineBorder, "Pizza Crust Selection Panel");
        
        pizzaFormCrustPanel.setBorder(crustPanelBorder);
        
        Font crustPanelFont  = new Font(Font.SERIF,  Font.BOLD, 24);
        
        crustThinRadioButton = new JRadioButton("Thin");
        crustRegularRadioButton = new JRadioButton("Regular");
        crustDeepdishRadioButton = new JRadioButton("Deep-dish");
        
        crustThinRadioButton.setFont(crustPanelFont);
        crustRegularRadioButton.setFont(crustPanelFont);
        crustDeepdishRadioButton.setFont(crustPanelFont);
        
        ButtonGroup crustButtonGroup = new ButtonGroup();
        
        crustButtonGroup.add(crustThinRadioButton);
        crustButtonGroup.add(crustRegularRadioButton);
        crustButtonGroup.add(crustDeepdishRadioButton);

        pizzaFormCrustPanel.add(crustThinRadioButton);
        pizzaFormCrustPanel.add(crustRegularRadioButton);
        pizzaFormCrustPanel.add(crustDeepdishRadioButton);
    }
    
    private void createPizzaFormTypePanel()
    {
        pizzaFormTypePanel = new JPanel();
        
        pizzaFormTypePanel.setLayout(new BorderLayout(10, 10));
        
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        Border typePanelBorder = BorderFactory.createTitledBorder(blueLineBorder, "Pizza Size Selection Panel");
        
        pizzaFormTypePanel.setBorder(typePanelBorder);
        
        Font typePanelFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 22);
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 3));
        pizzaTypeLabel = new JLabel("Pizza Size");
        pizzaTypeLabel.setFont(typePanelFont);
        labelPanel.add(new JLabel());
        labelPanel.add(pizzaTypeLabel);
        labelPanel.add(new JLabel());
        
        String pizzaTypes[] = {"Select Pizza Size", "Small - $8.00", "Medium - $12.00", "Large - $16.00", "Super - $20.00"};
        
        JPanel comboboxPanel = new JPanel();
        comboboxPanel.setLayout(new GridLayout(1, 3));
        pizzaTypeOptionBox = new JComboBox(pizzaTypes);
        pizzaTypeOptionBox.setFont(typePanelFont);
        comboboxPanel.add(new JLabel());
        comboboxPanel.add(pizzaTypeOptionBox);
        comboboxPanel.add(new JLabel());
                
        pizzaFormTypePanel.add(labelPanel, BorderLayout.WEST);
        pizzaFormTypePanel.add(comboboxPanel, BorderLayout.EAST);
    }
    
    private void createPizzaFormToppingPanel()
    {
        pizzaFormToppingPanel = new JPanel();
        
        GridLayout toppingGridLayout = new GridLayout(2, 3);
        toppingGridLayout.setHgap(10);
        toppingGridLayout.setVgap(10);

        pizzaFormToppingPanel.setLayout(toppingGridLayout);
        
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        Border toppingPanelBorder = BorderFactory.createTitledBorder(blueLineBorder, "Pizza Toppings Selection Panel");
        
        pizzaFormToppingPanel.setBorder(toppingPanelBorder);
        
        Font toppingPanelFont  = new Font(Font.MONOSPACED,  Font.BOLD, 24);
                
        pizzaFormToppingPepperoni = new JCheckBox("Pepperoni");
        pizzaFormToppingSausage = new JCheckBox("Sausage");
        pizzaFormToppingMushrooms = new JCheckBox("Mushrooms");
        pizzaFormToppingOnions = new JCheckBox("Onions");
        pizzaFormToppingCheese = new JCheckBox("Cheese");
        pizzaFormToppingPeppers = new JCheckBox("Peppers");
        
        pizzaFormToppingPepperoni.setFont(toppingPanelFont);
        pizzaFormToppingSausage.setFont(toppingPanelFont);
        pizzaFormToppingMushrooms.setFont(toppingPanelFont);
        pizzaFormToppingOnions.setFont(toppingPanelFont);
        pizzaFormToppingCheese.setFont(toppingPanelFont);
        pizzaFormToppingPeppers.setFont(toppingPanelFont);
        
        pizzaFormToppingPanel.add(pizzaFormToppingPepperoni);
        pizzaFormToppingPanel.add(pizzaFormToppingSausage);
        pizzaFormToppingPanel.add(pizzaFormToppingMushrooms);
        pizzaFormToppingPanel.add(pizzaFormToppingOnions);
        pizzaFormToppingPanel.add(pizzaFormToppingCheese);
        pizzaFormToppingPanel.add(pizzaFormToppingPeppers);
    }
    
    private void createPizzaFormOrderPanel()
    {
        pizzaFormReceiptPanel = new JPanel();
        
        pizzaFormReceiptPanel.setLayout(new BorderLayout(30, 10));
        
        Font orderPanelFont  = new Font(Font.MONOSPACED,  Font.PLAIN, 18);
        
        pizzaFormOrderDisplay = new JTextArea(11, 70);
        
        pizzaFormOrderDisplay.setFont(orderPanelFont);
        
        pizzaFormReceiptPanel.add(pizzaFormOrderDisplay, BorderLayout.CENTER);
    }
    
    private void createPizzaFormControlPanel()
    {
        pizzaFormControlPanel = new JPanel();
        
        GridLayout controlGridLayout = new GridLayout(1, 3);
        controlGridLayout.setHgap(10);
        controlGridLayout.setVgap(10);

        pizzaFormControlPanel.setLayout(controlGridLayout);
        
        Font controlPanelFont  = new Font(Font.DIALOG,  Font.BOLD, 22);
        
        pizzaFormOrderButton = new JButton("Order");
        pizzaFormClearButton = new JButton("Clear");
        pizzaFormQuitButton = new JButton("Quit");
        
        pizzaFormOrderButton.setFont(controlPanelFont);
        pizzaFormClearButton.setFont(controlPanelFont);
        pizzaFormQuitButton.setFont(controlPanelFont);
        
        pizzaFormOrderButton.addActionListener(ae -> pizzaFormOrderButtonClicked());
        pizzaFormClearButton.addActionListener(ae -> ResetSelection());
        pizzaFormQuitButton.addActionListener(ae -> {
            System.exit(0);
        });
                
        pizzaFormControlPanel.add(pizzaFormOrderButton);
        pizzaFormControlPanel.add(pizzaFormClearButton);
        pizzaFormControlPanel.add(pizzaFormQuitButton);
    }
    
    public String calculateBaseOrderCostString()
    {
        String pizzaTypeAndSize = "";
        
        if(crustThinRadioButton.isSelected())
        {
            pizzaTypeAndSize = "Thin ";
        }
        else if(crustRegularRadioButton.isSelected())
        {
            pizzaTypeAndSize = "Regular ";
        }
        else if(crustDeepdishRadioButton.isSelected())
        {
            pizzaTypeAndSize = "Deep-dish ";
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Select one of the Pizza Crust");
            return "";
        }
        
        if(pizzaTypeOptionBox.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this, "Select one of the Pizza Size");
            return "";
        }
        
        pizzaTypeAndSize += pizzaTypeOptionBox.getSelectedItem().toString();
        
        pizzaTypeAndSize = String.format("%-57s", pizzaTypeAndSize);
        
        pizzaFormBaseOrderPrice = pizzaTypePrices[pizzaTypeOptionBox.getSelectedIndex()];        
        
        pizzaTypeAndSize += String.format("%-8s", "Price");
        
        String tempBasePrice = String.format("%.2f", pizzaFormBaseOrderPrice);
        
        pizzaTypeAndSize += "$" + String.format("%6s", tempBasePrice);
        
        return pizzaTypeAndSize;
    }
    
    public String calculateToppingCostString()
    {
        String pizzaTopping = "";
        
        String pizzaToppingList [] = {"", "", "", "", "", ""};
        double toppingCount = 0;

        if(pizzaFormToppingPepperoni.isSelected())
        {
            pizzaToppingList[0] = "Pepperoni";
            pizzaFormToppingsPrice++;
        }
        if(pizzaFormToppingSausage.isSelected())
        {
            pizzaToppingList[1] = "Sausage";
            pizzaFormToppingsPrice++;
        }
        if(pizzaFormToppingMushrooms.isSelected())
        {
            pizzaToppingList[2] = "Mushrooms";
            pizzaFormToppingsPrice++;
        }
        if(pizzaFormToppingOnions.isSelected())
        {
            pizzaToppingList[3] = "Onions";
            pizzaFormToppingsPrice++;
        }
        if(pizzaFormToppingCheese.isSelected())
        {
            pizzaToppingList[4] = "Cheese";
            pizzaFormToppingsPrice++;
        }
        if(pizzaFormToppingPeppers.isSelected())
        {
            pizzaToppingList[5] = "Peppers";
            pizzaFormToppingsPrice++;
        }
        if(pizzaFormToppingsPrice == 0)
        {
            JOptionPane.showMessageDialog(this, "Select at least one Pizza Topping");
            return "";
        }

        for(String sTopping : pizzaToppingList)
        {
            if(!sTopping.isEmpty())
            {
                pizzaTopping += sTopping + ", ";
            }
        }
        
        pizzaTopping = pizzaTopping.substring(0, pizzaTopping.length() - 2);
        
        pizzaTopping = String.format("%-57s", pizzaTopping);
        
        pizzaTopping += String.format("%-8s", "Price");
        
        String tempToppingPrice = String.format("%.2f", pizzaFormToppingsPrice);
        
        pizzaTopping += "$" + String.format("%6s", tempToppingPrice);

        return pizzaTopping;
    }
    
    public void pizzaFormOrderButtonClicked()
    {
        if(!pizzaFormOrderDisplay.getText().isEmpty())
        {
            int optionSelected = JOptionPane.showConfirmDialog(null, "Do you want to place new Order", "New Order", JOptionPane.YES_NO_OPTION);
            
            if(optionSelected == JOptionPane.YES_OPTION)
            {
                ResetSelection();
            }
            else
            {
                return;
            }
        }
        
        String pizzaTypeAndSize = calculateBaseOrderCostString();
        String pizzaTopping = calculateToppingCostString();
        
        if(!pizzaTypeAndSize.isEmpty() && !pizzaTopping.isEmpty())
        {
            String headerAndFooter = new String(new char[72]).replace("\0", "=");
            pizzaFormOrderDisplay.append(headerAndFooter + "\n");
            pizzaFormOrderDisplay.append(pizzaTypeAndSize + "\n");
            pizzaFormOrderDisplay.append(pizzaTopping + "\n\n\n");
            
            String subTotal = String.format("%-57s", "Sub-total:");
            subTotal += String.format("%-8s", "Amount");
            
            double fOrderSubTotal = pizzaFormBaseOrderPrice + pizzaFormToppingsPrice;
            
            String tempOrderSubtotal = String.format("%.2f", fOrderSubTotal);
            subTotal += "$" + String.format("%6s", tempOrderSubtotal);
            
            pizzaFormOrderDisplay.append(subTotal + "\n");
            
            String tax = String.format("%-57s", "Tax:");
            tax += String.format("%-8s", "Amount");
            
            double fOrderTax = fOrderSubTotal * 0.07;
            
            String tempOrderTax = String.format("%.2f", fOrderTax);
            tax += "$" + String.format("%6s", tempOrderTax);
            
            pizzaFormOrderDisplay.append(tax + "\n");
            
            String separator = new String(new char[72]).replace("\0", "-");
            pizzaFormOrderDisplay.append(separator + "\n");
            
            String total = String.format("%-57s", "Total:");
            total += String.format("%-8s", "Total");
            
            double fOrderTotal = fOrderSubTotal + fOrderTax;
            
            String tempOrderTotal = String.format("%.2f", fOrderTotal);
            total += "$" + String.format("%6s", tempOrderTotal);
            
            pizzaFormOrderDisplay.append(total + "\n");
            pizzaFormOrderDisplay.append(headerAndFooter + "\n");
        }
    }
    
    public void pizzaFormClearButtonClicked()
    {
        ResetSelection();
    }
}
