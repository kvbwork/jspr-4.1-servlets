package ru.netology.config;

import java.util.Optional;

public abstract class AbstractRoutesConfigurer {
    protected static final String GET = "GET";
    protected static final String POST = "POST";
    protected static final String DELETE = "DELETE";

    protected static Optional<Long> getIdPathParam(String path) {
        final var lastSlashIndex = path.lastIndexOf("/");
        if (lastSlashIndex == -1 || lastSlashIndex >= path.length()) return Optional.empty();
        try {
            return Optional.of(Long.parseLong(path.substring(lastSlashIndex + 1)));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

}
