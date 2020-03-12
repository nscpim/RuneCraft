package ikweetgeennamen.runecraft.utils;

import org.bukkit.ChatColor;

public class Utils {
    public static String chat (String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    public static String GetPrefix(){
        String prefix = chat("&7[&aRC&7] ");
        return prefix;
    }

}
