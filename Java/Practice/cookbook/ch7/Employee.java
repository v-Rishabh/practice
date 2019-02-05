import java.util.*;

public class Employee implements Comparable<Employee>{
	
	private int id;
	private String name;
    private int age;
    private long salary;
	
	public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
	}
	
	
	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }
	

	public int compareTo(Employee emp){
		return this.id - emp.id;
	}

    //this is required to print the user friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + "]\n";
    }
}