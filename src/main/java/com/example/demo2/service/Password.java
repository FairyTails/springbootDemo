package com.example.demo2.service;


import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author chenSongBin
 * @date 2020/12/14
 */
public class Password {

    //2.私钥加密 公钥解密
    public static byte[] encode(byte[] data, String key) {
        try {


            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] decode(byte[] data, String key) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(key));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @return 第一个是私钥，第二个是公钥
     */
    public static String[] generate() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom sr = new SecureRandom();
            keyPairGenerator.initialize(512, sr);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

            String[] keys = new String[2];
            keys[0] = Base64.getEncoder().encodeToString(rsaPrivateKey.getEncoded());
            keys[1] = Base64.getEncoder().encodeToString(rsaPublicKey.getEncoded());
            return keys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
//        String src = "fafsdfsdfsdfetgretrerrwesdvf";
//
//        String[] keys = generate();
//
//        byte[] srcCode = src.getBytes();
//        byte[] encode = encode(srcCode, keys[0]);
//        byte[] decode = decode(encode, keys[1]);
//
//        println(srcCode);
//        println(encode);
//        println(decode);


        String[] keys = generate();

        System.out.println(keys[0]);
        System.out.println(keys[1]);
//        Runtime run = Runtime.getRuntime();
//
//        // 当前文件系统类
//        FileSystemView fsv = FileSystemView.getFileSystemView();
//        // 列出所有windows 磁盘
//        File[] fs = File.listRoots();
//        // 显示磁盘卷标
//        for (int i = 0; i < fs.length; i++) {
//            System.out.println(fs[i].getAbsolutePath());
//            String a = "cmd /c vol " + fs[i].getAbsolutePath().substring(0, 2);
//            System.out.println(">---->----" + a);
//            Process p = run.exec(a);
//            InputStreamReader isr = new InputStreamReader(p.getInputStream(), "gbk");
//            BufferedReader br = new BufferedReader(isr);
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                System.out.println(">---->" + line);
//            }
//            br.close();
//            // System.out.println(fsv.getSystemDisplayName(fs[i]));
//        }
//
//        URL url1 = new URL("file:D:/jarload/test.jar");
//        URLClassLoader myClassLoader1 = new URLClassLoader(new URL[]{url1}, Thread.currentThread()
//                .getContextClassLoader());
//
//        URLClassLoader gg = new URLClassLoader()
//        ClassLoader
//
//        Class<?> myClass1 = myClassLoader1.loadClass("com.java.jarloader.TestAction");
//        AbstractAction action1 = (AbstractAction) myClass1.newInstance();
//        String str1 = action1.action();


    }

    public static void println(byte[] data) {
        for (byte a : data) {
            System.out.print(a);
        }
        System.out.println();
    }

}
