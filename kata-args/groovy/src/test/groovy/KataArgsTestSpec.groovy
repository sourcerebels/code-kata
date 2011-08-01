import spock.lang.Specification;
import spock.lang.Unroll;

class KataArgsTestSpec extends Specification {

	def parser
	
	def "setup"() {
		parser = new ArgumentsParser()
	}
	
	@Unroll
	def "should parse a simple string value"() {
		
		setup:
			parser.schema = schema
			parser.parse(arguments)
		expect:
			parser.argumentNumber == 1
			parser.getArgumentValue(flag) == result
<<<<<<< HEAD
		where: "different schemas, one string argument"
=======
		where: "Arguments are one string value"
>>>>>>> b371cc1e1eb56f9504bf0ae45d65fe1d1f7e5861
			schema | flag | arguments       | result
			"sv"   | "v" | ["-v", "value"] | "value"
			"sb"   | "b" | ["-b", "bcn"]   | "bcn"
	}
	
	@Unroll
	def "should parse two string values"() {
		
		setup:
			parser.schema = schema
			parser.parse(arguments)
		expect:
			parser.argumentNumber == 2
			parser.getArgumentValue(flag) == result
<<<<<<< HEAD
		where: "different schemas, two strings, arguments are unordered"
			schema  | arguments                   | flag | result
=======
		where: "Two string arguments with diferent order from schema's order"
			schema  | arguments   | flag | result
>>>>>>> b371cc1e1eb56f9504bf0ae45d65fe1d1f7e5861
			"sv sb" | ["-v", "value", "-b","bcn"] | "v" | "value"
			"sb sv" | ["-v", "value", "-b","bcn"] | "v" | "value"
			"sv sb" | ["-v", "value", "-b","bcn"] | "b" | "bcn"
			"sb sv" | ["-v", "value", "-b","bcn"] | "b" | "bcn"
	}
}
