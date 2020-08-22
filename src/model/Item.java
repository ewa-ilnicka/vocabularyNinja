package model;

import java.util.HashSet;
import java.util.Set;

public class Item {
    private String line;
    private String cvsSplitBy = ",";

    private Set<String> plWords = new HashSet<>();
    private String angWord = "";

    public Item(String line) {
        this.line = line;
        String[] words = line.split(cvsSplitBy);
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                angWord = words[i].toLowerCase().trim();
            } else {
                plWords.add(words[i]);
            }
        }
    }

    public Set<String> getPlWords() {
        return plWords;
    }

    public String getAngWord() {
        return angWord;
    }
}
