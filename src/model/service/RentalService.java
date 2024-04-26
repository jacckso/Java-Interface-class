package model.service;

import java.time.Duration;

import model.entites.CarRental;
import model.entites.Invoice;

public class RentalService {
		
	private Double pricePerHour;
	
	private Double pricePerDay;
	private TaxService tax;
	

	public RentalService(Double pricePerHour, Double pricePerDay,  TaxService tax) {
		super();
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.tax = tax;
	}

	public void processInvoice(CarRental cr) {
		double minutes = Duration.between(cr.getStart(), cr.getFinish()).toMinutes();
		double hours = minutes /60.0;
		double basicPayment = pricePerHour;	
		if(hours<= 12) {
				basicPayment = pricePerHour * Math.ceil(hours);
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours /24.0);
				
		}
			Double taxService = tax.tax(basicPayment) ;
			cr.setInvoice(new Invoice(basicPayment, taxService));
	}

}
