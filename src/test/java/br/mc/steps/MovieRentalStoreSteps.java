package br.mc.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.mc.enums.RentalType;
import br.mc.entidades.Movie;
import br.mc.entidades.RentalReceipt;
import br.mc.services.RentService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MovieRentalStoreSteps {
	
	private Movie movie;
	private RentService rentService = new RentService();
	private RentalReceipt receipt;
	private RentalType type;
	private String error;

	@Given("There are {int} units in the inventory")
	public void thereAreUnitsInTheInventory(int units) {
		movie = new Movie();
		movie.setUnits(units);
	}
	
	@Given("It costs ${int} to rent")
	public void itCosts$ToRent(int price) {
		movie.setPrice(price);
	}
	
	@Given("The rental type is {string}")
	public void theRentalTypeIs(String rentalType) {
			type = RentalType.valueOf(rentalType.toUpperCase());
	}
	
	@When("I rent")
	public void iRent() {
		try {
			receipt = rentService.rent(movie, type);
		} catch (RuntimeException e) {
			error = e.getMessage();	
		}
	}
	
	@Then("The movie has cost ${int} to rent")
	public void theMovieHasCost$ToRent(int price) {
	    Assert.assertEquals(price, receipt.getPrice());
	}
	
	@Then("The due date will be in {int} days")
	public void theDueDateWillBeInDays(int amount) {
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DAY_OF_MONTH, amount);
	    
	    Date returnDate = receipt.getReturnDate();
	    Calendar calReturn = Calendar.getInstance();
	    calReturn.setTime(returnDate);
	    
	    Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calReturn.get(Calendar.DAY_OF_MONTH));
	    Assert.assertEquals(cal.get(Calendar.MONTH), calReturn.get(Calendar.MONTH));
	    Assert.assertEquals(cal.get(Calendar.YEAR), calReturn.get(Calendar.YEAR));
	}
	
	@Then("There will be {int} units in the inventory")
	public void thereWillBeUnitsInTheInventory(int units) {
	    Assert.assertEquals(units, movie.getUnits());
	}

	@Then("It is not possible because there is no units left")
	public void itIsNotPossibleBecauseThereIsNoUnitsLeft() {
	    Assert.assertEquals("No movies left to rent", error);
	}

	@Then("The score received will be {int} points")
	public void theScoreReceivedWillBePoints(int points) {
		Assert.assertEquals(points, receipt.getScore());
	}
}
