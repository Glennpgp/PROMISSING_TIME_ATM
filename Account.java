/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import java.text.DecimalFormat;
/**
 *
 * @author glenn
 */
public class Account {

    //Declaring the some variables which are essential
    double chequeBalance = 0;
    private int customerNum;
    private int PinCode;

    //Declaring a Decimal format for the Console aesthatic 
    DecimalFormat mat = new DecimalFormat("'$'###,##0.00");

    /**
     * @return the chequeBalance
     */
    public double getChequeBalance() {
        return chequeBalance;
    }

    /**
     * @param chequeBalance the checkBalance to set
     */
    public void setChequeBalance(double chequeBalance) {
        this.chequeBalance = chequeBalance;
    }

    /**
     * @return the customerNum
     */
    public int getCustomerNum() {
        return customerNum;
    }

    /**
     * @param customerNum the customerNum to set
     */
    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    /**
     * @return the PinCode
     */
    public int getPinCode() {
        return PinCode;
    }

    /**
     * @param PinCode the PinCode to set
     */
    public void setPinCode(int PinCode) {
        this.PinCode = PinCode;
    }
    //Returning the cheque withdraw after subtracting from the total amount

    public double CalculateChequeWithdraw(double totalAmount) {
        chequeBalance = (chequeBalance -= totalAmount);
        return chequeBalance;
    }
    //Returning the cheque withdraw after subtracting from the total amount

    public double CalculateChequeDeposit(double totalAmount) {
        chequeBalance = (chequeBalance += totalAmount);
        return chequeBalance;
    }

}
