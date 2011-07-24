import spock.lang.*

class Teleprompter {

    public String translate(String text, def dictionary) {

	dictionary.each {
	    text = text.replaceAll("\\\$" + it.key + "\\\$", it.value)
	}
	return text
    }
}

class TeleprompterSpecification extends Specification {

    def teleprompter
    def dictionary

    def setup() {
        teleprompter = new Teleprompter()
	dictionary = [ fuck: "love", piss: "coke" ]
    }

    def "translatingEmptyText"() {
	when:
	    def result = teleprompter.translate("", dictionary)
	then:
	    result == ""
    }

    def "translatingTextWithoutSlangWords"() {
	when:
	    def result = teleprompter.translate("Text without slang", dictionary)
	then:
	    result == "Text without slang"
    }

    def "translatingSomeSlangWords"() {
	expect:
	    teleprompter.translate(text, dictionary) == result
	where:
	    text << ["\$fuck\$ you", "dont \$piss\$ off", "\$fuck\$ and \$piss\$"]
	    result << ["love you", "dont coke off", "love and coke"]
    }
}
