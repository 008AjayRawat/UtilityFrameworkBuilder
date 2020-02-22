package app.framework.utilities.crypto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    /**
     * Get MD5 value for a string
     *
     * @param input the input
     * @return the string
     */
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            StringBuilder md5 = new StringBuilder(number.toString(16));

            while (md5.length() < 32) {
                md5.insert(0, "0");
            }

            return md5.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private MD5() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
