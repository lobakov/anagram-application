package ua.com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnagramCreatorTest {

    private AnagramCreator anagramCreator = new AnagramCreator();

    @Test
    void shouldThrowExceptionIfTextIsNull() {
        Exception thrownException = assertThrows(IllegalArgumentException.class,
                () -> anagramCreator.createAnagram(null));

        assertEquals("No text to create an anagram", thrownException.getMessage());
    }

    @Test
    void shouldThrowExceptionIfTextIsEmpty() {
        Exception thrownException = assertThrows(IllegalArgumentException.class,
                () -> anagramCreator.createAnagram(""));

        assertEquals("No text to create an anagram", thrownException.getMessage());
    }

    @Test
    void shouldReturnWhiteSpaceWhenSingleSpaceProvided() {
        //Given
        String providedText = " ";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldReturnSeveralWhiteSpacesWhenOnlyWhiteSpacesProvided() {
        //Given
        String providedText = "  ";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldReturnSingleLetterWhenSingleLetterProvided() {
        //Given
        String providedText = "a";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldReturnSuppliedWordWhenAllLettersAreSame() {
        //Given
        String providedText = "aaaaaa";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldCreateAnagramWhenSingleWordProvided() {
        //Given
        String providedText = "abcd";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals("dcba", actualResult);
    }

    @Test
    void shouldLeaveNonLetterCharactersOnTheirPlacesWhenMixedTextProvided() {
        //Given
        String providedText = "a1bcd";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals("d1cba", actualResult);
    }

    @Test
    void shouldCreateAnagramWhenSeveralWordsProvided() {
        //Given
        String providedText = "a1bcd efg!h";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals("d1cba hgf!e", actualResult);
    }

    @Test
    void shouldCreateAnagramWhenMixedCaseLettersProvided() {
        //Given
        String providedText = "a1BCd EfG!h";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals("d1CBa hGf!E", actualResult);
    }

    @Test
    void shouldCreateAnagramWhenUpperCaseOnlyLettersProvided() {
        //Given
        String providedText = "A1BCD EFG!H";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals("D1CBA HGF!E", actualResult);
    }

    @Test
    void shouldLeaveTheWordAsIsIfNoAlphabeticCharactersProvided() {
        //Given
        String providedText = "1100101_+=\\]-";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldCreateAnagramWhenLongWordProvided() {
        //Given
        String providedText = "2eeeee4444eeewddffgttgtgt4567";

        //When
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then
        assertEquals("2tgtgt4444tgffddweeeeeeee4567", actualResult);
    }
}
