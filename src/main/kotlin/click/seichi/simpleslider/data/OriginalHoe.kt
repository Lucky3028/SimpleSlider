package click.seichi.simpleslider.data

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import de.tr7zw.itemnbtapi.NBTItem

object OriginalHoe {
    fun getOriginalHoe(): ItemStack {
        val itemMeta = Bukkit.getItemFactory().getItemMeta(Material.WOOD_HOE).apply {
            displayName = "${ChatColor.AQUA}Let's slide!"
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            addEnchant(Enchantment.THORNS, 0, true)
        }

        val hoe = ItemStack(Material.WOOD_HOE, 1).apply { setItemMeta(itemMeta) }

        return NBTItem(hoe).apply { setByte(NBTTagConstants.typeIdTag, 1.toByte()) }.item
    }

    fun isOriginalHoe(itemStack: ItemStack) =
        itemStack.type != Material.AIR && NBTItem(itemStack).getByte(NBTTagConstants.typeIdTag) == 1.toByte()

    object NBTTagConstants {
        val typeIdTag = "originalHoeItemTypeId"
    }
}