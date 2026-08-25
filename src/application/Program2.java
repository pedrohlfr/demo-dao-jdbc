package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("\n=== TEST 1: department insert ===");
		Department newDepartment = new Department(13, "Fruits");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = "+ newDepartment.getId());
		
		
		
		System.out.println("\n=== TEST 2: department update ===");
		Department department = departmentDao.findById(1);
		department.setName("Computers");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		
		System.out.println("\n=== TEST 3: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		System.out.println("\n=== TEST 4: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department item: list) {
			System.out.println(item);
		}
		
		
		sc.close();
	}

}
