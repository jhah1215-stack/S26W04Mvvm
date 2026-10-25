package kr.ac.kumoh.ce.s20200919.s26w04mvvm

class CounterModel(private val countValue: Int) {
    val count: Int
        get() = countValue

    fun increment() = CounterModel(countValue + 1)
    fun decrement() = CounterModel(countValue - 1)
    fun reset() = CounterModel(0)
}