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
public class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private CommissionCompensationModel methodName;
    
    
    public Employee(String firstName, String lastName, 
        String socialSecurityNumber, CommissionCompensationModel methodName){  
           this.firstName = firstName;
           this.lastName =  lastName;
           this.socialSecurityNumber = socialSecurityNumber;
           this.methodName = methodName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
    
    public double earnings(){
        return methodName.getCommissionRate() * methodName.getGrossSales();
    }
    
    public void setCompensation(CommissionCompensationModel methodName){
        this.methodName = methodName;
    }
    
    @Override
    public String toString(){
        return String.format("%s %s%n%s: %s%n%s",
                getFirstName(), getLastName(),
                "Social security number", getSocialSecurityNumber(),
                methodName
                );
    }   
}
