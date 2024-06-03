package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print(" How many employees will be registered? ");
		Double n = sc.nextDouble();
		List<Funcionario> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employee "+ (i+1)+ ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			list.add(new Funcionario(id, name, salary));						
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			Double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employee:");
		for(Funcionario obj : list) {
			System.out.println(obj);
		}
			
		sc.close();
	}

}
