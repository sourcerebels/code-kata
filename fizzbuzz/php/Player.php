<?php

class Player {

    public function fizzBuzz($number) {

        $divisibleByThree = $this->divisibleBy($number, 3);
        $divisibleByFive = $this->divisibleBy($number, 5);

        if ($divisibleByThree && $divisibleByFive) {
            return 'FizzBuzz';
        }
        if ($divisibleByThree) {
            return 'Fizz';
        }
        if ($divisibleByFive) {
            return 'Buzz';
        }
        return strval($number);
    }

    private function divisibleBy($number, $divisor) {
        return $number % $divisor == 0;
    }
}

?>