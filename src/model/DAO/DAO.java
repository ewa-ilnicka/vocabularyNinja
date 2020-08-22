package model.DAO;

import model.Dictionary;
import java.io.File;

public interface DAO {
    Dictionary loadDictionary(File file);
}
