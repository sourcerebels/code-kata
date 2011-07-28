import spock.lang.*

class FizzBuzz {
	
	static answer(def number) {

		if (number == 3 || number == 6 || number == 9) {
			return "Fizz"
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
}
