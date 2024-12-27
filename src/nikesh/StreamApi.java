package nikesh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApi {

	public static void main(String[] args) throws ParseException {
		 SimpleDateFormat formate=new SimpleDateFormat("dd-mm-yyyy");
		 Date joiningDateRam=formate.parse("01-01-2000");
		 Date joiningDateShyam=formate.parse("01-08-2005");
		 Date joiningDateMohan=formate.parse("04-01-2009");
		 Date joiningDateSita=formate.parse("12-10-2000");
		 List<Employee> listofemp=Arrays.asList(
				 new Employee("ram",25000,joiningDateRam,"male"),
				 new Employee("shyam",30000,joiningDateShyam,"male"),
				 new Employee("mohan",12000,joiningDateMohan,"male"),
				 new Employee("sita",40000,joiningDateSita,"female")
				 
				 );
		 System.out.println(listofemp);
		 Employee maximumSal=listofemp.stream().max((a,b)->Double.compare(a.getSalary(), b.getSalary())).get();
		 System.out.println(maximumSal);
		 Employee minimumSal=listofemp.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
		 System.out.println(minimumSal);
		 Employee secondHighistsal=listofemp.stream().sorted((a,b)->Double.compare(b.getSalary(), a.getSalary())).skip(1).findFirst().get();
		 System.out.println(secondHighistsal);
		 Optional<Employee> lowestJoiningDate=listofemp.stream().min((a,b)->a.getJoinDate().compareTo(b.getJoinDate()));
		 lowestJoiningDate.ifPresent(System.out::print);
		 long totalMail=listofemp.stream().filter(i->i.getGender().equalsIgnoreCase("male")).count();
		 System.out.println(totalMail);
           Map<String,Long> result=listofemp.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
           System.out.println(result);
}
}
class Employee
{
	private String name;
	private double salary;
	private Date joinDate;
	private String gender;
	
	
	public Employee(String name, double salary, Date joinDate, String gender) {
		super();
		this.name = name;
		this.salary = salary;
		this.joinDate = joinDate;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", joinDate=" + joinDate + ", gender=" + gender + "]";
	}
	
	
}
