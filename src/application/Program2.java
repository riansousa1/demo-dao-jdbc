package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n==== TESTE insert ====");
		DepartmentDao depDao = DaoFactory.createDepartment();
		Department dep = new Department(null, "D3");
		depDao.insert(dep);
		System.out.println("Insert realizado! new Id = " + dep.getId());	
		
		
	}

}
