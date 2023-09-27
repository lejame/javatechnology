package org.example;
import java.lang.*;
import java.sql.Connection;
import java.time.Period;
import java.util.List;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class ProductDAO<T extends Product,K extends Long> implements Repository<Product, Long> {
	private final String select = "SELECT id, name, price FROM product";
	private final String select_id = "select * from product where id = ?";
	private final String insert = "insert into product (id,name,price) values(?,?,?)";
	private final String update = "update product set name = ? ,price = ? where id = ?";
	private final String delete = "delete from product where id = ?";
	private static String url = "jdbc:mysql://localhost:3306/productmanagement";

	private final Product product = new Product();
	//	private String
	public static Connection connected() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			System.out.print("Không thể kết nối");
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public Long add(Product item) {
		List<Product> result = new ArrayList<>();
		try{
			Connection con= connected();
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setLong(1,item.getId());
			preparedStatement.setString(2,item.getName());
			preparedStatement.setDouble(3,item.getPrice());
			preparedStatement.executeUpdate();
			System.out.println("Add sucessfully");
			preparedStatement.close();
			return product.getId();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Product> readAll() {
		List<Product> result = new ArrayList<>();
		try (Connection con = connected();
		     PreparedStatement preparedStatement = con.prepareStatement(select);
		     ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				Product obj = new Product((int) id, name, price);
				System.out.println(obj.toString());
				result.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Product read(Long id) {
		try (Connection con = connected();
		     PreparedStatement preparedStatement = con.prepareStatement(select_id);
		) {
//			covert long thanh int
			preparedStatement.setInt(1, Math.toIntExact(id));
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					long id1 = resultSet.getLong("id");
					String name = resultSet.getString("name");
					double price = resultSet.getDouble("price");
					Product obj = new Product((int) id1, name, price);
					System.out.println(obj.toString());
					return obj;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Product item) {
		try(Connection con= connected();
		    PreparedStatement preparedStatement = con.prepareStatement(update);) {
			preparedStatement.setString(1,item.getName());
			preparedStatement.setDouble(2,item.getPrice());
			preparedStatement.setLong(3,item.getId());
			preparedStatement.executeUpdate();
			System.out.println("Update sucessfully");
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try{
			Connection con= connected();
			PreparedStatement preparedStatement = con.prepareStatement(delete);
			preparedStatement.setLong(1,id);
			preparedStatement.executeUpdate();
			System.out.println("Delete sucessfully");
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
