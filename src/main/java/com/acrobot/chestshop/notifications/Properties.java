package com.acrobot.chestshop.notifications;

import com.Acrobot.Breeze.Configuration.ConfigurationComment;

/**
 * @author Acrobot
 */
public class Properties {

    @ConfigurationComment("Do you want to show notifications on shop creation?")
    public static boolean SHOW_NOTIFICATION_ON_SHOP_CREATION = true;

    @ConfigurationComment("Do you want to show notifications on transaction?")
    public static boolean SHOW_NOTIFICATION_ON_TRANSACTION = false;
}
