package ikweetgeennamen.runecraft.commands;

import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.files.Skills;
import ikweetgeennamen.runecraft.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class xpCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        PlayerData data = PlayerData.getPlayerData(p);

if (label.equalsIgnoreCase("xp"))
{
    if (args.length <= 0)
    {
        p.sendMessage(Utils.chat(Utils.GetPrefix() + "Missing Arguments. Please type the skill you want to look at."));
        return false;
    }
        switch (args[0].toLowerCase())
        {
            case "mining":
                p.sendMessage((Utils.chat(Utils.GetPrefix() + "You have " +  data.getnewXP(Skills.Mining) + " xp in the " + data.getSkill(Skills.Mining).toString() + " skill.")));
                break;


        }
}


        return false;
    }
}
