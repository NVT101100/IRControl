package com.khoaluan;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FileReader {
    public HashMap<String,String> keyboard = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public FileReader(Context context, @RawRes int id) {
        try {
            InputStream is = context.getResources().openRawResource(id);
            try {
                BufferedReader buffered = new BufferedReader(new InputStreamReader(is));
                try {
                    StringBuilder string = new StringBuilder();
                    String line = "";
                    do {
                        if(line != null && line != "") {
                            String split[] = line.split(":");
                            this.keyboard.put(split[0],split[1]);
                        }
                        System.out.println(line);
                        line = buffered.readLine();
                    } while (line != null);
                } finally {
                    buffered.close();
                }
            } finally {
                is.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
