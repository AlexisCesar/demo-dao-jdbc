package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Department obj = new Department(1, "Coffee");
		
		System.out.println(obj);
		
		Seller seller = new Seller(10, "Alexis", "alexis@gmail.com", sdf.parse("21/03/2001"), 6500.00, obj);
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		System.out.println(seller);
		
	}

}
