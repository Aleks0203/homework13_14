package ru.mail.druk_aleksandr;

import ru.mail.druk_aleksandr.service.HomeWorkService;
import ru.mail.druk_aleksandr.service.serviceImpl.HomeWorkServiceImpl;

public class App {
    public static void main(String[] args) {
        HomeWorkService homeWorkService = HomeWorkServiceImpl.getInstance();
        homeWorkService.runTask();
    }
}
