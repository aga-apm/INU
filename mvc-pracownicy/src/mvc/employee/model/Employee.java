package mvc.employee.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	  private IntegerProperty employeeId;
	  private StringProperty firstName;  
	  private StringProperty lastName;  
	  private StringProperty email;
	  private StringProperty phoneName;
	  private ObjectProperty<LocalDate> hireDate;
	  private StringProperty jobId;
	  private IntegerProperty salary;
	  private IntegerProperty managerId;
	  private IntegerProperty departmentId; 
	  public Employee() {
		  employeeId = new SimpleIntegerProperty (0);
		  firstName = new SimpleStringProperty ("");
		  lastName = new SimpleStringProperty ("");
		  email = new SimpleStringProperty ("");
		  phoneName = new SimpleStringProperty ("");
		  hireDate = new SimpleObjectProperty <LocalDate>(LocalDate.now());
		  jobId = new SimpleStringProperty ("");
		  salary = new SimpleIntegerProperty (0);
		  managerId = new SimpleIntegerProperty (0);
		  departmentId = new SimpleIntegerProperty (0);
	  }
	  
	  
	  public Employee(int employeeId) {
		  this();
	    this.employeeId.set(employeeId);
	  }
	  
	  
	  public void setFirstName(String firstName) {
	    this.firstName.set(firstName);
	  }
	  public void setLastName(String lastName) {
	  this.lastName.set(lastName);
	  }
	  public void setEmail(String email) {
	    this.email.set(email); 
	  }
	  public void setPhoneName(String phoneName) {
	    this.phoneName.set(phoneName);
	  }
	  public void setHireDate(LocalDate hireDate) {
	    this.hireDate.set(hireDate);
	  }
	  public void setJobId(String jobId) {
	    this.jobId.set(jobId);
	  }
	  public void setSalary(int salary) {
	    this.salary.set(salary);
	  }
	  public void setManagerId(int managerId) {
	    this.managerId.set(managerId);
	  }
	  public void setDepartmentId(int departmentId) {
	    this.departmentId.set(departmentId);
	  }
	  public int getEmployeeId() {
	    return employeeId.get();
	  }
	  public IntegerProperty employeeIdProperty() {
		return employeeId;
	  }
	  public String getFirstName() {
	    return firstName.get();
	  }
	  public StringProperty firstNameProperty() {
		    return firstName;
		  }
	  public StringProperty FirstName() {
		    return firstName;
		  }
	  public String getLastName() {
	    return lastName.get();
	  }
	  public StringProperty lastNameProperty() {
		    return lastName;
		  }
	  
	  public String getEmail() {
	    return email.get();
	  }
	  public StringProperty emailProperty() {
		    return email;
		  }
	  public String getPhoneName() {
	    return phoneName.get();
	  }
	  public StringProperty phoneNameProperty() {
		    return phoneName;
		  }
	  public LocalDate getHireDate() {
	    return hireDate.get();
	  }
	  public ObjectProperty<LocalDate> hireDateProperty() {
		    return hireDate;
		  }
	  public String getJobId() {
	    return jobId.get();
	  }
	  public StringProperty jobIdProperty() {
		    return jobId;
		  }
	  public int getSalary() {
	    return salary.get();
	  }  
	  public IntegerProperty salaryProperty() {
		    return salary;
	 } 
	
	  public int getManagerId() {
	    return managerId.get();
	  }
	  public IntegerProperty managerIdProperty() {
		    return managerId;
	 }
	  public int getDepartmentId() {
	    return departmentId.get();
	  }
	  public IntegerProperty departmentIdProperty() {
		    return departmentId;
		  }
	  @Override
	  public String toString() {
	    return lastName + " " +  firstName ;
	  }
	} // public class Employee 
