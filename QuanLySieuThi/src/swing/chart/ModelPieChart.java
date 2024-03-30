/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.chart;

import java.awt.Color;

/**
 *
 * @author LinhPTA-PC
 */
public class ModelPieChart {
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ModelPieChart(String name, int values, Color color) {
        this.name = name;
        this.values = values;
        this.color = color;
    }

    public ModelPieChart() {
    }

    private String name;
    private int values;
    private Color color;
    
}
