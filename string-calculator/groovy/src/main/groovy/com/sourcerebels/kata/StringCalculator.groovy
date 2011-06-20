package com.sourcerebels.kata

class Numbers {

	private final String DEFAULT_DELIMITER = ","
	private final String CUSTOM_DELIMITER_INDICATOR = "//"
	private final int NUMBER_WITH_CUSTOM_DELIMITER_START_POSITION = 4
	private final int CUSTOM_DELIMITER_POSITION = 2
	private final String NEW_LINE = "\\n"

	String numbers
	String delimiter = DEFAULT_DELIMITER

	public Numbers(String numbers) {

		setDelimiter numbers
		setNumbers numbers		
	}

	public boolean isEmpty() {

		numbers.size() == 0
	}

	public void replaceEndLinesWithDelimiter() {

		numbers = numbers.replaceAll(NEW_LINE, delimiter)
	}

	public int sum() {

		numbers.split(delimiter).collect { Integer.valueOf(it) }.sum()
	}
	
	public boolean containsNegatives() {

		negatives().size() > 0
	}
	
	public List<String> negatives() {
		
		numbers.split(delimiter).findAll { Integer.valueOf(it) < 0 }
	}
		
	private void setNumbers(String numbers) {

		if (hasCustomDelimiter(numbers)) {
			this.numbers = getNumbersWithoutCustomDelimiter(numbers)
		} else {
			this.numbers = numbers
		}
	}
	
	private void setDelimiter(String numbers) {

		if (hasCustomDelimiter(numbers)) {
			delimiter = getCustomDelimiter(numbers)
		}
	}

	private boolean hasCustomDelimiter(String numbers) {

		numbers.startsWith(CUSTOM_DELIMITER_INDICATOR)
	}
	
	private String getNumbersWithoutCustomDelimiter(String numbers) {

		numbers.substring(NUMBER_WITH_CUSTOM_DELIMITER_START_POSITION)
	}

	private String getCustomDelimiter(String numbers) {

		numbers[CUSTOM_DELIMITER_POSITION]
	}
}

class StringCalculator {

	public int add(String text) {

		Numbers numbers = new Numbers(text)

		if (numbers.isEmpty()) {

			return 0
		}

		numbers.replaceEndLinesWithDelimiter()
	
		if (numbers.containsNegatives()) {
			
			throw new NumberFormatException(numbers.negatives().toString())
		}
		return numbers.sum()
	}
}
