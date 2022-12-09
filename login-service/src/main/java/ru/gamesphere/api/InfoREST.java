package ru.gamesphere.api;


import org.apache.commons.io.FilenameUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/info")
public class InfoREST {
    private static final java.nio.file.Path PATH = java.nio.file.Path.of(System.getProperty("user.dir") + "/login-service/src/main/resources/info.txt");

    @GET
    public String get() {
        try (Stream<String> lines = Files.lines(PATH)) {
            return lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
