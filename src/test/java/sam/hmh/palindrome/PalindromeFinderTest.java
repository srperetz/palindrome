package sam.hmh.palindrome;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Test the PalindromeFinder
 */
public class PalindromeFinderTest {
    @Test
    public void test1() {
        String[] inputArray = { "Gimli", "Fili", "Ilif", "Ilmig", "Mark" };
        List<String> inputs = new ArrayList<>(Arrays.asList(inputArray));
        PalindromeFinder pf = new PalindromeFinder();
        Set<Pair<String, String>> palindromes = pf.findPalindromes(inputs);
        Assert.assertEquals("Incorrect number of palindromes detected", 2, palindromes.size());
        Assert.assertTrue("Incorrect palindrome detected", palindromes.contains(new ImmutablePair<>("Gimli", "Ilmig")));
        Assert.assertTrue("Incorrect palindrome detected", palindromes.contains(new ImmutablePair<>("Fili", "Ilif")));
        pf.printPalindromes(palindromes);
    }

    @Test
    public void test2() {
        List<String> inputs = new ArrayList<>();
        BufferedReader reader;

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream fileStream = classLoader.getResourceAsStream("words.txt");
        if (fileStream == null) {
            Assert.fail("Unable to load resource words.txt");
            return;
        }

        reader = new BufferedReader(new InputStreamReader(fileStream));

        String word;
        try {
            while ((word = reader.readLine()) != null) {
                inputs.add(word);
            }
        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
            return;
        }

        PalindromeFinder pf = new PalindromeFinder();
        Set<Pair<String, String>> palindromes = pf.findPalindromes(inputs);
        for (Pair<String, String> p : palindromes) {
            Assert.assertTrue(p.getLeft() + " not found in inputs", inputs.contains(p.getLeft()));
            Assert.assertTrue(p.getRight() + " not found in inputs", inputs.contains(p.getRight()));
        }

        pf.printPalindromes(palindromes);
    }
}
