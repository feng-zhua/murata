
package chickenfeet.murata.embeds;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RolesDirectoryEmbed {

    //booster - 1241876720517124148
    //whale - 1242807712581029938
    //collector - 1242808075593842809
    //dolphin - 1242807685670371400
    //children of murata - 1244250774632923136

    private static final List<String> ROLE_IDS = Arrays.asList(
            "1241876720517124148", // booster
            "1244250774632923136", // children of murata
            "1242807712581029938", // whale
            "1242808075593842809", // collector
            "1242807685670371400"  // dolphin
    );

    private static final List<String> CHANNEL_IDS = Arrays.asList(
            "1241960896373461022", // role application
            "1252218557534699612",  // whale category
            "1251625799321256037" //whale events
    );


    public static EmbedBuilder createRoleEmbed() {
        EmbedBuilder roleEmbed = new EmbedBuilder();
        roleEmbed.setTitle(null);
        roleEmbed.setColor(new Color(186, 0, 0));
        roleEmbed.addField("Obtainable Roles","Hi Travelers, here's all of our special roles of the Server. Check out <#" + CHANNEL_IDS.get(0) + ">" +
                " if you want to know how to apply for the roles.", false);
        roleEmbed.setImage("https://i.imgur.com/2gSCivc.png");
        return roleEmbed;
    }

    public static EmbedBuilder createRequirEmbed() {
        EmbedBuilder require = new EmbedBuilder();
        require.setTitle(null);
        require.setColor(new Color(186, 0, 0));

        // Add fields with role mentions
        require.addField("Requirements",
                "<@&" + ROLE_IDS.get(0) + ">\nTo acquire the Server Booster role you must simply boost our Server. \n " +
                        "<@&" + ROLE_IDS.get(1) + ">\nTo acquire the Children of Murata role you must have our vanity URL in your custom status. \n" +
                        "<@&" + ROLE_IDS.get(2) + ">\nTo acquire the Whale role you must have at least 3 C6 5* Characters (limited or standard) AND at least 1 5* R5 Weapon (limited or standard). \n" +
                        "<@&" + ROLE_IDS.get(3) + ">\nTo acquire the Collector role you must have either every 5* Character or every 4* Character. \n" +
                        "<@&" + ROLE_IDS.get(4) + ">\nTo acquire the Dolphin role you must have either purchased the last 5 Battle Passes or 3 C6 4* Characters.", false);

        require.setImage("https://i.imgur.com/5yvCwxv.png");

        return require;
    }

    public static EmbedBuilder createPerksEmbed() {
        EmbedBuilder perk = new EmbedBuilder();
        perk.setTitle(null);
        perk.setColor(new Color(186, 0, 0));

        // Add fields with role mentions
        perk.addField("Perks",
                "<@&" + ROLE_IDS.get(0) + ">\nYou will get various rewards, permissions and access to our booster channels \n" +
                        "<@&" + ROLE_IDS.get(1) + ">\nYour name will be displayed separately from other Travelers \n" +
                        "IMPORTANT: The Vanity Bot is currently undergoing some changes. " +
                        "This role will most likely not work in the moment, please be patient until we find a solution for this! \n" +
                        "<@&" + ROLE_IDS.get(2) + ">\nYou will get access to our special <#" + CHANNEL_IDS.get(1) +  ">" +
                        " and are able to join special <#" + CHANNEL_IDS.get(2) + "> of our Server! \n" +
                        "<@&" + ROLE_IDS.get(3) + ">\nYour name will be displayed separately from other Travelers \n" +
                        "<@&" + ROLE_IDS.get(4) + ">\nYour name will be displayed separately from other Travelers ", false);

        perk.setImage("https://i.imgur.com/5yvCwxv.png");

        return perk;
    }

    /*public static EmbedBuilder createRequirEmbed() {
        EmbedBuilder require = new EmbedBuilder();
        require.setTitle("How to apply");
        require.setColor(new Color(186, 0, 0));

        // Add fields with role mentions
        require.addField("Requirements",
                "<@&" + ROLE_IDS.get(0) + ">\nTo acquire the Server Booster role you must simply boost our Server. \n" +
                        "Open a Ticket to claim your additional custom role and for your first boost a 160 Primogems Top-Up.", false);

        require.addField("Children of Murata Role",
                "<@&" + ROLE_IDS.get(1) + ">\nTo acquire the Children of Murata role you must have our vanity URL in your custom status. \n" +
                "IMPORTANT: The Vanity Bot is currently undergoing some changes. " +
                        "This role will most likely not work in the moment, please be patient until we find a solution for this!", false);

        require.addField("Whale Role",
                "<@&" + ROLE_IDS.get(2) + ">\nTo acquire the Whale role you must have at least 3 C6 5* Characters (limited or standard) AND at least 1 5* R5 Weapon (limited or standard). \n" +
                        "You will get access to our special #Whale channel and are able to join special events of our Server!" +
                        "Open a ticket and send us a screenshot of your Characters and Weapons and your in-game Profile with your Discord tag in the User Signature.", false);

        require.addField("Collector Role",
                "<@&" + ROLE_IDS.get(3) + ">\nTo acquire the Collector role you must have either every 5* Character or every 4* Character. \n" +
                        "Open a ticket and send us a screenshot of your Character Inventory and your in-game Profile with your Discord tag in the User Signature.", false);

        require.addField("Dolphin Role",
                "<@&" + ROLE_IDS.get(4) + ">\nTo acquire the Dolphin role you must have either purchased the last 5 Battle Passes or 3 C6 4* Characters. \n" +
                        "Open a ticket and send us a screenshot of either your Characters or Namecard Inventory and your in-game Profile with your Discord tag in the User Signature.", false);

        require.setImage("https://i.imgur.com/5yvCwxv.png");

        return require;
    }*/

}

