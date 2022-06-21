package ikweetgeennamen.runecraft.events;

import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.files.Skills;
import ikweetgeennamen.runecraft.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MiningSkill implements Listener {

    @EventHandler
    public void OnMine(BlockBreakEvent e)
    {
        Player p = e.getPlayer();
        PlayerData data = PlayerData.getPlayerData(p);
        System.out.println(p.getInventory().getHeldItemSlot());
        System.out.println(p.getInventory().getItemInMainHand().getType().toString());
        e.setCancelled(true);

        switch(e.getBlock().getBlockData().getMaterial())
        {
            case COAL_ORE:
                if (p.getInventory().getItemInMainHand().getType().equals(Material.STONE_PICKAXE) && data.getLevel(Skills.Mining) >= 10)
                {
                    data.addXP(15, Skills.Mining);
                    p.sendTitle(Utils.chat("&7Mining"),Utils.chat("&a+15xp"),30, 20,30);
                    p.sendMessage(Utils.chat(Utils.GetPrefix() + "&7You mined some &0coal &7ore."));

                }
                else if (!p.getInventory().getItemInMainHand().getType().equals(Material.STONE_PICKAXE))
                {
                    p.sendMessage(Utils.chat(Utils.GetPrefix() + "&cYou need a &7stone pickaxe&c to mine here"));
                }
                else if (data.getLevel(Skills.Mining) < 10)
                {
                    p.sendMessage(Utils.chat(Utils.GetPrefix() + "&cYou need a mining level of &a10&c to mine this"));
                }
                break;
            case IRON_ORE:
                if (p.getInventory().getItemInMainHand().getType().equals(Material.STONE_PICKAXE) && data.getLevel(Skills.Mining) >= 10)
                {
                    data.addXP(30, Skills.Mining);
                    p.sendTitle(Utils.chat("&7Mining"),Utils.chat("&a+30xp"),30, 20,30);
                    p.sendMessage(Utils.chat(Utils.GetPrefix() + "&7You mined some &8iron &7ore."));

                }
                else if (!p.getInventory().getItemInMainHand().getType().equals(Material.STONE_PICKAXE))
                {
                    p.sendMessage(Utils.chat(Utils.GetPrefix() + "&cYou need a &7stone pickaxe&c to mine here"));
                }
                else if (data.getLevel(Skills.Mining) < 15)
                {
                    p.sendMessage(Utils.chat(Utils.GetPrefix() + "&cYou need a mining level of &a15&c to mine this"));
                }
                break;
        }



    }


    public void MiningOre(Material minedMat, Material requiredPickaxe, Integer skilllevel, PlayerData data, Player p)
    {
       if (data.getLevel(Skills.Mining) < skilllevel)
       {
            p.sendMessage(Utils.chat(Utils.GetPrefix() + "&cYou do not meet the required level to mine this!"));
            return;
       }
       else
           {


           }


    }
}
