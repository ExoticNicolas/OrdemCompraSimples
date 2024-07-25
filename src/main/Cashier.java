package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Cashier {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Client client = new Client();
		
		System.out.println("Enter Client Date: ");
		System.out.print("Name: ");
		client.setName(sc.nextLine());
		System.out.print("E-mail: ");
		client.setEmail(sc.nextLine());
		System.out.print("Birth Date (DD/MM/YYYY): ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		client.setBirthDate(sdf.parse(sc.nextLine()));
		
		System.out.println("Enter Order Data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How Many Itens to This Order: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter # " + (i+1) + " item Data");
			System.out.println("Product Name: ");
			String pName = sc.nextLine();
			System.out.println("Product Price: ");
			Double pPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();
			Product product = new Product(pName,pPrice);
			OrderItem item = new OrderItem(quantity, pPrice, product);
			order.addItem(item);
			
		}
		
		System.out.println(order);
		
		
		
		sc.close();
	}
	

}
