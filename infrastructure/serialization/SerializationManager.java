package infrastructure.serialization;

import java.io.*;

public class SerializationManager {

    public static void save(
            Object object,
            String fileName) {

        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(
                                fileName))) {

            oos.writeObject(object);

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public static Object load(
            String fileName) {

        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(
                                fileName))) {

            return ois.readObject();

        } catch (
                IOException | ClassNotFoundException ex) {

            return null;
        }
    }
}