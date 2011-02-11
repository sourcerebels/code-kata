class Thecube():

    def addDigits(self, text):
        """Returns the digit's sum of given text"""
        result = 0
        for pos in range(0, len(text)):
            if text[pos].isdigit():
                result = result + int(text[pos])
        return result

    def isPrimeNumber(self, number):
        """Determines if a number is prime"""
        for previousNumber in range(number - 1, 1, -1):
            if number % previousNumber == 0:
                return False
        return True

    def containsPrimeNumber(self, code1, code2, code3):
        """The Cube kata"""
        if (self.isPrimeNumber(self.addDigits(code1))):
            return True
        if (self.isPrimeNumber(self.addDigits(code2))):
            return True
        if (self.isPrimeNumber(self.addDigits(code3))):
            return True
        return False
