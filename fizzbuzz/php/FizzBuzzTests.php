<?php

require_once('FizzBuzz.php');

class FizzBuzzTests extends PHPUnit_Framework_TestCase {

    public function testFizzBuzz() {
        $expected = array("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz",
                          "13","14","FizzBuzz","16","17","Fizz","19","Buzz");

        $fizzbuzz = new FizzBuzz;
        $this->assertEquals($expected, $fizzbuzz->play());
	}	
}

?>