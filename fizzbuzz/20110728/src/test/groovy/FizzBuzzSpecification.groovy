import spock.lang.*

class FizzBuzzSpecification extends Specification {

	FizzBuzz fizzBuzz
	
	def "setup"() {
		fizzBuzz = new FizzBuzz()
	}
	
	def "deberia responder Fizz si divisible por 3"() {
		expect:
			fizzBuzz.answer(number) == "Fizz"
		where:
			number << [3, 6, 9, 27]
	}

	def "deberia responder Buzz si divisible por 5"() {
		expect:
			fizzBuzz.answer(number) == "Buzz"
		where:
			number << [5, 10, 50, 500]
	}

	def "deberia responder FizzBuzz si divisible por 3 y por 5"() {
		expect:
			fizzBuzz.answer(number) == "FizzBuzz"
		where:
			number << [15, 30, 45]
	}

	def "deberia responder el mismo si no es divisible ni po 3 ni por 5"() {
		expect:
			fizzBuzz.answer(number) == number.toString()
		where:
			number << [1, 2, 4, 7, 22]
	}
}
