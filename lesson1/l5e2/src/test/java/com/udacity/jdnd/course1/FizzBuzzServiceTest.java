package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}

	@Test
	void testBuzzFizz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check how Buzz works
		assertEquals(15, fbs.buzzFizz("Buzz", 3));
		assertEquals(5, fbs.buzzFizz("Buzz", 1));
		assertEquals(0, fbs.buzzFizz("Buzz", 0));

		// check how Fizz works
		assertEquals(9, fbs.buzzFizz("Fizz", 3));
		assertEquals(3, fbs.buzzFizz("Fizz", 1));
		assertEquals(0, fbs.buzzFizz("Fizz", 0));

		// check how FizzBuzz works
		assertEquals(45, fbs.buzzFizz("FizzBuzz", 3));
		assertEquals(15, fbs.buzzFizz("FizzBuzz", 1));
		assertEquals(0, fbs.buzzFizz("FizzBuzz", 0));

		// catch exception
		assertThrows(NumberFormatException.class, () -> fbs.buzzFizz("String", 10));

		// check parsing
		assertEquals(10, fbs.buzzFizz("10", 1));

	}

}
