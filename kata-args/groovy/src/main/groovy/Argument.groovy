class Argument {

	final static STRING = "s"
	final static BOOLEAN = "b"
	final static NUMBER = "n"
	
	final static FLAG_TYPE_SCHEMA_INDEX = 0
	final static FLAG_SCHEMA_INDEX = 1
	final static FLAG_INDICATOR = "-"
	final static DEFAULT_TYPE = 2
	
	def flag
	def type = DEFAULT_TYPE
	def value
	
	def parseSchemaDefinition(def schemaDefinition) {

		type = schemaDefinition[FLAG_TYPE_SCHEMA_INDEX]
		flag = schemaDefinition[FLAG_SCHEMA_INDEX]
	}

	def parseArgumentValue(def args) {

		def tmpValue = null		
		for (def i = 0; i < args.size(); i++) {

			def currentArgument = args[i]
			if(isFlag(currentArgument, flag)) {

				if (isBoolean()) {
					
					tmpValue = "true"

				} else {

					tmpValue = args[i+1]
				}
			}
		}
		setValue(tmpValue == null ? "" : tmpValue)
	}
	
	def setValue(String value) {
		
		switch(type) {

			case STRING:
				this.value = value
			break
			case BOOLEAN:
				this.value = value == "" ? false : true
			break
			case NUMBER:
				this.value = value.toInteger()
			break
		}
	}
	
	private isBoolean() {
		return (type == BOOLEAN);
	}
	
	private static isFlag(def text, def flag) {
		
		return (text == FLAG_INDICATOR + flag)
	}
}