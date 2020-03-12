package ikweetgeennamen.runecraft.events;

import ikweetgeennamen.runecraft.RuneCraft;
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



    }
}
