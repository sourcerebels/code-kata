import spock.lang.Specification;
import spock.lang.Unroll;

class KataArgsTestSpec extends Specification {

	def parser
	
	@Unroll
	def "should parse a simple string value"() {
		
		setup:
			parser = new ArgumentsParser(schema: schema)
			parser.parse(arguments)
		expect:
			parser.argumentNumber == 1
			parser.getArgumentValue(flag) == result
		where: "different schemas, one string argument"
			schema | flag | arguments       | result
			"sv"   | "v"  | ["-v", "value"]  | "value"
			"sb"   | "b"  | ["-b", "bcn"]    | "bcn"
	}
	
	@Unroll
	def "should parse two string values"() {
		
		setup:
			parser = new ArgumentsParser(schema: schema)
			parser.parse(arguments)
		expect:
			parser.argumentNumber == 2
			parser.getArgumentValue(flag) == result
		where: "different schemas, two strings, arguments are unsorted"
			schema  | arguments                   | flag | result
			"sv sb" | ["-v", "value", "-b","bcn"] | "v"  | "value"
			"sb sv" | ["-v", "value", "-b","bcn"] | "v"  | "value"
			"sv sb" | ["-v", "value", "-b","bcn"] | "b"  | "bcn"
			"sb sv" | ["-v", "value", "-b","bcn"] | "b"  | "bcn"
	}
}
