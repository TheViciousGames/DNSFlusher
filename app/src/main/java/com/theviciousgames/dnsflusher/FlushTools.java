package com.theviciousgames.dnsflusher;

public class FlushTools {
    public static void flushDNS() {
        Superuser.executeCommandSU(Resources.FLUSH_DNS_1);

        Superuser.executeCommandSU(Resources.FLUSH_DNS_2);

        Superuser.executeCommandSU(Resources.FLUSH_DNS_3);

        Superuser.executeCommandSU(Resources.FLUSH_DNS_4);

        Superuser.executeCommandSU(Resources.FLUSH_DNS_5);

        Superuser.executeCommandSU(Resources.FLUSH_DNS_6);

        Superuser.executeCommandSU(Resources.FLUSH_DNS_7);
    }
}
