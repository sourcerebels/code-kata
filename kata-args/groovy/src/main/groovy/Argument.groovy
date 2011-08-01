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