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
public class BasePlusCommissionCompensationModel extends CommissionCompensationModel {
    private double baseSalary;
    
    public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary){
        super(grossSales, commissionRate);
        if(baseSalary < 0.0){
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;  
    }

    public double earnings(){
        return baseSalary + super.earnings();
    }
    
    @Override
    public String toString(){
        return String.format("%s: %n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f",
           "Base Plus Commission Compensation with", 
           "Gross Sales of", super.getGrossSales(),
           "Commission Rate of", super.getCommissionRate(),
           "Base Salary of", baseSalary,
           "Earnings", earnings());
    }
}

