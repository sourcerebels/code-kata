import spock.lang.*

class FizzBuzz {
	
	static final THREE = 3
	static final FIVE = 5
	
	static divisibleBy(def number, def divisor) {
		
		return (number % divisor == 0)
	}
	
	static divisibleByThree(def number) {
		
		return divisibleBy(number, THREE)
	}

	static divisibleByFive(def number) {
		
		return divisibleBy(number, FIVE)
	}
		
	static answer(def number) {

		if (divisibleByThree(number)) {
			return "Fizz"
		}
		if (divisibleByFive(number)) {
			return "Buzz"
		}
		return number.toString()
	}
}

class FizzBuzzSpecification extends Specification {

	def "deberia responder el mismo si 1 o 2"() {
		expect:
			FizzBuzz.answer(number) == number.toString()
		where:
			number << [1, 2]			 	
	}
	
	def "deberia responder Fizz si divisible por 3"() {
		expect:
			FizzBuzz.answer(number) == "Fizz"
		where:
			number << [3, 6, 9]
	}
	
	def "deberia responder Buzz si divisible por 5"() {
		expect:
			FizzBuzz.answer(number) == "Buzz"
		where:
			number << [5, 10]
	}
	
	def "deberia responder FizzBuzz si divisible por 3 y por 5"() {
		expect:
			FizzBuzz.answer(number) == "FizzBuzz"
		where:
			number << [15, 30, 45]
	}
}
