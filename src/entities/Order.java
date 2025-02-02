package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> itens = new ArrayList<>();
	
	private Client client;
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
		
	}
	public void removeItem(OrderItem item) {
		itens.remove(item);
		
	}
	
	public Double total() {
		Double sum = 0.0;
		for(OrderItem item: itens) {
			sum+=item.subtotal();	
		}
		return sum;
	}
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getList(){
		return itens;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb.append("Order Summary:" + "\n");
			sb.append("----------------------------------------------------------------------------------------- \n");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			sb.append("Order Moment: " + sdf.format(getMoment()) + "\n");
			sb.append("Order Status: " + getStatus() + "\n");
			sb.append("Cliente: ");
			sb.append(client + "\n");
			sb.append("----------------------------------------------------------------------------------------- \n");
			for(OrderItem c : itens) {
			sb.append(c +  "\n");
			sb.append("----------------------------------------------------------------------------------------- \n");
		}
			sb.append("Total Price: " + total() + "\n");
		return sb.toString();
	}
	
}
