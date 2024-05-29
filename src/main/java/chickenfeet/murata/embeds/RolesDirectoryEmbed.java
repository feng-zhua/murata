package chickenfeet.murata.embeds;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class RolesDirectoryEmbed {

    public static EmbedBuilder createAdminRoleEmbed() {
        EmbedBuilder pingEmbed = new EmbedBuilder();
        pingEmbed.setTitle("Admins");
        pingEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        pingEmbed.setDescription("Admin roles");
        pingEmbed.addField("Owner", "React with 🔥 to get the Pyro role", false);
        pingEmbed.addField("Admin", "React with 💧 to get the Hydro role", false);
        pingEmbed.addField("Lead Mod", "React with 🌱 to get the Dendro role", false);
        return pingEmbed;
    }

    public static EmbedBuilder createLeadRolesEmbed() {
        //redirect to staff application
        EmbedBuilder pingEmbed = new EmbedBuilder();
        pingEmbed.setTitle("Admins");
        pingEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        pingEmbed.setDescription("Admin roles");
        pingEmbed.addField("Lead Event", "React with 🔥 to get the Pyro role", false);
        pingEmbed.addField("Lead", "React with 💧 to get the Hydro role", false);
        pingEmbed.addField("Lead", "React with 🌱 to get the Dendro role", false);
        return pingEmbed;
    }

    public static EmbedBuilder createModRolesEmbed() {
        //redirect to staff application
        EmbedBuilder pingEmbed = new EmbedBuilder();
        pingEmbed.setTitle("Admins");
        pingEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        pingEmbed.setDescription("Admin roles");
        pingEmbed.addField("Owner", "React with 🔥 to get the Pyro role", false);
        pingEmbed.addField("Admin", "React with 💧 to get the Hydro role", false);
        pingEmbed.addField("Lead Mod", "React with 🌱 to get the Dendro role", false);
        return pingEmbed;
    }

    public static EmbedBuilder createServerRolesEmbed() {
        //redirect to role application
        EmbedBuilder pingEmbed = new EmbedBuilder();
        pingEmbed.setTitle("Server Roles");
        pingEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        pingEmbed.setDescription("Server Roles");
        pingEmbed.addField("Server Booster", "React with 🔥 to get the Pyro role", false);
        pingEmbed.addField("Children of Murata", "React with 🔥 to get the Pyro role", false);

        return pingEmbed;
    }

    public static EmbedBuilder createSpecialGenshinRolesEmbed() {
        //redirect to role application
        EmbedBuilder pingEmbed = new EmbedBuilder();
        pingEmbed.setTitle("Genshin Roles");
        pingEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        pingEmbed.setDescription("Genshin Roles");
        pingEmbed.addField("Whale", "React with 🔥 to get the Pyro role", false);
        pingEmbed.addField("Collector", "React with 💧 to get the Hydro role", false);
        pingEmbed.addField("Dolphin", "React with 🌱 to get the Dendro role", false);
        return pingEmbed;
    }
}
