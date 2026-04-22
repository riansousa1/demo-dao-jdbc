package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("=== TESTE 1 findById ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		
		System.out.println("\n=== TESTE 2 findByDepartment ===");
		
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TESTE 3 findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 4 insert ===");
		
		Seller newSeller = new Seller(null, "Joao", "joao@gmail", new Date(), 2000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Insert! new Id = " + newSeller.getId());
		
		
	}

}
