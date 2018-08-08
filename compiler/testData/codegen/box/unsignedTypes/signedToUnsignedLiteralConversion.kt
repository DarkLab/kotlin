// WITH_UNSIGNED

fun takeUByte(u: UByte): Byte {
    return u.toByte()
}

fun box(): String {
    val r = takeUByte(200 + 55)
    if (r != (-1).toByte()) return "Fail 1: $r"

    return "OK"
}
