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
        pingEmbed.setColor(new Color(186, 0, 0));
        pingEmbed.setDescription("");
        pingEmbed.addField("<:9909intertwinedfate:1242079125577924648>", "Server Announcements", false);
        pingEmbed.addField("<:6997acquaintfate:1242079124013580311>", "Events", false);
        pingEmbed.addField("<:4611genesiscrystal:1242079127117496381>", "Giveaways", false);
        pingEmbed.addField("<:6545primogem:1242079091902124043>", "Primogems", false);
        pingEmbed.addField("<:3981fragileresin:1242079194486280222>", "Genshin Updates", false);
        pingEmbed.addField("<:pyrocons:1245375886895743076>", "Leaks", false);
        return pingEmbed;
    }

    public static EmbedBuilder createPronounRoleEmbed() {
        EmbedBuilder pronounEmbed = new EmbedBuilder();
        pronounEmbed.setTitle("Pronouns");
        pronounEmbed.setColor(new Color(186, 0, 0));
        pronounEmbed.setDescription("");
        pronounEmbed.addField("<:6920pastelrednumberone:1245467132033241098>", "She/Her", false);
        pronounEmbed.addField("<:7833pastelrednumbertwo:1245467130753847447>", "He/Him", false);
        pronounEmbed.addField("<:7283pastelrednumberthree:1245467129021730919>", "They/Them", false);
        pronounEmbed.addField("<:7283pastelrednumberfour:1245467127821898000>", "Ask Pronouns", false);
        pronounEmbed.addField("<:9437pastelrednumberfive:1245467125968011294>", "Any Pronouns", false);
        pronounEmbed.addField("<:2052pastelrednumbersix:1245467124672233542>", " Neo Pronouns", false);
        return pronounEmbed;
    }

    public static EmbedBuilder createAgeRoleEmbed() {
        EmbedBuilder ageEmbed = new EmbedBuilder();
        ageEmbed.setTitle("Age");
        ageEmbed.setColor(new Color(186, 0, 0));
        ageEmbed.setDescription("");
        ageEmbed.addField("<:6920pastelrednumberone:1245467132033241098>", "-18 ", false);
        ageEmbed.addField("<:7833pastelrednumbertwo:1245467130753847447>", "+18", false);
        return ageEmbed;
    }

    public static EmbedBuilder createVisionRoleEmbed() {
        EmbedBuilder visionEmbed = new EmbedBuilder();
        visionEmbed.setTitle("Vision");
        visionEmbed.setColor(new Color(186, 0, 0));
        visionEmbed.setDescription("");
        visionEmbed.addField("<:5585pyrosigil:1242079070326489088>", "Pyro", false);
        visionEmbed.addField("<:4378hydrosigil:1245461976352690299>", "Hydro", false);
        visionEmbed.addField("<:7452dendrosigil:1245461919020617778>", "Dendro", false);
        visionEmbed.addField("<:8230anemosigil:1245461974867775659>", "Anemo", false);
        visionEmbed.addField("<:5286electrosigil:1245461972045271111>", "Electro", false);
        visionEmbed.addField("<:8305cryosigil:1245461970447237242>", "Cryo", false);
        visionEmbed.addField("<:4471geosigil:1245461973379055699>", "Geo", false);
        return visionEmbed;
    }

    public static EmbedBuilder createCoopRoleEmbed() {
        EmbedBuilder coopRoleEmbed = new EmbedBuilder();
        coopRoleEmbed.setTitle("CO-OP");
        coopRoleEmbed.setColor(new Color(186, 0, 0));
        coopRoleEmbed.setDescription("React with the corresponding emoji to get the role:");
        coopRoleEmbed.addField("<:6920pastelrednumberone:1245467132033241098>", "EU", false);
        coopRoleEmbed.addField("<:7833pastelrednumbertwo:1245467130753847447>", "NA", false);
        coopRoleEmbed.addField("<:7283pastelrednumberthree:1245467129021730919>", "ASIA", false);
        coopRoleEmbed.addField("<:7283pastelrednumberfour:1245467127821898000>", "TW/HK/MO", false);
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
