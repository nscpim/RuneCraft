package ikweetgeennamen.runecraft.commands;

import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.files.Skills;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLevelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
     Player p = (Player) sender;
     PlayerData data = PlayerData.getPlayerData(p);

    if (label.equalsIgnoreCase("level"))
    {
        int i = Integer.parseInt(args[0]);
        Skills skill = Skills.valueOf(args[1]);
        data.SetLevel(i,skill);
    }

        return false;
    }
}
