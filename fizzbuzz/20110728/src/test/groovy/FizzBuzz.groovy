class FizzBuzz {

	static final THREE = 3
	static final FIVE = 5

	/**
	 * Give an answer to the current game
	 *
	 * @param number    current number in the game sequence
	 * @return          appropriate answer to the current number
	 */
	def answer(def number) {

		if (divisibleByThree(number) && divisibleByFive(number)) {
			return "FizzBuzz"
		}
		if (divisibleByThree(number)) {
			return "Fizz"
		}
		if (divisibleByFive(number)) {
			return "Buzz"
		}
		return number.toString()
	}

	private divisibleBy(def number, def divisor) {

		return (number % divisor == 0)
	}

	private divisibleByThree(def number) {

		return divisibleBy(number, THREE)
	}

	private divisibleByFive(def number) {

		return divisibleBy(number, FIVE)
	}
}
