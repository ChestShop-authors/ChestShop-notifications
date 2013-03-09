package com.acrobot.chestshop.notifications;

import com.Acrobot.Breeze.Configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author Acrobot
 */
public class Notifications extends JavaPlugin {
    private static File dataFolder;

    public void onEnable() {
        dataFolder = getDataFolder();

        Configuration.pairFileAndClass(loadFile("config.yml"), Properties.class);

        if (Properties.SHOW_NOTIFICATION_ON_TRANSACTION) {
            getServer().getPluginManager().registerEvents(new TransactionListener(), this);
        }

        if (Properties.SHOW_NOTIFICATION_ON_SHOP_CREATION) {
            getServer().getPluginManager().registerEvents(new ShopCreationListener(), this);
        }
    }

    public static File loadFile(String string) {
        File file = new File(dataFolder, string);

        return loadFile(file);
    }

    private static File loadFile(File file) {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }
}
