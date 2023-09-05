package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.Enum.OrderStatus;

public class Principal {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
		SimpleDateFormat dn = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("Enter cliente data: ");
		System.out.print("Nome: ");
		String nome = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data de Nascimento: ");
		Date dataNascimento = dn.parse(sc.next());
		
		Client client = new Client (nome, email, dataNascimento);
		
		
		
		OrderStatus status = OrderStatus.PROCESSING;
		
		Order order = new Order (new Date(), status, client);
		
		System.out.print("Quantos itens para este pedido? ");
		int n = sc.nextInt();
		for(int i = 1; i <= n ; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Nome do Produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço do Produto: ");
			Double precoProduto = sc.nextDouble();
			System.out.print("Quantidade do Produto: ");
			Integer quantity = sc.nextInt();
			
			
			Product product = new Product (nomeProduto, precoProduto);
			OrderItem orderItem = new OrderItem (quantity, precoProduto, product);
			
			order.adicionarItem(orderItem);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());
		
		
		
		sc.close();
		

	}

	
	

}

