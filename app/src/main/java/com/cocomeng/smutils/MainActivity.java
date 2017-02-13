package com.cocomeng.smutils;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.util.SystemNativeCryptoLibrary;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encryption();
    }

    private void encryption() {
        // Creates a new Crypto object with default implementations of
        // a key chain as well as native library.
        Crypto crypto = new Crypto(new SharedPrefsBackedKeyChain(this),new SystemNativeCryptoLibrary());

        // Check for whether the crypto functionality is available
        // This might fail if Android does not load libaries correctly.
        if (!crypto.isAvailable()) {
            Toast.makeText(this, "ENCRYPTION FAIL!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            //加密后的文件路径
            File file = new File(Environment.getExternalStorageDirectory() + "/text.txt");

            OutputStream fileStream = new BufferedOutputStream(new FileOutputStream(file));

            com.facebook.crypto.Entity entity = new com.facebook.crypto.Entity("text");

            // Creates an output stream which encrypts the data as
            // it is written to it and writes it out to the file.
            OutputStream outputStream;
            outputStream = crypto.getCipherOutputStream(fileStream, entity);
            //需要加密的text
            String plainString = "TEST！！！测试！！！";
            //将String变为byt[]类型
            byte[] plainText = plainString.getBytes();

            // Write plaintext to it.
            outputStream.write(plainText);
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CryptoInitializationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (KeyChainException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
