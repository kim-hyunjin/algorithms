import unittest
import sys, os
sys.path.append(os.path.dirname(os.path.abspath(os.path.dirname(__file__))))

import quiz_9012

class Test9012(unittest.TestCase):

    def test1(self):
        self.assertEqual(quiz_9012.solution("(())())"), "NO")

    def test2(self):
        self.assertEqual(quiz_9012.solution("(((()())()"), "YES")


if __name__ == '__main__':
    unittest.main()