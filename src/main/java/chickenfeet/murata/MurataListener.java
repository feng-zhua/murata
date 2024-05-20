package chickenfeet.murata;

import chickenfeet.murata.embeds.RuleEmbed;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MurataListener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Guild server = event.getJDA().getGuildById(System.getenv("GUILD_TOKEN"));
        if (server != null) {
            sendRulesEmbed(server);
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


}
