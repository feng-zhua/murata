package chickenfeet.murata;

import chickenfeet.murata.embeds.ReactRoleEmbed;
import chickenfeet.murata.embeds.RuleEmbed;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

public class MurataListener extends ListenerAdapter {

    // Define the role assignments here (emoji ID -> role ID)
    private static final Map<String, String> ROLE_ASSIGNMENTS = new HashMap<>();

    static {
        ROLE_ASSIGNMENTS.put("1242079125577924648", "1242803683830399006"); // Intertwinedfate -> Server Announcement
        ROLE_ASSIGNMENTS.put("1242079124013580311", "1242803725773570181"); // Acquaintfate -> Events
        ROLE_ASSIGNMENTS.put("1242079127117496381", "1242803767309504595"); // Genesiscrystal -> Giveaways
        ROLE_ASSIGNMENTS.put("1242079091902124043", "1242803812486610944"); // Primogem -> Primogems
        ROLE_ASSIGNMENTS.put("1242079194486280222", "1242803852034441298"); // Fragileresin -> Genshin Updates
        ROLE_ASSIGNMENTS.put("1245375886895743076", "1242803886276739080"); // Pyrocons -> Leaks
        ROLE_ASSIGNMENTS.put("1245467132033241098", "1242803330653229117"); // One -> she/her
        ROLE_ASSIGNMENTS.put("1245467130753847447", "1242803364954243103"); // Two -> he/him
        ROLE_ASSIGNMENTS.put("1245467129021730919", "1242803419895435264"); // Three -> they/them
        ROLE_ASSIGNMENTS.put("1245467127821898000", "1242803488925421649"); // Four -> ask pronouns
        ROLE_ASSIGNMENTS.put("1245467125968011294", "1242803531753197580"); // Five -> any pronouns
        ROLE_ASSIGNMENTS.put("1245467124672233542", "1242803573587312741"); // Six -> neo pronouns
        ROLE_ASSIGNMENTS.put("1242079164714975232", "1242803214164693034"); // Masterless Star -> -18
        ROLE_ASSIGNMENTS.put("1242079166338306079", "1242803273849765970"); // Masterless Dust -> +18
        ROLE_ASSIGNMENTS.put("1245461972045271111", "1242116649969258497"); // Electrosigil -> electro
        ROLE_ASSIGNMENTS.put("1245461970447237242", "1242802713222447125"); // Cryosigil -> cryo
        ROLE_ASSIGNMENTS.put("1245461974867775659", "1242116707506720809"); // Anemosigil -> anemo
        ROLE_ASSIGNMENTS.put("1245461973379055699", "1242116684899156083"); // Geosigil -> geo
        ROLE_ASSIGNMENTS.put("1245461976352690299", "1242116586740121630"); // Hydrosigil -> hydro
        ROLE_ASSIGNMENTS.put("1245461919020617778", "1242116627240059032"); // Dendrosigil -> dendro
        ROLE_ASSIGNMENTS.put("1242079070326489088", "1242116549892898889"); // Pyrosigil -> pyro
        ROLE_ASSIGNMENTS.put("1247121917232549900", "1242803961732268042"); // Precious Chest -> eu
        ROLE_ASSIGNMENTS.put("1247121915139592263", "1242803999779061871"); // Remarkable Chest -> na
        ROLE_ASSIGNMENTS.put("1247121913440895036", "1242804050530140211"); // Exquitsite Chest -> asia
        ROLE_ASSIGNMENTS.put("1247121909993439274", "1242804130284830780"); // Luxurious Chest -> tk
    }

