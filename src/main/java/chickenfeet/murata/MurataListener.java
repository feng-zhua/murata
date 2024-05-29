package chickenfeet.murata;

import chickenfeet.murata.embeds.ReactRoleEmbed;
import chickenfeet.murata.embeds.RuleEmbed;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class MurataListener extends ListenerAdapter {

    /**
     * CHECK THIS CHANGED LIST TO ARRAYS
     **/
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
                    "1245467132033241098", // One
                    "1245467130753847447"  // Two
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
                    "1245467132033241098", // One
                    "1245467130753847447", //Two
                    "1245467129021730919", // Three
                    "1245467127821898000"// Four
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


    /**
     * CHECK THIS CHANGED LIST TO ARRAYS
     **/
    private void sendRoleEmbeds(Guild server) {
        TextChannel reactRoleChannel = server.getChannelById(TextChannel.class, "1241889063422922833");
        if (reactRoleChannel != null) {
            /*reactRoleChannel.getHistory().retrievePast(1).queue(messages -> {
                if (messages.isEmpty()) {
                    List<Entry<EmbedBuilder, List<Emoji>>> embedsWithReactions = List.of(
                            new SimpleEntry<>(ReactRoleEmbed.createPingRoleEmbed(), REACTIONS),
                            new SimpleEntry<>(ReactRoleEmbed.createPronounRoleEmbed(), REACTIONS),
                            new SimpleEntry<>(ReactRoleEmbed.createAgeRoleEmbed(), REACTIONS),
                            new SimpleEntry<>(ReactRoleEmbed.createVisionRoleEmbed(), REACTIONS),
                            new SimpleEntry<>(ReactRoleEmbed.createCoopRoleEmbed(), REACTIONS),
                            new SimpleEntry<>(ReactRoleEmbed.createWLRoleEmbed(), REACTIONS)
                    );

                    for (Entry<EmbedBuilder, List<Emoji>> entry : embedsWithReactions) {
                        sendEmbedWithReactions(reactRoleChannel, entry.getKey(), entry.getValue());
                    }
                }
            });*/
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
    }

    private void sendEmbedWithReactions(TextChannel channel, EmbedBuilder embed, List<Emoji> reactions) {
        channel.sendMessageEmbeds(embed.build()).queue(message -> {
            for (Emoji reaction : reactions) {
                message.addReaction(reaction).queue();
            }
        });
    }


}
