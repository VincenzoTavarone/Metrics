package sha;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {

    public static int calculateSHA(String filename){
        InputStream inputStream = null;
        MessageDigest digest = null;
        try{
            inputStream = new FileInputStream(filename);
            digest = MessageDigest.getInstance("SHA-1");
        }catch (IOException|NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        int n = 0;
        byte[] buffer = new byte[8192];
        while(n != -1){
            try {
                n = inputStream.read(buffer);
            } catch (IOException e){
                e.printStackTrace();
            }
            if(n > 0){
                digest.update(buffer,0, n);
            }
        }

        return digest.digest()[digest.digest().length-1] & 0xff;
    }

}
