package ru.mail.druk_aleksandr.repository;

import java.util.List;

public interface Repository {
    List<String> reader(String fileName);
}
