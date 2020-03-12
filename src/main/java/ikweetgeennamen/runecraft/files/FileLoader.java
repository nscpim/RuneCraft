package ikweetgeennamen.runecraft.files;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class FileLoader {

    public static FileConfiguration config;

    public static File configFile;
    public static File playerDataFile;

    public static FileConfiguration playerData;

    public FileLoader()
    {
        configFile = FileManager.getFileInDataFolder("config.yml");
        config = FileManager.loadConfiguration("config.yml");
        playerDataFile = FileManager.getFileInDataFolder("playerData.yml");
        playerData = FileManager.loadConfiguration("playerData.yml");
        Config.load();
    }
}
