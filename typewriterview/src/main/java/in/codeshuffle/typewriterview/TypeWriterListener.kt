package `in`.codeshuffle.typewriterview

interface TypeWriterListener {
    fun onTypingStart(text: String)
    fun onTypingEnd(text: String)
    fun onCharacterTyped(text: String, position: Int)
    fun onTypingRemoved(text: String)
}