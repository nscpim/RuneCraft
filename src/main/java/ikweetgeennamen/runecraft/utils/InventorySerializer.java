package ikweetgeennamen.runecraft.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class InventorySerializer {
    public static Inventory fromString(String strInv) {
        Inventory inventory = Bukkit.getServer().createInventory(null, 9);
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(strInv));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());
            for (int i = 0; i < inventory.getSize(); i++)
                inventory.setItem(i, (ItemStack)dataInput.readObject());
            dataInput.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Inventory malformed exception while reading inventory!");
        }
        return inventory;
    }

    public static String toString(Inventory inv) {
        String inventory = "";
        try {
            int invSize = (inv.getSize() % 9 == 0) ? inv.getSize() : (inv.getSize() % 9 * 9);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
            dataOutput.writeInt(invSize);
            for (int i = 0; i < invSize; i++)
                dataOutput.writeObject(inv.getItem(i));
            dataOutput.close();
            inventory = Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            System.out.println("Inventory malformed exception while writing inventoru!");
        }
        return inventory;
    }
}

