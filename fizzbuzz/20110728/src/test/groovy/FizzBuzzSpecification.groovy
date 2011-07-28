import spock.lang.*


class FizzBuzz {
	
	static answer(def number) {
		return null
	}
}

class FizzBuzzSpecification extends Specification {

	def "deberia responder el mismo si 1"() {
		expect:
			FizzBuzz.answer(1) == "1"			 	
	}

}
