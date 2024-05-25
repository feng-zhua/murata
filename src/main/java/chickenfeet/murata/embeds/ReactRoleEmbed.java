package chickenfeet.murata.embeds;

import chickenfeet.murata.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;
import java.util.List;

public class ReactRoleEmbed {

    //ping roles: server announcements, events, giveaways, primogems, genshin updates, leaks
    //pronouns roles: she her, he him, they them, ask pronouns, any pronouns, neo pronouns
    //age roles: -18, +18
    //vision roles: pyro, hydro, dendro, electro, geo, anemo, cyro
    //co-op roles: eu, na, asia, tw/hk/mo

    public static EmbedBuilder createPingRoleEmbed() {
        EmbedBuilder pingEmbed = new EmbedBuilder();
        pingEmbed.setTitle("Pings");
        pingEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        pingEmbed.setDescription("React with the corresponding emoji to get the role:");
        pingEmbed.addField("🔥 Server Announcements", "React with 🔥 to get the Pyro role", false);
        pingEmbed.addField("💧 Events", "React with 💧 to get the Hydro role", false);
        pingEmbed.addField("🌱 Giveaways", "React with 🌱 to get the Dendro role", false);
        pingEmbed.addField("🌬️ Primogems", "React with 🌬️ to get the Anemo role", false);
        pingEmbed.addField("⚡ Genshin Updates", "React with ⚡ to get the Electro role", false);
        pingEmbed.addField("❄️ Leaks", "React with ❄️ to get the Cryo role", false);
        return pingEmbed;
    }

    public static EmbedBuilder createPronounRoleEmbed() {
        EmbedBuilder pronounEmbed = new EmbedBuilder();
        pronounEmbed.setTitle("Pronouns");
        pronounEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        pronounEmbed.setDescription("React with the corresponding emoji to get the role:");
        pronounEmbed.addField("🔥 She/Her", "React with 🔥 to get the Pyro role", false);
        pronounEmbed.addField("💧 He/Him", "React with 💧 to get the Hydro role", false);
        pronounEmbed.addField("🌱 They/Them", "React with 🌱 to get the Dendro role", false);
        pronounEmbed.addField("🌬️ Ask Pronouns", "React with 🌬️ to get the Anemo role", false);
        pronounEmbed.addField("⚡ Any Pronouns", "React with ⚡ to get the Electro role", false);
        pronounEmbed.addField("❄️ Neo Pronouns", "React with ❄️ to get the Cryo role", false);
        return pronounEmbed;
    }

    public static EmbedBuilder createAgeRoleEmbed() {
        EmbedBuilder ageEmbed = new EmbedBuilder();
        ageEmbed.setTitle("Age");
        ageEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        ageEmbed.setDescription("React with the corresponding emoji to get the role:");
        ageEmbed.addField("🔥 -18 ", "React with 🔥 to get the Pyro role", false);
        ageEmbed.addField("💧 +18 ", "React with 💧 to get the Hydro role", false);
        return ageEmbed;
    }

    public static EmbedBuilder createVisionRoleEmbed() {
        EmbedBuilder visionEmbed = new EmbedBuilder();
        visionEmbed.setTitle("Vision");
        visionEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        visionEmbed.setDescription("React with the corresponding emoji to get the role:");
        visionEmbed.addField("🔥 Pyro", "React with 🔥 to get the Pyro role", false);
        visionEmbed.addField("💧 Hydro", "React with 💧 to get the Hydro role", false);
        visionEmbed.addField("🌱 Dendro", "React with 🌱 to get the Dendro role", false);
        visionEmbed.addField("🌬️ Anemo", "React with 🌬️ to get the Anemo role", false);
        visionEmbed.addField("⚡ Electro", "React with ⚡ to get the Electro role", false);
        visionEmbed.addField("❄️ Cryo", "React with ❄️ to get the Cryo role", false);
        visionEmbed.addField("🪨 Geo", "React with 🪨 to get the Geo role", false);
        return visionEmbed;
    }

    public static EmbedBuilder createCoopRoleEmbed() {
        EmbedBuilder coopRoleEmbed = new EmbedBuilder();
        coopRoleEmbed.setTitle("CO-OP");
        coopRoleEmbed.setColor(new Color(0, 153, 255)); // Light blue color for aesthetic
        coopRoleEmbed.setDescription("React with the corresponding emoji to get the role:");
        coopRoleEmbed.addField("🔥 EU", "React with 🔥 to get the Pyro role", false);
        coopRoleEmbed.addField("💧 NA", "React with 💧 to get the Hydro role", false);
        coopRoleEmbed.addField("🌱 ASIA", "React with 🌱 to get the Dendro role", false);
        coopRoleEmbed.addField("🌬️ TW/HK/MO", "React with 🌬️ to get the Anemo role", false);
        return coopRoleEmbed;
    }

    public void execute(SlashCommandInteractionEvent event) {
        event.replyEmbeds(createPingRoleEmbed().build()).queue();
        event.replyEmbeds(createPronounRoleEmbed().build()).queue();
        event.replyEmbeds(createAgeRoleEmbed().build()).queue();
        event.replyEmbeds(createVisionRoleEmbed().build()).queue();
        event.replyEmbeds(createCoopRoleEmbed().build()).queue();
    }
}
