package ua.com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramCreatorTest {

    private AnagramCreator anagramCreator;

    @BeforeEach
    void init() {
        anagramCreator = new AnagramCreator();
    }

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
        //Given that a user provides a text of a single space char
        String providedText = " ";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive the same provided text back
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldReturnSeveralWhiteSpacesWhenOnlyWhiteSpacesProvided() {
        //Given that a user provides a text, containing White spaces only
        String providedText = "  ";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive the same provided text back
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldReturnSingleLetterWhenSingleLetterProvided() {
        //Given that a user provides a single-letter text
        String providedText = "a";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive the same provided text back
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldReturnSuppliedWordWhenAllLettersAreSame() {
        //Given that a user provides a text of a single repeated letter
        String providedText = "aaaaaa";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive the same provided text back
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldCreateAnagramWhenSingleWordProvided() {
        //Given that a user provides a text of a single Word
        String providedText = "abcd";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive a properly created anagram
        assertEquals("dcba", actualResult);
    }

    @Test
    void shouldLeaveNonLetterCharactersOnTheirPlacesWhenMixedTextProvided() {
        //Given that a user provides a text of a single Word of mixed symbols
        String providedText = "a1bcd";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive a properly created anagram
        //leaving non-letter characters on their places
        assertEquals("d1cba", actualResult);
    }

    @Test
    void shouldCreateAnagramWhenSeveralWordsProvided() {
        //Given that a user provides a text of several Words of mixed symbols
        String providedText = "a1bcd efg!h";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive a properly created anagram
        //leaving non-letter characters on their places
        assertEquals("d1cba hgf!e", actualResult);
    }

    @Test
    void shouldCreateAnagramWhenMixedCaseLettersProvided() {
        //Given that a user provides a text of several Words
        //of mixed-case symbols and non-letter characters
        String providedText = "a1BCd EfG!h";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive a properly created anagram
        //leaving non-letter characters on their places
        assertEquals("d1CBa hGf!E", actualResult);
    }

    @Test
    void shouldCreateAnagramWhenUpperCaseOnlyLettersProvided() {
        //Given that a user provides a text of several Words
        //of upper-case symbols and non-letter characters
        String providedText = "A1BCD EFG!H";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive a properly created anagram
        //leaving non-letter characters on their places
        assertEquals("D1CBA HGF!E", actualResult);
    }

    @Test
    void shouldLeaveTheWordAsIsIfNoAlphabeticCharactersProvided() {
        //Given that a user provides a text of non-letter characters
        String providedText = "1100101_+=\\]-";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive the same provided text back
        assertEquals(providedText, actualResult);
    }

    @Test
    void shouldCreateAnagramWhenLongWordProvided() {
        //Given that a user provides a pretty long string of mixed characters
        String providedText = "2eeeee4444eeewddffgttgtgt4567";

        //When provided text processed
        String actualResult = anagramCreator.createAnagram(providedText);

        //Then user must receive a properly created anagram
        //leaving non-letter characters on their places
        assertEquals("2tgtgt4444tgffddweeeeeeee4567", actualResult);
    }
}
