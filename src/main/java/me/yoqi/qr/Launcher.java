package me.yoqi.qr;

/**
 * JavaFX 11+ 启动入口。
 * 从 classpath 启动时，Main-Class 不能继承 {@link javafx.application.Application}，
 * 否则 JDK 会报 "JavaFX runtime components are missing"，故由本类转调 MainFm。
 *
 * @author liuyuqi
 */
public final class Launcher {

    private Launcher() {
    }

    public static void main(String[] args) {
        MainFm.main(args);
    }
}
