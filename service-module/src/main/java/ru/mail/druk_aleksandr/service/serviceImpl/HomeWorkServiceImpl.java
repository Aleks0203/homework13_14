package ru.mail.druk_aleksandr.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.druk_aleksandr.service.HomeWorkService;
import ru.mail.druk_aleksandr.service.Service;

import java.lang.invoke.MethodHandles;

public class HomeWorkServiceImpl implements HomeWorkService {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final String FILE_NAME = "JD2.txt";
    private static HomeWorkService instance;
    private Service service = ServiceImpl.getInstance();

    private HomeWorkServiceImpl() {
    }

    public static HomeWorkService getInstance() {
        if (instance == null) {
            instance = new HomeWorkServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        logger.info(service.sumOfValuesFromFile(FILE_NAME));
    }
}
