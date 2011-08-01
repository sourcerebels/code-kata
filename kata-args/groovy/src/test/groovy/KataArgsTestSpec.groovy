import spock.lang.Specification;
import spock.lang.Unroll;

class KataArgsTestSpec extends Specification {

	def parser
	
	def "setup"() {
		parser = new ArgumentsParser()
	}
	
	@Unroll("schema: #schema flag: #flag value: #value result: #result")
	def "should parse a simple string value"() {
		
		setup:
			parser.schema = schema
			parser.parse(arguments)
		expect:
			parser.argumentNumber == 1
			parser.getArgumentValue(flag) == result
		where: "Arguments are one string value"
			schema | flag | arguments       | result
			"sv"   | "v" | ["-v", "value"] | "value"
			"sb"   | "b" | ["-b", "bcn"]   | "bcn"
	}
	
	def "should parse two string values"() {
		
		setup:
			parser.schema = schema
			parser.parse(arguments)
		expect:
			parser.argumentNumber == 2
			parser.getArgumentValue(flag) == result
		where: "Two string arguments with diferent order from schema's order"
			schema  | arguments   | flag | result
			"sv sb" | ["-v", "value", "-b","bcn"] | "v" | "value"
			"sb sv" | ["-v", "value", "-b","bcn"] | "v" | "value"
			"sv sb" | ["-v", "value", "-b","bcn"] | "b" | "bcn"
			"sb sv" | ["-v", "value", "-b","bcn"] | "b" | "bcn"
	}
}
