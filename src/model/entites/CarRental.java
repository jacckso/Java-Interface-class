package model.entites;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CarRental {

	private LocalDateTime start;
	private LocalDateTime finish;

	private Invoice invoice;
	private vehicle vehicle;
	
	public CarRental(LocalDateTime start, LocalDateTime finish, vehicle vehicle2) {
		super();
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle2;
	}
	
	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(vehicle model) {
		this.vehicle = model;
	}
	
	
}
