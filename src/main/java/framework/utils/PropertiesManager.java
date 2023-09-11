package framework.utils;

import com.google.gson.stream.JsonReader;

import java.io.*;
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

    public static void saveData(String path, String object) {
        SmartLogger.logInfo("Save data in file");
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(object);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readData(String path, Class<T> cls) {
        SmartLogger.logInfo("Read data in file");
        try (JsonReader reader = new JsonReader(new FileReader(path))) {
            return JsonConverter.getObject(reader, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void deleteFile(String path) {
        SmartLogger.logInfo("Delete file");
        new File(path).delete();
    }
}