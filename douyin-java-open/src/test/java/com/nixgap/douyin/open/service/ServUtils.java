package com.nixgap.douyin.open.service;

import com.nixgap.douyin.open.config.DouYinClientConfigStorage;
import com.nixgap.douyin.open.config.impl.DouYinClientConfigStorageMemory;
import com.nixgap.douyin.open.service.impl.DouYinOpenServiceImpl;

import java.io.*;

public class ServUtils {

    public static String CLIENT_KEY = "";
    public static String CLIENT_SECRET = "";
    public static String OPEN_ID = "";
    public static String ACCESS_TOKEN = "";

    private static final DouYinOpenService DOU_YIN_OPEN_SERVICE = new DouYinOpenServiceImpl();

    static {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/config.ini")));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                String[] names = lineTxt.split("=");
                if (names[0].indexOf("CLIENT_KEY") > -1) {
                    CLIENT_KEY = names[1].trim();
                } else if (names[0].indexOf("CLIENT_SECRET") > -1) {
                    CLIENT_SECRET = names[1].trim();
                } else if (names[0].indexOf("OPEN_ID") > -1) {
                    OPEN_ID = names[1].trim();
                } else if (names[0].indexOf("ACCESS_TOKEN") > -1) {
                    ACCESS_TOKEN = names[1].trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DouYinClientConfigStorage config = new DouYinClientConfigStorageMemory(CLIENT_KEY, CLIENT_SECRET);
        DOU_YIN_OPEN_SERVICE.setClientConfigStorage(config);
    }

    public static DouYinOpenService getDouYinOpenService() {
        return DOU_YIN_OPEN_SERVICE;
    }
}
