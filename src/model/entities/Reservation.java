package model.entities;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

import java.util.Date;

public class Reservation {
	private Integer roomNumer;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Observação

	public Reservation(Integer roomNumer, Date checkIn, Date checkOut) {
		if(checkIn.after(checkOut)) 
		throw new DomainException( "Check-out date must be after check-in date");
		this.roomNumer = roomNumer;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
		
	public Integer getRoomNumer() {
		return roomNumer;
	}
	
	public void setRoomNumer(Integer roomNumer) {
		this.roomNumer = roomNumer;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //Estudar sobre TimeUnit
	}
	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(checkOut)) 
			throw new DomainException("Reservation dates for update must be future dates.");
		
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "Room " + roomNumer + ", check-in: " + sdf.format(checkIn) + ", check-out: " 
				+ sdf.format(checkOut) + ", " + duration() + " nights.";
	}
	
}
