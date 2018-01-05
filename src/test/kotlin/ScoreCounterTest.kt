import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.WordSpec

class ScoreCounterTest : WordSpec(){

    init {

        val testSubject = ScoreCounter()

        "ScoreCounter.calculate" should {

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
            "throw an IllegalArgumentException when given result contain a pair summing to more than 10" {
                shouldThrow<IllegalArgumentException> {
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(6, 7), Pair(1, 1), Pair(1, 1)))
                }
            }

            "throw an IllegalArgumentException when given result contain number of rounds lesser than 10 (no spare/strike last)" {
                shouldThrow <IllegalArgumentException>{
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1)))
                }
            }
            "throw an IllegalArgumentException when given result contain number of rounds lesser than 10 (no spare/strike last)" {
                shouldThrow <IllegalArgumentException>{
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1)))
                }
            }
            "throw an IllegalArgumentException when given result contain number of rounds lesser than 11 (spare/strike last)" {
                shouldThrow <IllegalArgumentException>{
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(6, 4)))
                }
            }
            "throw an IllegalArgumentException when given result contain number of rounds lesser than 11 (spare/strike last)" {
                shouldThrow <IllegalArgumentException>{
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(6, 4)))
                }
            }

            "throw an IllegalArgumentException when given result ends with spare and the second bonus throw is not 0" {
                shouldThrow <IllegalArgumentException>{
                    testSubject.calculate(listOf(Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1), Pair(4, 6), Pair(1, 1)))
                }
            }

            "return sum of all throws when result contains no strikes/spares" {
                testSubject.calculate(listOf(Pair(1, 1), Pair(2, 1), Pair(1, 1), Pair(1, 6), Pair(1, 1), Pair(1, 1), Pair(8, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1))) shouldBe 33
            }
            "return sum of all throws and double the points of throw preceded with spare" {
                testSubject.calculate(listOf(Pair(1, 1), Pair(2, 1), Pair(1, 1), Pair(1, 6), Pair(1, 1), Pair(4, 6), Pair(8, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1))) shouldBe 49
            }
            "return sum of all throws and double the points of round preceded with spare" {
                testSubject.calculate(listOf(Pair(1, 1), Pair(2, 1), Pair(1, 1), Pair(10, 0), Pair(4, 4), Pair(1, 1), Pair(8, 1), Pair(1, 1), Pair(1, 1), Pair(1, 1))) shouldBe 50
            }
        }
    }

}

