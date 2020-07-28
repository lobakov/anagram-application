package ua.com.foxminded.anagram;

public class AnagramApp {

    public static void main(String[] args) {
        String line = "abcd efgh a1bcd efg!h  2eeeee4444eeewddffgttgtgt4567";

        AnagramCreator anagramCreator = new AnagramCreator();

        System.out.println(anagramCreator.createAnagram(line));
    }
}
