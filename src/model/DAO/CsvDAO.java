package model.DAO;

import model.Dictionary;
import java.io.File;

public class CsvDAO implements DAO {

    @Override
    public Dictionary loadDictionary(File file) {
        Dictionary dictionary = new Dictionary(file);
        return dictionary;
    }

}
