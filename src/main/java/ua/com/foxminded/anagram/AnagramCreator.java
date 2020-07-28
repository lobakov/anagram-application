package ua.com.foxminded.anagram;

import java.util.StringJoiner;

public class AnagramCreator {

    public String createAnagram(String text) {
        validateText(text);
        
        if (text.trim().isEmpty()) {
            return text;
        }
        
        String[] words = text.split(" ");
        StringJoiner anagramJoiner = new StringJoiner(" ");

        for (String word : words) {
            String reversedWord = reverseWord(word);
            anagramJoiner.add(reversedWord);
        }
        return anagramJoiner.toString();
    }

    private void validateText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("No text to create an anagram");
        }
    }

    private String reverseWord(String word) {
        char[] characters = word.toCharArray();
        int rightIndex = characters.length - 1;
        int leftIndex = 0;

        while (leftIndex < rightIndex) {
            char leftCharacter = characters[leftIndex];
            char rightCharacter = characters[rightIndex];

            if (!Character.isAlphabetic(leftCharacter)) {
                ++leftIndex;
            } else if (!Character.isAlphabetic(rightCharacter)) {
                --rightIndex;
            } else {
                characters[leftIndex] = rightCharacter;
                characters[rightIndex] = leftCharacter;
                ++leftIndex;
                --rightIndex;
            }
        }
        return new String(characters);
    }
}
