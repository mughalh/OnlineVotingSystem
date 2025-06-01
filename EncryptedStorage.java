import java.io.*;

public class EncryptedStorage implements IDataStorage {
    private static final String SECRET_KEY = "secretkey123";
    @Override
    public void saveData(Object data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("encryptedData.dat"))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("encryptedData.dat"))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
