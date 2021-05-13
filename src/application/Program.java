package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
	}

}
