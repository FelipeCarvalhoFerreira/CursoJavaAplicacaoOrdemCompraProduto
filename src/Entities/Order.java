package Entities;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entities.Enum.OrderStatus;

public class Order {

	private Date data;
	private OrderStatus status;

	
	private Client client;
	private List<OrderItem> orderItens = new ArrayList<OrderItem>();

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
	
	public Order(Date data, OrderStatus status, Client client) {
		this.data = data;
		this.status = status;
		this.client = client;
		
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getCliente() {
		return client;
	}

	public void setCliente(Client cliente) {
		this.client = cliente;
	}

	public void adicionarItem(OrderItem orderItem) {
		orderItens.add(orderItem);
	}

	public void removerItem(OrderItem orderItem) {
		orderItens.remove(orderItem);
	}
	

	public Double total() {
		double sum = 0.0;
		for (OrderItem orderItem : orderItens) {
			sum = sum + orderItem.subTotal();
		} 

		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(data) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");	
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem orderItem : orderItens ) {
			sb.append(orderItem + "\n");
		}
		sb.append("Total price: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	
	}

}
