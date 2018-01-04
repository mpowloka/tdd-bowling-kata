class ScoreCounter {

    fun calculate(result: List<Pair<Int, Int>>) {
        validateResult(result)
    }

    private fun validateResult(result: List<Pair<Int, Int>>) {
        require(result.size == 10)
        result.forEach {
            require(it.first in (0..10))
            require(it.second in (0..10))
        }
    }

}
