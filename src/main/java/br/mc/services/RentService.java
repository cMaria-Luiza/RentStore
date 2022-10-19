package br.mc.services;

import br.mc.enums.RentalType;
import br.mc.entidades.Movie;
import br.mc.entidades.RentalReceipt;
import br.mc.utils.DateUtils;

public class RentService {
	
	public RentalReceipt rent(Movie movie, RentalType type) {
		if(movie.getUnits() == 0) 
			throw new RuntimeException("No movies left to rent");
		
		RentalReceipt receipt = new RentalReceipt();
		switch (type) {
			case REGULAR:
				receipt.setPrice(movie.getPrice());
				receipt.setReturnDate(DateUtils.getDateWithDaysDiference(1));
				receipt.setScore(1);
				break;
			case EXTENDED:
				receipt.setPrice(movie.getPrice()*2);
				receipt.setReturnDate(DateUtils.getDateWithDaysDiference(3));
				receipt.setScore(2);
				break;
			case WEEKLY:
				receipt.setPrice(movie.getPrice()*3);
				receipt.setReturnDate(DateUtils.getDateWithDaysDiference(7));
				receipt.setScore(3);
				break;
			default:
				break;
		}
		movie.setUnits(movie.getUnits()-1);
		return receipt;
	}
}
