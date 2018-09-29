package in.codeshuffle.typewriterview;

public interface TypeWriterListener {
    void onTypingStart(String text);

    void onTypingEnd(String text);

    void onCharacterTyped(String text, int position);

    void onTypingRemoved(String text);
}
