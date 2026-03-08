import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class AESApp {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String message;

        while (true) {
            System.out.print("Enter a message (multiple of 16 characters): ");
            message = scanner.nextLine();

            if (!message.isEmpty() && message.length() % 16 == 0) {
                break;
            } else {
                System.out.println("Message must be a multiple of 16 characters.");
            }
        }
        //Convert message to bytes:
        byte[] bytes = message.getBytes();

        //Generate AES key:
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        Key key = kg.generateKey();

        //Generate IV for CBC:
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        //Run encryption modes:
        runECB(bytes, key);
        runCBC(bytes, key, ivSpec);
    }

    public static void displayBlocks(String original, byte[] encryptedBytes) {

        System.out.println("Message | " + original);

        for (int i = 0; i < encryptedBytes.length / 16; i++) {
            byte[] block = Arrays.copyOfRange(encryptedBytes, i * 16, (i + 1) * 16);
            String base64Block = Base64.getEncoder().encodeToString(block);

            System.out.println("Encrypted Block " + (i + 1) + " | " + base64Block);
        }
    }
    // ECB encrypts blocks independently which may reveal patterns to attackres.
    public static void runECB(byte[] bytes, Key key) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(bytes);

        System.out.println("\nEncryption Using ECB Mode:");
        displayBlocks(new String(bytes), encrypted);

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted Message | " + new String(decrypted));
    }
    // CBC uses an initialization vector and chaining, making it more secure.
    public static void runCBC(byte[] bytes, Key key, IvParameterSpec ivSpec) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        byte[] encrypted = cipher.doFinal(bytes);

        System.out.println("\nEncryption Using CBC Mode:");
        displayBlocks(new String(bytes), encrypted);

        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted Message | " + new String(decrypted));
    }
}
