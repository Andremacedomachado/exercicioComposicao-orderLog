package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		
		System.out.print("name ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.println("Bith date (DD/MM/YYYY):");
		Date bithDate = sdf.parse(sc.next());
		Client client = new Client(name, email, bithDate);
		
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(status),client);
		
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		for(int i = 1;i<=n;i++) {

			sc.nextLine();

			System.out.println("Enter #"+i+" item data:	");
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			Product product = new Product(nameProduct, price);
			OrderItem orderItem = new OrderItem(quantity, product);
			order.addItem(orderItem);
		}
		
		System.out.println(order.toString());
		
		
		
		
		sc.close();
	}

}
