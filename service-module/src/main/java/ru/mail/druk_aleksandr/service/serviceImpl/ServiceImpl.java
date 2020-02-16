package ru.mail.druk_aleksandr.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.druk_aleksandr.repository.Repository;
import ru.mail.druk_aleksandr.service.Service;
import ru.mail.druk_aleksandr.repository.repositoryImpl.RepositoryImpl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceImpl implements Service {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final String PATERN_FORMAT_FOR_SPLIT = "(, )|(,)|[|]|(:)|(,)|(,)";
    private static Service instance;
    private Repository repository = RepositoryImpl.getInstance();

    private ServiceImpl() {
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new ServiceImpl();
        }
        return instance;
    }

    @Override
    public int add(String numbers) {
        String[] strings = numbers.split(PATERN_FORMAT_FOR_SPLIT);
        int[] arrayOfNumbers = convertStringToInt(strings);
        return Arrays.stream(arrayOfNumbers).limit(2).sum();
    }

    @Override
    public int sumOfValuesFromFile(String fileName) {
        List<String> lists = repository.reader(fileName);
        List<Integer> integerList = new ArrayList<>();
        for (String list : lists) {
            int values = add(list);
            integerList.add(values);
        }
        return integerList.stream().mapToInt(Integer::intValue).sum();
    }

    public int[] convertStringToInt(String[] str) {
        int arrayOfNumbers[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            try {
                arrayOfNumbers[i] = Integer.parseInt(str[i]);
            } catch (NumberFormatException ex) {
                arrayOfNumbers[i] = 0;
            }
        }
        return arrayOfNumbers;
    }
}
