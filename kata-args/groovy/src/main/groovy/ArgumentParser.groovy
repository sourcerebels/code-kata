class ArgumentParser {

	final static SCHEMA_SEPARATOR = " "
		
	def schema
	def arguments

	/**
	 * Parse arguments from argument list.
	 * @param args Argument list.
	 */
	def parse(List<String> args) {
		
		arguments = [:]
		schemaAsList().each { argumentDefinition ->

			parseArgument(argumentDefinition, args)
		}
	}

	/**
	 * Gets the value of an argument identified by a flag.
	 * @param flag The flag which identifies the argument.
	 * @return The value.
	 */
	def getArgumentValue(String flag) {

		return arguments.get(flag).value
	}

	/**
	 * Gets the number of parsed arguments.
	 * @return Number of parsed arguments.
	 */
	def getArgumentNumber() {

		return arguments.size()
	}

	private parseArgument(def argumentDefinition, def args) {
		
		Argument argument = new Argument()
		argument.parseSchemaDefinition(argumentDefinition)
		argument.parseArgumentValue(args)
		addArgument(argument)
	}
	
	private addArgument(def argument) {
		
		arguments.put(argument.flag, argument)
	}

	private schemaAsList() {

		return this.schema.split(SCHEMA_SEPARATOR)
	}
}
