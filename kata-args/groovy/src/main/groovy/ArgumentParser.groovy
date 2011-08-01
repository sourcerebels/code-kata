class ArgumentParser {

	final static SCHEMA_SEPARATOR = " "
	final static FLAG_INDICATOR = "-"
		
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
		argument.value = getArgumentValue(argument.flag, args)
		addArgument(argument)
	}

	private addArgument(def argument) {
		
		arguments.put(argument.flag, argument)
	}

	private isFlag(def argument, def flag) {
		
		return (argument == FLAG_INDICATOR + flag)
	}
	
	private getArgumentValue(def flag, def args) {
		
		for (def i = 0; i < args.size(); i++) {
			
			if(isFlag(args[i], flag)) {
				
				return args[i + 1]
			}
		}
		return null
	}
		
	private schemaAsList() {

		return this.schema.split(SCHEMA_SEPARATOR)
	}
}
