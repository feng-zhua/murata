package chickenfeet.murata.embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class RuleEmbed {

    public static EmbedBuilder createRulesEmbed() {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("<:6545primogem:1242079091902124043>" +  " Server Rules");
        embed.setColor(new Color(255, 69, 0));
        embed.setDescription("Welcome to the Natlan Discord server! Please adhere to the following rules to ensure a pleasant experience for everyone:");

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**General Conduct**",
                "• Be respectful and courteous.\n" +
                        "• Use common sense for any content sharing.\n" +
                        "• No hate speech or harassment.\n" +
                        "• Follow Discord's [Terms of Service](https://discord.com/terms) and [Guidelines](https://discord.com/guidelines)\n" +
                        "• No self-promotion or advertising without permission.\n" +
                        "• No spam or excessive messages.\n" +
                        "• NSWF content is strictly prohibited.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Channel Use**",
                "• Use appropriate channels for content.\n" +
                        "• Use bots in designated channels.\n" +
                        "• Avoid controversial topics such as religion and politics.\n" +
                        "• Focus on Genshin Impact and gaming-related content.\n" +
                        "• Be respectful in voice chats.\n" +
                        "• Use push-to-talk if necessary.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Privacy & Mental Health**",
                "• Do not share personal information (e.g., home address, credit card information).\n" +
                        "• The server is not responsible if you fail to protect your information.\n" +
                        "• No venting in the server channels.\n" +
                        "• If you need support, please seek professional help. Venting in DMs is allowed if both parties consent.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Modmail**",
                "• Open a Ticket for any inquires about the rules or consequences.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Respect Mods**",
                "• Follow moderators' instructions.\n", false);

        return embed;
    }

    public static EmbedBuilder createModEmbed() {
        EmbedBuilder mod = new EmbedBuilder();
        mod.setTitle("<:6545primogem:1242079091902124043>" + " Our Moderation System");
        mod.setColor(new Color(255, 69, 0)); // Red color for emphasis
        mod.setDescription("Make sure to read through this to understand our Moderation System:");

        mod.addField("<:5585pyrosigil:1242079070326489088>" + "**Discord AutoMod System**",
                "• We use Discord's official AutoMod System.\n" +
                        "• If you spam mention over 10 roles or users within one message it will get blocked and our Staff team will be alerted.\n" +
                        "• If your messages are suspected of being generic spam your message will be blocked and our Staff team will be alerted.\n" +
                        "• If your messages are triggering the automod profanity filter your message will be blocked and our Staff team will be alerted.\n" +
                        "• If the system detects any bad words in your messages your message will be deleted and you will be timed out.\n", false);

        mod.addField("<:5585pyrosigil:1242079070326489088>" + "**Wick Bot Mod System**",
                "• We also use the Wick Bot's System.\n" +
                        "• We use Wick to verify new members, there is no other way to access our server without verification. Contact Staff if you have trouble with this.\n" +
                        "• For every spam message you will be timed out.\n" +
                        "• For every malicious link you will be warned.\n" +
                        "• For every nsfw link you will be immediately kicked.\n" +
                        "• We use the Wick bot together with the bad words we have registered in the Discord Auto Mod, you will be warned and timed out when used.\n" +
                        "• Auto Ban.\n", false);

        mod.addField("<:5585pyrosigil:1242079070326489088>" + "**Staff**",
                "• Staff can and will warn, mute, kick or ban you if you go against our Rules.\n", false);

        return mod;
    }

    public static EmbedBuilder createConsequencesEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("<:6545primogem:1242079091902124043>" + " Consequences");
        embed.setColor(new Color(255, 69, 0)); // Red color for emphasis
        embed.setDescription("Please be aware of the consequences for breaking the rules:");

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Warnings**",
                "• Breaking rules will result in warnings.\n" +
                        "• The base of our Wick Bot Warning points is 5. " +
                        "Accumulate 25 points, and you will be kicked.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Immediate Bans**",
                "• Severe infractions can result in an immediate ban.\n" +
                        "• This includes hate speech or sharing explicit content.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Appeals**",
                "• If you believe you were wrongly warned or kicked, contact modmail to appeal.\n", false);

        OffsetDateTime now = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        embed.setFooter(" Last updated " + formattedDateTime);

        return embed;
    }

}
