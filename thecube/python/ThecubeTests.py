import unittest
from Thecube import Thecube

class ThecubeTests(unittest.TestCase):

    def setUp(self):
        self.thecube = Thecube()

    def testIsPrimeNumber(self):
        self.assertTrue(self.thecube.isPrimeNumber(1))
        self.assertTrue(self.thecube.isPrimeNumber(2))
        self.assertTrue(self.thecube.isPrimeNumber(5))
        self.assertTrue(self.thecube.isPrimeNumber(7))
        self.assertTrue(self.thecube.isPrimeNumber(11))
        self.assertTrue(self.thecube.isPrimeNumber(13))
        self.assertTrue(self.thecube.isPrimeNumber(17))
        self.assertTrue(self.thecube.isPrimeNumber(19))
        self.assertTrue(self.thecube.isPrimeNumber(23))
        self.assertTrue(self.thecube.isPrimeNumber(29))
        self.assertTrue(self.thecube.isPrimeNumber(31))

        self.assertFalse(self.thecube.isPrimeNumber(4))
        self.assertFalse(self.thecube.isPrimeNumber(6))
        self.assertFalse(self.thecube.isPrimeNumber(8))
        self.assertFalse(self.thecube.isPrimeNumber(9))

    def testAddDigits(self):
        self.assertEquals(3, self.thecube.addDigits('012'))
        self.assertEquals(6, self.thecube.addDigits('222'))
        self.assertEquals(45, self.thecube.addDigits('0123456789'))
        self.assertEquals(3, self.thecube.addDigits('1hofei1lf00f1kd'))

    def testContainsPrimeNumber(self):
        self.assertTrue(self.thecube.containsPrimeNumber('1', '1', '1'))
        self.assertTrue(self.thecube.containsPrimeNumber('122', '1', '1'))
        self.assertTrue(self.thecube.containsPrimeNumber('28733', '13412', '96476'))
        self.assertFalse(self.thecube.containsPrimeNumber('22', '22', '22'))

if __name__ == '__main__':
    unittest.main()
