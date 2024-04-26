
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entites.CarRental;
import model.entites.vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("entre o modelo do carro ");
		String model = sc.nextLine();
		System.out.println("data de entrada");
		LocalDateTime Start = LocalDateTime.parse(sc.nextLine(), sdf);
		System.out.println("data de saida");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), sdf);
		
		CarRental cr = new CarRental(Start, finish, new vehicle(model));

		System.out.println("entre com o pre�o por hora");
		double pricePerHour = sc.nextDouble();
		System.out.println("entre com o pre�o por dia");
		double pricePerDay = sc.nextDouble();
		RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

		rs.processInvoice(cr);
		
		System.out.println("fatura:");
		System.out.println("pagamento b�sico :" + cr.getInvoice().getBasicPayment());
		System.out.println("imposto: " +cr.getInvoice().getTax());
		System.out.println("pagamento total " + cr.getInvoice().total());
		
		sc.close();
		
	}
}
