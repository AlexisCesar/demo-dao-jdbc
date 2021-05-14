package application;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n=== TEST 4: SELLER INSERT ===");
		Seller newSeller = new Seller(null, "Alexis", "alexis@gmail.com", new Date(), 6000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted, new id: " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: SELLER UPDATE ===");
		seller = sellerDao.findById(7);
		seller.setName("Angel");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: SELLER DELETE ===");
		System.out.print("Enter seller id: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
