class ScoreCounter {

    fun calculate(result: List<Pair<Int, Int>>): Int {
        validateResult(result)

        var points = 0
        var previousFirst = 0
        var previousSecond = 0
        result.forEach{

            if(previousFirst + previousSecond == 10) {
                points += it.first
            }
            if(previousFirst == 10) {
                points += it.second
            }

            previousFirst = it.first
            points += it.first
            previousSecond = it.second
            points += it.second

        }

        return points
    }

    private fun validateResult(result: List<Pair<Int, Int>>) {

        require(result.size  in (10..11))

        if(result.size == 11) {
            require(result[9].first + result[9].second == 10)
            if (result[9].second != 0) {
                require(result.last().second == 0)
            }
        }
        else {
            require(result[9].first + result[9].second < 10)
        }

        result.forEach {
            require(it.first in (0..10))
            require(it.second in (0..10))
            require(it.first + it.second <= 10)
        }
    }

}
