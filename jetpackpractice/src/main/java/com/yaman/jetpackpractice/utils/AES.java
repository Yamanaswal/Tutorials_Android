package com.yaman.jetpackpractice.utils;


import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.yaman.jetpackpractice.BuildConfig;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static String CIPHER_NAME = "AES/CBC/NoPadding";
    public static String strArrayKey = "MTA5MCMj1090##JSFGKiZeJClfKiUzZiZCKw==XWc7dnMnMmFs";
    public static String strArrayvector = "MTA5MCMj1090##IyokREp2eXcydyUhXy0kQA==XWc7dnMnMmFs";
    private static int CIPHER_KEY_LEN = 16; //128 bits
    public static String strArrayKeyDownloadV2 = "MTA5MDkwMTAjIw==c2w7NDYkJzsq10909010##ZyYnOy5Ic2Y0N15AO31bMCg4N2onNyY4XmpJJzooOCwuS2h0JTY0R2Y=MTA5MDkwMTAjIw==";
    //public static String strArrayKeyDownloadV2 = "MTA5MCMj1090##c1sncjU0aydzLiwyW3MnZjBhL3c0NTs=XWc7dnMnMmFs";
    public static String strArrayKeyDownload = "MTA5MCMj1090##YUh9NXNbezsnPiwkMiZ2Ow==XWc7dnMnMmFs";
    public static String strArrayvectorDownload = "MTA5MCMj1090##aTtHfSdodCNkKm86Jy8lZg==XWc7dnMnMmFs";

    public static String strArrayKeyLib = "!*@#)($^%1fgv&C=";
    public static String strArrayvectorLib = "?\\:><{}@#Vjekl/4";


    public static String encrypt(String data, Context context) {
        String key = AES.generatekeyAPI(context);
        String iv = AES.generateVectorAPI(context);
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec secretKey = new SecretKeySpec(fixKey(key).getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            byte[] encryptedData = cipher.doFinal((data.getBytes("UTF-8")));
            String encryptedDataInBase64 = Base64.encodeToString(encryptedData, Base64.DEFAULT);
            String ivInBase64 = Base64.encodeToString(iv.getBytes("UTF-8"), Base64.DEFAULT);
            //return encryptedDataInBase64 + ":" + ivInBase64;
            return encryptedDataInBase64 + ":";

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String fixKey(String key) {

        if (key.length() < AES.CIPHER_KEY_LEN) {
            int numPad = AES.CIPHER_KEY_LEN - key.length();

            for (int i = 0; i < numPad; i++) {
                key += "0"; //0 pad to len 16 bytes
            }

            return key;

        }

        if (key.length() > AES.CIPHER_KEY_LEN) {
            return key.substring(0, CIPHER_KEY_LEN); //truncate to 16 bytes
        }

        return key;
    }

    /**
     * Decrypt data using AES Cipher (CBC) with 128 bit key
     *
     * @param key  - key to use should be 16 bytes long (128 bits)
     * @param data - encrypted data with iv at the end separate by :
     * @return decrypted data string
     */

    public static String decrypt(String data, String key, String ivParameter) {

        try {
            if (data.contains(":")) {
                String[] parts = data.split(":");

                IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
                SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance(AES.CIPHER_NAME);
                cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

                byte[] decodedEncryptedData = Base64.decode(parts[0], Base64.NO_PADDING);

                byte[] original = cipher.doFinal(decodedEncryptedData);

                return new String(original);
            } else {
                IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
                SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance(AES.CIPHER_NAME);
                cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

                byte[] decodedEncryptedData = Base64.decode(data, Base64.NO_PADDING);

                byte[] original = cipher.doFinal(decodedEncryptedData);

                return new String(original);
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public static String generatekeyAPI(Context context) {
        String finalKey = "";
        String parts;
        if (Helper.INSTANCE.getUserData(context) != null && !TextUtils.isEmpty(Objects.requireNonNull(Helper.INSTANCE.getUserData(context)).getId())) {
            parts = (Objects.requireNonNull(Helper.INSTANCE.getUserData(context)).getId() + BuildConfig.API_TOKEN ).substring(0, 16);
        } else {
            parts = ("0" + BuildConfig.API_TOKEN + "_" + BuildConfig.API_ID).substring(0, 16);
        }
        for (char c : parts.toCharArray()) {
            finalKey = finalKey + AES.encryptPassword(AES.strArrayKey).toCharArray()[Integer.parseInt(String.valueOf(c))];
        }
        return finalKey;
    }

    public static String generateVectorAPI(Context context) {
        String finalKey = "";
        String parts;
        if (Helper.INSTANCE.getUserData(context) != null && !TextUtils.isEmpty(Objects.requireNonNull(Helper.INSTANCE.getUserData(context)).getId())) {
            parts = (Objects.requireNonNull(Helper.INSTANCE.getUserData(context)).getId() + BuildConfig.API_TOKEN ).substring(0, 16);
        } else {
            parts = ("0" + BuildConfig.API_TOKEN + "_" + BuildConfig.API_ID).substring(0, 16);
        }
        for (char c : parts.toCharArray()) {
            finalKey = finalKey + AES.encryptPassword(AES.strArrayvector).toCharArray()[Integer.parseInt(String.valueOf(c))];
        }
        return finalKey;

    }

    public static String generateLibkeyAPI(String token) {
        String finalKey = "";
        String parts;
        parts = token;
        for (char c : parts.toCharArray()) {
            finalKey = finalKey + AES.strArrayKeyLib.toCharArray()[Integer.parseInt(String.valueOf(c))];
        }
        return finalKey;
    }


    public static String generateLibVectorAPI(String token) {
        String finalKey = "";
        String parts;
        parts = token;
        for (char c : parts.toCharArray()) {
            finalKey = finalKey + AES.strArrayvectorLib.toCharArray()[Integer.parseInt(String.valueOf(c))];
        }
        return finalKey;
    }


    public static String generatekey(String token) {
        String finalKey = "";
        String[] parts = token.split("_");
        for (char c : parts[2].toCharArray()) {
            finalKey = finalKey + AES.encryptPassword(AES.strArrayKey).toCharArray()[Integer.parseInt(String.valueOf(c))];
        }
        return finalKey;
    }


    public static String generateVector(String token) {
        String finalKey = "";
        String[] parts = token.split("_");
        for (char c : parts[2].toCharArray()) {
            finalKey = finalKey + AES.encryptPassword(AES.strArrayvector).toCharArray()[Integer.parseInt(String.valueOf(c))];
        }
        return finalKey;
    }


    public static String encryptPassword(String key) {
        String password = "";
        String[] base = key.split("1090##", 2);
        String sub1 = base[0];
        String sub2 = base[1];
        String[] subBase = sub2.split("==", 2);
        String s1 = subBase[0];
        String finalEncodeStart = s1 + "==";
        String endEncode = subBase[1];

        byte[] decodeStart = Base64.decode(finalEncodeStart, Base64.DEFAULT);
        String finalDecodeStart = new String(decodeStart, StandardCharsets.UTF_8);

        byte[] decodeEnd = Base64.decode(endEncode, Base64.DEFAULT);
        String finalDecodeEnd = new String(decodeEnd, StandardCharsets.UTF_8);
        //password = finalDecodeStart + finalDecodeEnd;
        password = finalDecodeStart;

        return password;
    }


}

