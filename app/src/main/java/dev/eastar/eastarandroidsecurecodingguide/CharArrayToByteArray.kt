package dev.eastar.eastarandroidsecurecodingguide

const val MAX_BYTE_ON_CHAR = 3
fun toByte(chars: CharArray, returnClear: ((ByteArray) -> Unit)? = { it.fill('x'.code.toByte()) }): ByteArray {
    val maxByteSize = chars.size * MAX_BYTE_ON_CHAR
    val bytes = ByteArray(maxByteSize)
    var i = 0 // i for chars index
    var j = 0 // j for bytes index
    while (i < chars.size) {
        val ch = chars[i]
        when {
            ch.code < 0x80 -> {
                bytes[j + 0] = ch.code.toByte()
                i += 1
                j += 1
            }
            ch.code < 0x800 -> {
                bytes[j + 0] = (0xc0 or (ch.code shr 6)).toByte()
                bytes[j + 1] = (0x80 or (ch.code and 0x3f)).toByte()
                i += 1
                j += 2
            }
            Character.isHighSurrogate(ch) -> {
                if (maxByteSize - i < 2) throw Exception("overflow")
                if (!Character.isLowSurrogate(chars[i + 1])) throw Exception("malformed")

                val surrogate = Character.toCodePoint(ch, chars[i + 1])
                bytes[j + 0] = (0xf0 or ((surrogate shr 18))).toByte()
                bytes[j + 1] = (0x80 or ((surrogate shr 12) and 0x3f)).toByte()
                bytes[j + 2] = (0x80 or ((surrogate shr 6) and 0x3f)).toByte()
                bytes[j + 3] = (0x80 or (surrogate and 0x3f)).toByte()
                i += 2 // 2 chars
                j += 4
            }

            Character.isLowSurrogate(ch) -> throw Exception("malformed")

            else -> {
                bytes[j + 0] = (0xe0 or (ch.code shr 12)).toByte()
                bytes[j + 1] = (0x80 or ((ch.code shr 6) and 0x3f)).toByte()
                bytes[j + 2] = (0x80 or (ch.code and 0x3f)).toByte()
                i += 1
                j += 3
            }
        }
    }
    val result = bytes.copyOf(j)
    bytes.fill('x'.code.toByte())
    return result
}

fun toByteAscii(source: CharArray, returnClear: ((ByteArray) -> Unit)? = { it.fill('x'.code.toByte()) }): ByteArray {
    val target = ByteArray(source.size)
    for (i in source.indices)
        target[i] = source[i].code.toByte()
    return target
}

