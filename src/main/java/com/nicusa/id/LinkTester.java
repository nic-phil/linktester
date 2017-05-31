package com.nicusa.id;

import java.io.IOException;
import mslinks.*;

/**
 * Created by phil on 5/31/17.
 */
public class LinkTester {
    public static void main(String[] args) throws IOException {
            ShellLink sl = ShellLink.createLink("%COMSPEC% /C javaws 'https://otc.cdc.nicusa.com/downloads/SwiperApp/client_devices.jnlp'")
                    .setWorkingDir("..")
                    .setIconLocation("%SystemRoot%\\system32\\SHELL32.dll");
            sl.getHeader().setIconIndex(128);
            sl.getConsoleData()
                    .setFont(mslinks.extra.ConsoleData.Font.Consolas)
                    .setFontSize(24)
                    .setTextColor(5);

            try {
                System.out.println("Printing link");
                sl.saveTo("testlink.lnk");
            } catch (Exception e) {
                System.out.println("Exception");
            }

            System.out.println(sl.getWorkingDir());
            System.out.println(sl.resolveTarget());
    }
}
