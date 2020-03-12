package ikweetgeennamen.runecraft.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileManager {

    public static FileConfiguration loadConfiguration(String fileName) {
        File file = getFileInDataFolder(fileName);
        if (FileLoader.config != null)
            System.out.println("Loading file "  + fileName);
        if (!file.exists()) {
           Bukkit.getPluginManager().getPlugin("RuneCraft").saveResource(fileName, false);
        }

            YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(file);
        } catch (IOException |org.bukkit.configuration.InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return yamlConfiguration;
    }
    public static File getFileInDataFolder(String fileName) {
        return new File(Bukkit.getPluginManager().getPlugin("RuneCraft").getDataFolder(), fileName);
    }
}
