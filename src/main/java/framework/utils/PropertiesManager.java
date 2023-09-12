package framework.utils;

import com.google.gson.stream.JsonReader;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesManager {

    private PropertiesManager() {
    }

    private static Properties getProperties(String pathFile) {
        try (FileInputStream fileTestDataInputStream = new FileInputStream(pathFile)) {
            Properties properties = new Properties();
            properties.load(fileTestDataInputStream);

            return properties;
        } catch (IOException exception) {
            pathFile = pathFile.replace('\\', '/');
            try (FileInputStream fileTestDataInputStream = new FileInputStream(pathFile)) {
                Properties properties = new Properties();
                properties.load(fileTestDataInputStream);

                return properties;
            } catch (IOException exc) {
                SmartLogger.logError("Don't reading file.");
            }

            SmartLogger.logError("First, don't reading file. Replace \\ of /.");
        }

        return null;
    }

    public static String getValue(String path, String fileName, String key) {
        return getProperties(path.concat(fileName)).getProperty(key);
    }

    public static void saveFile(File file, String pathFile) {
        try {
            Files.copy(file.toPath(), Paths.get(System.getProperty("user.dir").concat(pathFile)));
        } catch (IOException e) {
            SmartLogger.logError("Don't save image ");
        }
    }

    public static void saveImage(String url, String pathFile) {
        try (InputStream inputStream = new URL(url).openStream()) {
            Files.copy(inputStream, Paths.get(System.getProperty("user.dir").concat(pathFile)));
        } catch (IOException e) {
            SmartLogger.logError("Don't save image with parameters: url ".concat(url));
        }
    }

    public static void saveData(String path, String object) {
        SmartLogger.logInfo("Save data in file ".concat(path));
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(object);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readData(String path, Class<T> cls) {
        SmartLogger.logInfo("Read data in file ".concat(path));
        try (JsonReader reader = new JsonReader(new FileReader(path))) {
            return JsonConverter.getObject(reader, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void deleteFile(String filePath) {
        SmartLogger.logInfo("Delete file ".concat(filePath));
        new File(filePath).delete();
    }
}