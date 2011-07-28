import spock.lang.*

class FizzBuzz {
	
	static divisibleByThree(def number) {
		
		return (number % 3 == 0)
	}

	static divisibleByFive(def number) {
		
		return (number % 5 == 0)
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
}
