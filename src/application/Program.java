package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	public static void main(String[]args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees : ");
		int n = sc.nextInt();
		
		for(int x = 1; x < n; x++) {
			System.out.println("Employee #" + x + " data : ");
			System.out.print("Outsourced (y/n) ? ");
			char c = sc.next().charAt(0);
			System.out.print("Name : ");
			String name = sc.nextLine();
			System.out.print("Hours : ");
			int hours = sc.nextInt();
			System.out.print("Valur per hour : ");
			double value = sc.nextDouble();
			
			if(c == 'y') {
				System.out.print("Additional charge : ");
				double add = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hours, value, add);
				list.add(emp);
			}else {
				Employee emp = new Employee(name, hours, value);
				list.add(emp);
			}
			
			
			System.out.println();
			System.out.println("PAYMENTS : ");
			
			for(Employee emp : list) {
				System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
			}
			
			sc.close();
			
		}
	}
}
