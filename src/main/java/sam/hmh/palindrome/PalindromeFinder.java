package sam.hmh.palindrome;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Five Dwarves ( Gimli Fili Ilif Ilmig and Mark) met at the Prancing Pony and played a
 * word game to determine which combinations of their names resulted in a palindrome.
 * Write a program in that prints out all of those combinations.
 */
public class PalindromeFinder {
    public PalindromeFinder() {
    }

    /**
     * Find palindromes in the specified input set
     * @return A list of all of the sets of palindromes in the specified input set
     */
    public Set<Pair<String, String>> findPalindromes(String... inputs) {
        Set<Pair<String, String>> palindromes = new HashSet<>();
        for (int i = 0; i < inputs.length; i++) {
            String si = inputs[i];
            for (int j = i + 1; j < inputs.length; j++) {
                String sj = inputs[j];
                if (!si.equalsIgnoreCase(sj) && si.equalsIgnoreCase(StringUtils.reverse(sj))) {
                    palindromes.add(new ImmutablePair<>(si, sj));
                }
            }
        }

        return palindromes;
    }

    /**
     * Prints out all of the sets of palindromes in the specified input set
     */
    public void printPalindromes(String... inputs) {
        System.out.println(
            findPalindromes(inputs).stream()
                .map(pair -> String.format("%s <-> %s", pair.getLeft(), pair.getRight()))
                .collect(Collectors.joining(String.format("%n"))));
    }
}
