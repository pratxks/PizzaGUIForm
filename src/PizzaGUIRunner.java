/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaguiform;

import javax.swing.JFrame;

public class PizzaGUIRunner 
{
    public static void main(String[] args) 
    {
        PizzaGUIFrame MyPizzaOrderFrame = new PizzaGUIFrame();

        MyPizzaOrderFrame.SetPizzaFormFrameDisplay();

        MyPizzaOrderFrame.setSize(820, 520);

        MyPizzaOrderFrame.setResizable(false);

        MyPizzaOrderFrame.setLocationRelativeTo(null);
        
        MyPizzaOrderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPizzaOrderFrame.setVisible(true);
    }
}
