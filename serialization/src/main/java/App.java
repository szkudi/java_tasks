import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
//    private static final Path FILE = Paths.get("/Users/mrszkudi/workspace/Java/serialization", "input.txt");
    private Map<String, List<Integer>> map;

    public String getGreeting() {
        return "Hello world.";
    }

    public void enumerateWords() {
        try {
            String basePath = new File(".").getCanonicalPath();
            Path file = Paths.get( basePath, "input.txt");

            final int[] counter = {0};

            Files.readAllLines(file, Charset.defaultCharset()).stream()
                 .map(s -> {
                     counter[0]++;
                     return Arrays.stream(s.split("\\PL+")).distinct()
                             .collect(Collectors.toMap(
                                     Function.identity(),
                                     str -> new ArrayList<>(Arrays.asList(counter[0]))));
                 })
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (integers, integers2) -> {
                                integers.addAll(integers2);
                                return integers;
                            }))
                    .forEach((s, integers) -> System.out.println(integers + " " + s));

            Path outFile = Paths.get( basePath, "input.toc");
            Writer out = new

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        App a = new App();
        System.out.println(a.getGreeting());
        a.enumerateWords();
    }
}
