package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import db.DB;
import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;


public class Program2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		DepartmentDAO depDAO = DAOFactory.createDepartmentDAO();
		
		System.out.println("=== TEST 1: DEPARTMENT FINDBYID ===");
		Department dep = depDAO.findById(4);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: DEPARTMENT FINDALL ===");
		List<Department> depList = depDAO.findAll();
		depList.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: DEPARTMENT INSERT ===");
		Department newDep = new Department(null, "Food");
		depDAO.insert(newDep);
		System.out.println("Insert completed! ID generated: " + newDep.getId());
		
		System.out.println("\n=== TEST 4: DEPARTMENT UPDATE ===");
		dep = depDAO.findById(2);
		dep.setName("Music");
		depDAO.update(dep);
		System.out.println("Updated!");
		
		System.out.println("\n=== TEST 5: DEPARTMENT DELETE ===");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Insert department ID to delete: ");
			int id = sc.nextInt();
			depDAO.deleteById(id);
			System.out.println("Deleted!");
		}
		
		DB.closeConnection();
		

	}

}