    private static final List<SimpleEntry<EmbedBuilder, List<String>>> EMBEDS_WITH_EMOJIS = Arrays.asList(
            new SimpleEntry<>(ReactRoleEmbed.createPingRoleEmbed(), Arrays.asList(
                    "1242079125577924648", // Intertwinedfate
                    "1242079124013580311", // Acquaintfate
                    "1242079127117496381", // Genesiscrystal
                    "1242079091902124043", // Primogem
                    "1242079194486280222", // Fragileresin
                    "1245375886895743076"  // Pyrocons
            )),
            new SimpleEntry<>(ReactRoleEmbed.createPronounRoleEmbed(), Arrays.asList(
                    "1245467132033241098", // One
                    "1245467130753847447",  // Two
                    "1245467129021730919",  // Three
                    "1245467127821898000",  // Four
                    "1245467125968011294",  // Five
                    "1245467124672233542"  // Six
            )),
            new SimpleEntry<>(ReactRoleEmbed.createAgeRoleEmbed(), Arrays.asList(
                    "1242079164714975232", // Masterless Star
                    "1242079166338306079"  // Masterless Dust
            )),
            new SimpleEntry<>(ReactRoleEmbed.createVisionRoleEmbed(), Arrays.asList(
                    "1245461972045271111", // Electrosigil
                    "1245461970447237242", // Cryosigil
                    "1245461974867775659", // Anemosigil
                    "1245461973379055699", // Geosigil
                    "1245461976352690299", // Hydrosigil
                    "1245461919020617778", // Dendrosigil
                    "1242079070326489088"  // Pyrosigil
            )),
            new SimpleEntry<>(ReactRoleEmbed.createCoopRoleEmbed(), Arrays.asList(
                    "1247121917232549900", // Precious Chest
                    "1247121915139592263", //Remarkable Chest
                    "1247121913440895036", // Exquitsite Chest
                    "1247121909993439274"// Luxurious Chest
            ))
    );

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Guild server = event.getJDA().getGuildById(System.getenv("GUILD_TOKEN"));
        if (server != null) {
            sendRulesEmbed(server);
            sendRoleEmbeds(server);
        }
    }

    private void sendRulesEmbed(Guild server) {
        TextChannel rulesChannel = server.getChannelById(TextChannel.class, "1241877617376886875");
        if (rulesChannel != null) {
            boolean isEmpty = true;
            // Get an Iterable<Message> representing the channel's message history
            Iterable<Message> messageHistory = rulesChannel.getIterableHistory();
            // Check if the message history is empty
            for (Message ignored : messageHistory) {
                isEmpty = false;
                break; // Exit loop as soon as a message is found
            }
            // If the message history is empty, send the embeds
            if (isEmpty) {
                rulesChannel.sendMessageEmbeds(RuleEmbed.createRulesEmbed().build()).queue();
                rulesChannel.sendMessageEmbeds(RuleEmbed.createConsequencesEmbed().build()).queue();
            }
        }
    }

    private void sendRoleEmbeds(Guild server) {
        TextChannel reactRoleChannel = server.getChannelById(TextChannel.class, "1241959323324776448");
        if (reactRoleChannel != null) {
            reactRoleChannel.getHistory().retrievePast(1).queue(messages -> {
                if (messages.isEmpty()) {
                    reactRoleChannel.sendMessageEmbeds(ReactRoleEmbed.createRoleEmbed().build()).queue();
                    for (SimpleEntry<EmbedBuilder, List<String>> embedWithEmojis : EMBEDS_WITH_EMOJIS) {
                        EmbedBuilder embed = embedWithEmojis.getKey();
                        List<Emoji> reactions = new ArrayList<>();
                        for (String id : embedWithEmojis.getValue()) {
                            Emoji emote = server.getEmojiById(id);
                            if (emote != null) {
                                reactions.add(emote);
                            }
                        }
                        sendEmbedWithReactions(reactRoleChannel, embed, reactions);
                    }
                }
            });
        }
    }

    private void sendEmbedWithReactions(TextChannel channel, EmbedBuilder embed, List<Emoji> reactions) {
        channel.sendMessageEmbeds(embed.build()).queue(message -> {
            for (Emoji reaction : reactions) {
                message.addReaction(reaction).queue();
            }
        });
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        if (event.getUser().isBot()) return;

        Guild guild = event.getGuild();
        Member member = event.getMember();
        EmojiUnion emoji = event.getEmoji();

        String emojiId = null;

        if (emoji.getType() == EmojiUnion.Type.CUSTOM) {
            emojiId = emoji.asCustom().getId();
        } else if (emoji.getType() == EmojiUnion.Type.UNICODE) {
            // Handle unicode emojis if needed
            emojiId = emoji.asUnicode().getName();
        }

        if (emojiId != null && ROLE_ASSIGNMENTS.containsKey(emojiId)) {
            String roleId = ROLE_ASSIGNMENTS.get(emojiId);
            Role role = guild.getRoleById(roleId);
            if (role != null && member != null) {
                guild.addRoleToMember(member, role).queue();
            }
        }
    }

    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        if (event.getUser().isBot()) return;

        Guild guild = event.getGuild();
        Member member = guild.getMember(event.getUser());
        EmojiUnion emoji = event.getEmoji();

        String emojiId = null;

        if (emoji.getType() == EmojiUnion.Type.CUSTOM) {
            emojiId = emoji.asCustom().getId();
        } else if (emoji.getType() == EmojiUnion.Type.UNICODE) {
            // Handle unicode emojis if needed
            emojiId = emoji.asUnicode().getName();
        }

        if (emojiId != null && ROLE_ASSIGNMENTS.containsKey(emojiId)) {
            String roleId = ROLE_ASSIGNMENTS.get(emojiId);
            Role role = guild.getRoleById(roleId);
            if (role != null && member != null && member.getRoles().contains(role)) {
                guild.modifyMemberRoles(member, Collections.emptyList(), Collections.singletonList(role)).queue();
            }
        }
    }


}
