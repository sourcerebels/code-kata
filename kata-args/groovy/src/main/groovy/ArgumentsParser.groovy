class Argument {

	final static FLAG_TYPE_SCHEMA_INDEX = 0
	final static FLAG_SCHEMA_INDEX = 1

	def flag
	def flagType
	def value
	
	def parseSchemaDefinition(def schemaDefinition) {

		flagType = schemaDefinition[FLAG_TYPE_SCHEMA_INDEX]
		flag = schemaDefinition[FLAG_SCHEMA_INDEX]
	}
}

class ArgumentsParser {

	final static SCHEMA_SEPARATOR = " "
	final static FLAG_INDICATOR = "-"
		
	def schema
	def arguments = [:]

	def parse(def text) {
		
		schemaAsList().each { argumentDefinition ->

			parseArgument(argumentDefinition, text)
		}
	}

	def getArgumentValue(String flag) {

		return arguments.get(flag).value
	}

	def getArgumentNumber() {

		return arguments.size()
	}

	private parseArgument(def argumentDefinition, def text) {
		
		Argument argument = new Argument()
		argument.parseSchemaDefinition(argumentDefinition)
		setArgumentValue(argument, text)
		addArgument(argument)
	}

	private setArgumentValue(Argument argument, def text) {
		
		def value = getArgumentValue(argument.flag, text)
		if (isValidValue(value)) {
			
			argument.value = value
		}
	}

	private addArgument(def argument) {
		
		arguments.put(argument.flag, argument)
	}

	private isFlag(def argument, def flag) {
		
		return (argument == FLAG_INDICATOR + flag)
	}
	
	private getArgumentValue(def flag, def arguments) {
		
		for (def i = 0; i < arguments.size(); i++) {
			
			if(isFlag(arguments[i], flag)) {
				
				return arguments[i + 1]
			}
		}
		return null
	}
	
	private isValidValue(def value) {

		return (value != null)
	}
	
	private schemaAsList() {

		return this.schema.split(SCHEMA_SEPARATOR)
	}
}
