<?php

require_once('Player.php');

class FizzBuzz {
    
    public function play() {

        $player = new Player;
        $result = Array();

        foreach(range(1, 20) as $number) {
            $result[] = $player->fizzBuzz($number);
        }
        return $result;
    }
}
?>