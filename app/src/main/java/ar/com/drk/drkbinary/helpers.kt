package ar.com.drk.drkbinary

fun binaryStringToInt(value: String): Int {
    return value.toInt(2)
}

fun intToBinaryString(value: Int) : String {
    return value.toString(2)
}