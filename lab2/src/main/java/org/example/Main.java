package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main<T extends Product,L extends  Long> extends ProductDAO<Product,Long>{
	public static void main(String[] args) {
		ProductDAO<Product,Long> pr = new ProductDAO<>();
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		while (option != 6) {
			System.out.println("Menu:");
			System.out.println("1. Read all product");
			System.out.println("2. Read detail of a product by id");
			System.out.println("3. Add a new product");
			System.out.println("4. Update a product");
			System.out.println("5. Delete a product by id");
			System.out.println("6. Exit");
			System.out.print("Your choice:");
			option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
				case 1:
					// Xử lý tùy chọn 1
					pr.readAll();
					break;
				case 2:
					// Xử lý tùy chọn 2
					System.out.print("Nhap id:");
					Long id = scanner.nextLong();
					pr.read(id);
					break;
				case 3:
					// Xử lý tùy chọn 3
					int idproduct;
					double priceproduct;
					System.out.println("input product information:");
					System.out.print("id:");
					idproduct = scanner.nextInt();
					System.out.print("name:");
					String name = scanner.next();
					System.out.print("price:");
					priceproduct = scanner.nextDouble();
					pr.add(new Product(idproduct,name,priceproduct));
					break;
				case 4:
					System.out.println("Input id to update");
					int idupdate = scanner.nextInt();
					System.out.print("name:");
					String nameup = scanner.next();
					System.out.print("price:");
					Double priceup = scanner.nextDouble();
					pr.update(new Product(idupdate,nameup,priceup));
					break;
				case 5:
					System.out.print("Input id to delete:");
					long iddelete = scanner.nextInt();
					pr.delete(iddelete);
					break;
				default:
					System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
					break;
			}
		}
	}
}