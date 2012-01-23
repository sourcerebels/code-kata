<?php

require_once('Player.php');

class PlayerTests extends PHPUnit_Framework_TestCase {

    public function testShouldSaySameNumber() {
        $player = new Player;
        $this->assertEquals('1', $player->fizzbuzz(1));
        $this->assertEquals('2', $player->fizzbuzz(2));
        $this->assertEquals('4', $player->fizzbuzz(4));
        $this->assertEquals('7', $player->fizzbuzz(7));
        $this->assertEquals('8', $player->fizzbuzz(8));
        $this->assertEquals('11', $player->fizzbuzz(11));
        $this->assertEquals('13', $player->fizzbuzz(13));
        $this->assertEquals('14', $player->fizzbuzz(14));
    }

    public function testShouldSayFizzForDivisibleByThree() {
        $player = new Player;
        $this->assertEquals('Fizz', $player->fizzbuzz(3));
        $this->assertEquals('Fizz', $player->fizzbuzz(6));
        $this->assertEquals('Fizz', $player->fizzbuzz(9));
        $this->assertEquals('Fizz', $player->fizzbuzz(12));
    }

    public function testShouldSayBuzzForDivisibleByFive() {
        $player = new Player;
        $this->assertEquals('Buzz', $player->fizzbuzz(5));
        $this->assertEquals('Buzz', $player->fizzbuzz(10));
    }

    public function testShouldSayFizzBuzzForDivisibleByThreeAndFive() {
        $player = new Player;
        $this->assertEquals('FizzBuzz', $player->fizzbuzz(15));
    }
}
?>
