package com.ostaframework.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Android on 11/18/2015.
 */
public class DirManagement {

    public DirManagement() {


    }

    public DirManagement(Context context) {


    }

    /**
     * Used to check and create directory in sdcard
     *
     * @param path  of folder name
     */
    public static boolean createDirIfNotExists(String path) {
        boolean ret = true;

        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + path);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                Log.e("Root folder :: ", "Problem creating Root folder");
                ret = false;
            }
        }
        return ret;
    }
    /**
     * Used to delete file from sdcard
     *
     * @param path  that for name of file
     */
    public static boolean deleteFile(String path) {

        boolean ret = false;
        File file = new File(path);
        return ret = file.delete();

    }
    /**
     * Used to give us list file of folder in sdcard
     *
     * @param path  that folder name is sdcard
     */
    public static String[] getDirectoryList(String path) {
        String[] dirListing = null;
        File dir = new File(path);
        dirListing = dir.list();
        Arrays.sort(dirListing, 0, dirListing.length);
        return dirListing;
    }
    /**
     * Used to give us for checking file exists or not
     *
     * @param path  that directory and filename of file need to check
     */
    public static boolean isFileExits(String path) {

        boolean ret = false;
        File file = new File(path);
        if(file.exists())
            ret=true;
        else
            ret=false;

        return ret;
    }


}
