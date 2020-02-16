package ru.mail.druk_aleksandr.repository.repositoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.druk_aleksandr.repository.Repository;
import ru.mail.druk_aleksandr.util.PropertyUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static Repository instance;
    private PropertyUtil propertyUtil = new PropertyUtil();

    private RepositoryImpl() {
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new RepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<String> reader(String fileName) {
        List<String> list = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(propertyUtil.getProperty("dirpath") + fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                list.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        return list;
    }
}
