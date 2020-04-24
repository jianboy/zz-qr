package me.yoqi.qr.utils;

import java.lang.reflect.Field;

import me.yoqi.qr.MainFm;
import me.yoqi.qr.snap.ScreenCapture;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import cn.hutool.log.StaticLog;

public class GlobalKeyListener implements NativeKeyListener {
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_F4){
            preventEvent(e);
            MainFm.doSnap();
        }
        else if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE){
            if (ScreenCapture.isSnapping){
                preventEvent(e);
                MainFm.cancelSnap();
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    private void preventEvent(NativeKeyEvent e){
        try {
            Field f = NativeInputEvent.class.getDeclaredField("reserved");
            f.setAccessible(true);
            f.setShort(e, (short) 0x01);
        }
        catch (Exception ex) {
            StaticLog.error(ex);
        }
    }
}
