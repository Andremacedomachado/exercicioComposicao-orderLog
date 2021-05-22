package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdfBithDate = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;

	private List<OrderItem> items = new ArrayList<OrderItem>();
	private Client client;

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrderItem i : items) {
			sum += i.subtotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY:" + "\n");
		sb.append("Order moment: " + sdfBithDate.format(moment)+ "\n");
		sb.append("Order status: " + getStatus()+ "\n");
		sb.append("Client: " + client.getName() + " (" + client.getBithDate() + ") - " + client.getEmail()+ "\n");
		sb.append("Order list:" + "\n");
		for (OrderItem orderItem : items) {
			sb.append(orderItem.getProduct().getName() + ", $" + orderItem.getPrice() + ", Quantity: "
					+ orderItem.getQuantity() + ", Subtotal: $" + orderItem.subtotal()+ "\n");
		}
		sb.append("Total price: "+ total());
		 return sb.toString();
	}

}
