import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.WordSpec

class ScoreCounterTest : WordSpec(){

    init {

        val testSubject = ScoreCounter()

        "ScoreCounter.calculate" should {

            "throw an IllegalArgumentException when given amount of rounds lesser than 10 and no strike/spare are last" {
                shouldThrow<IllegalArgumentException> {
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1)))
                }
            }
            "throw an IllegalArgumentException when given amount of rounds greater than 10 and no strike/spare are last" {
                shouldThrow<IllegalArgumentException> {
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1)))
                }
            }

            "throw an IllegalArgumentException when given amount of rounds greater than 11 and no spare is last" {
                shouldThrow<IllegalArgumentException> {
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1)))
                }
            }
            "throw an IllegalArgumentException when given amount of rounds lesser than 11 and no spare is last" {
                shouldThrow<IllegalArgumentException> {
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1)))
                }
            }

            "throw an IllegalArgumentException when given result contain numbers lesser than 0" {
                shouldThrow<IllegalArgumentException> {
                    testSubject.calculate(listOf(Pair(-1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1)))
                }
            }
            "throw an IllegalArgumentException when given result contain number greater than 0" {
                shouldThrow<IllegalArgumentException> {
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 11)))
                }
            }
/*            "not return lesser value than sum of bowlings down" {
                testSubject.calculate(listOf(Pair(4, 1), Pair(4, 1), Pair(5, 1), Pair(1, 1), Pair(7, 1), Pair(1, 6), Pair(1, 1), Pair(1, 8), Pair(1, 1), Pair(1, 7)))
            }*/

        }
    }

}

