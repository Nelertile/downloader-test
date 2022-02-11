package io.github.nottoxicdev;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Scanner;

public class Download {
    public static void download(String urlStr, String fileStr) throws Exception {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(fileStr);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "https://github.com/NotToxicDev/NotToxicDev/archive/refs/tags/1.0-DEV.zip";
        System.out.println(
                "Please enter your prefered directory to download to."
                        + "\nExample: C:/Users/someuser/downloads this would put it in someuser's downloads folder if you are on windows");
        String dir = sc.nextLine();
        String filePath = dir + "/download.zip";
        try {
            download(url, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
