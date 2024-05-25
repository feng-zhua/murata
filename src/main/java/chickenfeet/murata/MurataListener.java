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

import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

public class MurataListener extends ListenerAdapter {

    private static final List<Emoji> REACTIONS = List.of(
            Emoji.fromUnicode("🔥"),
            Emoji.fromUnicode("💧"),
            Emoji.fromUnicode("🌱"),
            Emoji.fromUnicode("🌬️"),
            Emoji.fromUnicode("⚡"),
            Emoji.fromUnicode("❄️"),
            Emoji.fromUnicode("🪨")
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
            List<Entry<EmbedBuilder, List<Emoji>>> embedsWithReactions = List.of(
                    new SimpleEntry<>(ReactRoleEmbed.createPingRoleEmbed(), REACTIONS),
                    new SimpleEntry<>(ReactRoleEmbed.createPronounRoleEmbed(), REACTIONS),
                    new SimpleEntry<>(ReactRoleEmbed.createAgeRoleEmbed(), REACTIONS),
                    new SimpleEntry<>(ReactRoleEmbed.createVisionRoleEmbed(), REACTIONS),
                    new SimpleEntry<>(ReactRoleEmbed.createCoopRoleEmbed(), REACTIONS)
            );

            for (Entry<EmbedBuilder, List<Emoji>> entry : embedsWithReactions) {
                sendEmbedWithReactions(reactRoleChannel, entry.getKey(), entry.getValue());
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
