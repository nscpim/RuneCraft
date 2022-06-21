package ikweetgeennamen.runecraft.core;

import ikweetgeennamen.runecraft.files.Config;
import ikweetgeennamen.runecraft.files.FilerSaver;
import ikweetgeennamen.runecraft.files.Skills;
import ikweetgeennamen.runecraft.utils.InventorySerializer;
import ikweetgeennamen.runecraft.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import java.util.*;


public class PlayerData implements ConfigurationSerializable
{
    public static ArrayList<PlayerData> playerData = new ArrayList<>();

    private UUID uuid;

    private Inventory inventory = Bukkit.createInventory(null, 54);

    private Integer cash = Integer.valueOf(0);

    private Integer xp = Integer.valueOf(0);

    private Location location;

    private Map<Skills, Integer> skillXP = new HashMap<>();

    private Map<Skills, Integer> skillLevel = new HashMap<>();

    public Player getPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }

    public PlayerData(UUID uUID) {
        this.uuid = uUID;
        updatePlayer();
        playerData.add(this);
        this.cash = Config.MONEYSTARTINGVALUE.getIntVal();
        for (Skills enumSkills: Skills.values())
        {
            skillXP.put(enumSkills, 0);
        }
        for (Skills levelSKills: Skills.values())
        {
            skillLevel.put(levelSKills, 1);
        }
    }
    public void addToCash(int i) {
        this.cash = Integer.valueOf(this.cash.intValue() + i);
    }
    public void subtractFromCash(int i) {
        this.cash = Integer.valueOf(this.cash.intValue() - i);
    }
    public Integer getCash() {
        return this.cash;
    }
    public UUID getUUID() {
        return this.uuid;
    }
    public Integer getXp() {
        return this.xp;
    }

    public void setCash(int i) {
        this.cash = Integer.valueOf(i);
    }
    public void addXP(Integer amount, Skills skill)
    {
        PlayerData data = this;
        Integer xp = data.skillXP.get(skill);
        xp += amount;
        data.skillXP.put(skill,xp);
        data.xp += amount;
        FilerSaver.savePlayerData();
    }
    public Integer getnewXP(Skills skill)
    {
        PlayerData data = this;
        Integer xp = data.skillXP.get(skill);
        return xp;
    }
    public void SetLevel(int i, Skills skill)
    {
        this.skillLevel.put(Skills.Mining, i);
    }

    public Integer getLevel(Skills skill)
    {
      return this.skillLevel.get(skill);
    }
    public Skills getSkill(Skills skill)
    {
        return skill;
    }



    public void subtractXp(int xp) {
        if (this.xp.intValue() - xp >= 0) {
            PlayerData playerData = this;
            playerData.xp = Integer.valueOf(playerData.xp.intValue() - xp);
        }
    }
    public Inventory getInventory() {
        return this.inventory;
    }
    public void resetInventory() {
        this.inventory = Bukkit.createInventory(null, 54);
    }

    public Location getLocation() {
        return this.location;
    }

    public void updatePlayer() {
        this.inventory = getPlayer().getInventory();
        this.location = getPlayer().getLocation();
    }
    public static PlayerData getPlayerData(Player p) {
        for (PlayerData data : getPlayerData()) {
            if (data.getUUID().equals(p.getUniqueId()))
                return data;
        }
        FilerSaver.savePlayerData();
        System.out.println(Utils.chat(Utils.GetPrefix() + "Made new playerData for " + p.getName()));
        return new PlayerData(p.getUniqueId());
    }

    public static ArrayList<PlayerData> getPlayerData() {
        return playerData;
    }
    public PlayerData(Map<String, Object> map) {
        try {
            this.uuid = UUID.fromString((String) map.get("UUID"));
            this.cash = (Integer)map.get("cash");
            this.xp = (Integer)map.get("xp");
            this.skillXP = (Map<Skills, Integer>) map.get("skillxp");
            this.skillLevel = (Map<Skills, Integer>) map.get("skilllevel");
            this.location = (Location)map.get("location");
            this.inventory = InventorySerializer.fromString((String)map.get("inventory"));
            System.out.println("Successfully loaded playerData of " + getUUID());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load playerData of " + map.get("UUID"));
        }
    }

    public static PlayerData deserialize(Map<String, Object> map) {
        PlayerData i = new PlayerData(map);
        playerData.add(i);
        return i;
    }
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("UUID", this.uuid.toString());
        map.put("money", this.cash);
        map.put("skillxp", this.skillXP);
        map.put("skilllevel", this.skillLevel);
        map.put("xp", this.xp);
        map.put("location", this.location);
        map.put("inventory", InventorySerializer.toString(this.inventory));
        return map;
    }



}
