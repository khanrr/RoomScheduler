/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeHierarchy;

/**
 *
 * @author rrk5140
 */
public class CommissionCompensationModel {
    private double grossSales;
    private double commissionRate;
    
    public CommissionCompensationModel(double grossSales, double commissionRate){
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    
    public void setGrossSales(double grossSales){
        if(grossSales < 0.0){
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        this.grossSales = grossSales;
    }
    
    public double getGrossSales(){
        return grossSales;
    }
    
     public void setCommissionRate(double commissionRate){
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");
    }
        this.commissionRate = commissionRate;
    }
     
    public double getCommissionRate(){
        return commissionRate;
    }
    
    public double earnings(){
        return getGrossSales() * getCommissionRate();
    }
    
    @Override
    public String toString(){
        return String.format("%s: %n%s: %.2f%n%s: %.2f%n%s: %.2f",
                "Commission Compensation with",
                "Gross Sales of", getGrossSales(),
                "Commission Rate of", getCommissionRate(),
                "Earnings", earnings());
    }
}
