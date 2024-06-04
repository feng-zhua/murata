package chickenfeet.murata.embeds;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ReactRoleEmbed {

    public static EmbedBuilder createRoleEmbed() {
        EmbedBuilder roleEmbed = new EmbedBuilder();
        roleEmbed.setTitle("Server Roles");
        roleEmbed.setColor(new Color(186, 0, 0));
        roleEmbed.setDescription("Hi Travelers, here's all of our selectable roles of the Server. Make sure to react with the corresponding emotes to claim your preferred roles.");
        roleEmbed.setImage("https://i.imgur.com/2gSCivc.png");
        return roleEmbed;
    }

    public static EmbedBuilder createPingRoleEmbed() {
        EmbedBuilder pingEmbed = new EmbedBuilder();
        pingEmbed.setTitle("Pings");
        pingEmbed.setColor(new Color(186, 0, 0));
        pingEmbed.addField("",
                "<:9909intertwinedfate:1242079125577924648> Server Announcements\n" +
                        "<:6997acquaintfate:1242079124013580311> Events\n" +
                        "<:4611genesiscrystal:1242079127117496381> Giveaways\n" +
                        "<:6545primogem:1242079091902124043> Primogems\n" +
                        "<:3981fragileresin:1242079194486280222> Genshin Updates\n" +
                        "<:pyrocons:1245375886895743076> Leaks", false);
        pingEmbed.setImage("https://i.imgur.com/5yvCwxv.png");
        return pingEmbed;
    }

    public static EmbedBuilder createPronounRoleEmbed() {
        EmbedBuilder pronounEmbed = new EmbedBuilder();
        pronounEmbed.setTitle("Pronouns");
        pronounEmbed.setColor(new Color(186, 0, 0));
        pronounEmbed.addField("",
                "<:6920pastelrednumberone:1245467132033241098> She/Her\n" +
                        "<:7833pastelrednumbertwo:1245467130753847447> He/Him\n" +
                        "<:7283pastelrednumberthree:1245467129021730919> They/Them\n" +
                        "<:7283pastelrednumberfour:1245467127821898000> Ask Pronouns\n" +
                        "<:9437pastelrednumberfive:1245467125968011294> Any Pronouns\n" +
                        "<:2052pastelrednumbersix:1245467124672233542> Neo Pronouns", false);
        pronounEmbed.setImage("https://i.imgur.com/5yvCwxv.png");
        return pronounEmbed;
    }

    public static EmbedBuilder createAgeRoleEmbed() {
        EmbedBuilder ageEmbed = new EmbedBuilder();
        ageEmbed.setTitle("Age");
        ageEmbed.setColor(new Color(186, 0, 0));
        ageEmbed.addField("",
                "<:4835masterlessstar:1242079164714975232> -18\n" +
                        "<:7640masterlessdust:1242079166338306079> +18", false);
        ageEmbed.setImage("https://i.imgur.com/5yvCwxv.png");
        return ageEmbed;
    }

    public static EmbedBuilder createVisionRoleEmbed() {
        EmbedBuilder visionEmbed = new EmbedBuilder();
        visionEmbed.setTitle("Vision");
        visionEmbed.setColor(new Color(186, 0, 0));
        visionEmbed.addField("",
                "<:5585pyrosigil:1242079070326489088> Pyro\n" +
                        "<:4378hydrosigil:1245461976352690299> Hydro\n" +
                        "<:7452dendrosigil:1245461919020617778> Dendro\n" +
                        "<:8230anemosigil:1245461974867775659> Anemo\n" +
                        "<:5286electrosigil:1245461972045271111> Electro\n" +
                        "<:8305cryosigil:1245461970447237242> Cryo\n" +
                        "<:4471geosigil:1245461973379055699> Geo", false);
        visionEmbed.setImage("https://i.imgur.com/5yvCwxv.png");
        return visionEmbed;
    }

    public static EmbedBuilder createCoopRoleEmbed() {
        EmbedBuilder coopRoleEmbed = new EmbedBuilder();
        coopRoleEmbed.setTitle("CO-OP");
        coopRoleEmbed.setColor(new Color(186, 0, 0));
        coopRoleEmbed.addField("",
                "<:3852itempreciouschest:1247121917232549900> EU \n" +
                        "<:2924itemremarkablechest:1247121915139592263> NA\n" +
                        "<:2924itemexquisitechest:1247121913440895036> ASIA\n" +
                        "<:2170itemluxuriouschest:1247121909993439274> TW/HK/MO", false);
        coopRoleEmbed.setImage("https://i.imgur.com/5yvCwxv.png");
        return coopRoleEmbed;
    }
}
