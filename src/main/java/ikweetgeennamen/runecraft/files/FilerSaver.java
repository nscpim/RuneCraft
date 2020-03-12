package ikweetgeennamen.runecraft.files;

import ikweetgeennamen.runecraft.core.PlayerData;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class FilerSaver {

    public static void savePlayerData() {

            FileLoader.playerData.set("players", PlayerData.getPlayerData());
            save(FileLoader.playerData, FileLoader.playerDataFile);

    }
    private static void save(FileConfiguration configuration, File file) {
        try {
            configuration.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
