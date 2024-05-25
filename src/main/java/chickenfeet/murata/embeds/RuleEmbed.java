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
                        "• No alternate accounts allowed.\n" +
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

    public static EmbedBuilder createConsequencesEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("<:6545primogem:1242079091902124043>" + " Consequences");
        embed.setColor(new Color(255, 69, 0)); // Red color for emphasis
        embed.setDescription("Please be aware of the consequences for breaking the rules:");

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Warnings**",
                "• Breaking rules will result in warnings.\n" +
                        "• Accumulate three warnings, and you will be banned.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Immediate Bans**",
                "• Severe infractions can result in an immediate ban.\n" +
                        "• This includes hate speech or sharing explicit content.\n", false);

        embed.addField("<:5585pyrosigil:1242079070326489088>" + "**Appeals**",
                "• If you believe you were wrongly warned or banned, contact modmail to appeal.\n", false);

        OffsetDateTime now = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        embed.setFooter(" Last updated " + formattedDateTime);

        return embed;
    }

}
