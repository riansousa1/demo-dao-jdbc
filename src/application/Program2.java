package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartment();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n==== TESTE 1 insert ====");
		Department dep = new Department(null, "D3");
		//depDao.insert(dep);
		System.out.println("Insert realizado! new Id = " + dep.getId());	
		
		System.out.println("\n==== TESTE 2 update ====");
		
		Department updateDep = new Department(7, "D4");
		depDao.update(updateDep);
		System.out.println("Update complete");
		
		System.out.println("\n==== TESTE 3 delete ====");
		System.out.print("Enter id for delete test: ");
		//int id = sc.nextInt();
		//depDao.deleteById(id);
		System.out.println("Deleted complete!");
		
		System.out.println("\n==== TESTE 4 findById ====");
		
		Department findDep = depDao.findById(3);
		System.out.println(findDep);
		
		System.out.println("\n==== TESTE 5 findAll ====");
		List<Department> depList = depDao.findAll();
		
		for (Department list : depList) {
			System.out.println(list);
		}
		
	}

}
