package tests;

import program.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import program.Customer;
import program.Movie;
import program.Rental;

class ResultCheck {

	@Test
	void test1() {
		String result;
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(r1);   
        c1.addRental(r2);   
        result = c1.statement();
        System.out.println(result);
        assertEquals(result, 
        		"Rental Record for joe\n" + 
        		"\tTitle\t\tDays\tAmount\n" + 
        		"\tmovie1\t\t10\t30.0\n" + 
        		"\tmovie2\t\t5\t4.5\n" + 
        		"Amount owed is 34.5\n" + 
        		"You earned 3 frequent renter points"
        		);	
	}
	
	@Test
	void test2() {
		String result;
        Movie m1 = new Movie("xyz", 1);
        Movie m2 = new Movie("abc", 2);
        Rental r1 = new Rental(m1, 100);
        Rental r2 = new Rental(m2, 3);
        Customer c1 = new Customer("Steve");
        c1.addRental(r1);   
        c1.addRental(r2);   
        result = c1.statement();
        System.out.println(result);
        assertEquals(result, 
        		"Rental Record for Steve\n" + 
        		"\tTitle\t\tDays\tAmount\n" + 
        		"\t" + m1.getTitle() +"\t\t" + r1.getDaysRented() + "\t300.0\n" + 
        		"\t"+ m2.getTitle() + "\t\t" + r2.getDaysRented() + "\t1.5\n" + 
        		"Amount owed is 301.5\n" + 
        		"You earned 3 frequent renter points"
        		);	
	}
}
