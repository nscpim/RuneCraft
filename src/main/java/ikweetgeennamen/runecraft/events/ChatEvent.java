package ikweetgeennamen.runecraft.events;

import ikweetgeennamen.runecraft.RuneCraft;
import ikweetgeennamen.runecraft.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener
{
        private static RuneCraft plugin;

        @EventHandler
    public void OnChat(AsyncPlayerChatEvent e)
    {
        Player p = e.getPlayer();
        e.setCancelled(true);
        String message = e.getMessage();
        e.setMessage(Utils.chat(String.format("&6{0} &7: {1}", p.getDisplayName(), message)));


    }
}
