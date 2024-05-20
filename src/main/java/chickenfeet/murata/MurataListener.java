package chickenfeet.murata;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MurataListener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event){
        Guild server = event.getJDA().getGuildById(System.getenv("GUILD_TOKEN"));
        server.upsertCommand("sum", "Gives the sum of two numbers").queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.printf("[%s] %#s: %s\n",
                event.getChannel(),
                event.getAuthor(),
                event.getMessage().getContentDisplay());
    }
}
