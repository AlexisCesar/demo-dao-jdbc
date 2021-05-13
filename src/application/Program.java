package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		System.out.println("=== TEST 1: SELLER FINDBYID ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: SELLER FINDBYDEPARTMENT ===");
		
		Department department = new Department(2, null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: SELLER FINDALL ===");
		
		list = sellerDao.findAll();
		
		list.forEach(System.out::println);
		
	}

}
