package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
    File file;
    String lineFromCSV = "";
    private final List<Item> allTranslations = new ArrayList<>();

    public Dictionary(File file) {
        this.file = file;
    }

    public Dictionary() {
    }

    public List<Item> getAllTranslations() {
        return allTranslations;
    }

    public List<Item> readCSV() {

        try (
                BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((lineFromCSV = br.readLine()) != null) {
                Item item = new Item(lineFromCSV);
                allTranslations.add(item);
                System.out.println("Słowo [ang= " + item.getAngWord() + ",pl=" + item.getPlWords() + "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allTranslations;
    }

    public int getRandomItem(List<Item> inputList) {
        Random random = new Random();
        int randomNumber = random.nextInt(inputList.size());
        return randomNumber;

    }
}
