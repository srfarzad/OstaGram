package com.ostaframework.ui;

import android.graphics.Color;

import com.ostaframework.utils.Logger;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by Android on 7/15/2016.
 */
public class RandomColor implements Serializable {

    public static int getRandomColor(UUID id) {

        byte[] bytes = UUID2Bytes(id);

        int r= Math.abs(bytes[0]);
        int g = Math.abs(bytes[1]);
        int b = Math.abs(bytes[2]);
        int color = Color.argb(255, r, g, b);
        Logger.Log("RandomColor",color+"");
        return  color;
    }

    public static  byte[] UUID2Bytes(UUID uuid) {

        long hi = uuid.getMostSignificantBits();
        long lo = uuid.getLeastSignificantBits();
        Logger.Log("UUID2Bytes",hi+"  "+lo);
        return ByteBuffer.allocate(16).putLong(hi).putLong(lo).array();
    }

}
