
package MotorPH;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Data {
    
    private String _employeeNo;
    private String _employeeFN;
    private String _employeeLN;
    private String _employeeAddress;
    private String _employeeDOB;
    private String _employeePhoneNumber;
    private String _employeeSSS;
    private String _employeePhilHealth;
    private String _employeeTIN;
    private String _employeePagIbig;
    private String _employeeStatus;
    private String _employeePosition;
    private String _employeeSupervisor;
    private double _rice;
    private double _phone;
    private double _cloth;
    private double _hrRate;
    DecimalFormat df = new DecimalFormat("#,##0.00");
    
    
    
    //Getter Methods
    public String EmployeeNo(){
        return _employeeNo;
    }
    
    public String EmployeeFN(){
        return _employeeFN;
    }
    
    public String EmployeeLN(){
        return _employeeLN;
    }
    
    public String EmployeeDOB(){
        return _employeeDOB;
    }
    
    public String EmployeeAddress(){
        return _employeeAddress;
    }
    
    public String EmployeePhoneNumber(){
        return _employeePhoneNumber;
    }
 
    public String EmployeeSSS() {
        return _employeeSSS;
    }

    public String EmployeePhilHealth() {
        return _employeePhilHealth;
    }

    public String EmployeeTIN() {
        return _employeeTIN;
    }

    public String EmployeePagIbig() {
        return _employeePagIbig;
    }

    public String EmployeeStatus() {
        return _employeeStatus;
    }

    public String EmployeePosition() {
        return _employeePosition;
    }

    public String EmployeeSupervisor() {
        return _employeeSupervisor;
    }

    public double RiceAllowance(){
        return _rice;
    }
    
    public double PhoneAllowance(){
        return _phone;
    }
    
    public double ClothAllowance(){
        return _cloth;
    }
    
    public double HourlyRate(){
        return _hrRate;
    }
    
    
   
   //Setter Methods
    public void SetEmployeeNo(String EmployeeNo){
        _employeeNo = EmployeeNo;
    }
    
    public void SetEmployeeFN(String EmployeeFN){
        _employeeFN = EmployeeFN;
    }
    
    public void SetEmployeeLN(String EmployeeLN){
        _employeeLN = EmployeeLN;
    }
    
    public void SetEmployeeAddress(String EmployeeAddress){
        _employeeAddress = EmployeeAddress;
    }
    
    
    public void ReadEmployee(String search)throws FileNotFoundException, IOException, CsvValidationException {
        String filename = "Employee Data.csv";
        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] headers = reader.readNext();
        String[] employeeData;
        while((employeeData = reader.readNext()) != null){
            if(employeeData[0].equals(search)){
                _employeeNo = employeeData[0];
                _employeeLN = employeeData[1];
                _employeeFN = employeeData[2];
                _employeeDOB = employeeData[3];
                _employeeAddress = employeeData[4];
                _employeePhoneNumber = employeeData[5];
                _employeeSSS = employeeData[6];
                _employeePhilHealth = employeeData[7];
                _employeeTIN = employeeData[8];
                _employeePagIbig = employeeData[9];
                _employeeStatus = employeeData[10];
                _employeePosition = employeeData[11];
                _employeeSupervisor = employeeData[12];
                _rice = Double.parseDouble(employeeData[14]);
                _phone = Double.parseDouble(employeeData[15]);
                _cloth = Double.parseDouble(employeeData[16]);
                _hrRate = Double.parseDouble(employeeData[18]);
                
                //SHOWS EMPLOYEE DETAILS
                /*System.out.println();
                System.out.println("Employee No.: " + EmployeeNo());
                System.out.println("Employee Name: " + EmployeeFN() +" "+ EmployeeLN());
                System.out.println("Birthday: " + EmployeeDOB());
                System.out.println("Address: " + EmployeeAddress());*/
                break;
            }
                
        }
        
    }
    
}
