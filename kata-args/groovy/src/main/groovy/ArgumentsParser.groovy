class ArgumentsParser {

	final static FLAG_TYPE_SCHEMA_INDEX = 0
	final static FLAG_SCHEMA_INDEX = 1
	final static SCHEMA_SEPARATOR = " "
		
	def schema
	def argumentNumber = 0
	def error = ""
	
	def values = [:]

	def isFlag(def argument, def flag) {
		
		return argument.startsWith("-" + flag)
	}
	
	def addValue(def flag, def value) {
		
		values.put(flag, value)
	}

	def getArgumentValue(def flag, def arguments) {
		
		for (def i = 0; i < arguments.size(); i++) {
			
			if(isFlag(arguments[i], flag)) {
				
				return arguments[i + 1]
			}
		}
		return null
	}
	
	def isValidValue(def value) {

		return (value != null)
	}
	
	def schemaAsList() {

		return this.schema.split(SCHEMA_SEPARATOR)
	}
	
	def parse(def arguments) {

		schemaAsList().each { schemaDefinition ->
			
			def flagType = schemaDefinition[FLAG_TYPE_SCHEMA_INDEX]
			def flag = schemaDefinition[FLAG_SCHEMA_INDEX]

			def value = getArgumentValue(flag, arguments)
			if (isValidValue(value)) {
				addValue(flag, value)
				argumentNumber++
			}
		}
	}
	
	def getValue(String flag) {
		return values.get(flag)
	}
}
