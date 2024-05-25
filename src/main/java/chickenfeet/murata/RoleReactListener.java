package chickenfeet.murata;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class RoleReactListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        if (event.getUser().isBot()) return;

        String emoteName = event.getReaction().getEmoji().getName();
        Member member = event.getMember();
        if (member == null) return;

        Role role = null;
        switch (emoteName) {
            case "🔥":
                role = event.getGuild().getRoleById("PYRO_ROLE_ID");
                break;
            case "💧":
                role = event.getGuild().getRoleById("HYDRO_ROLE_ID");
                break;
            case "🌱":
                role = event.getGuild().getRoleById("DENDRO_ROLE_ID");
                break;
            case "🌬️":
                role = event.getGuild().getRoleById("ANEMO_ROLE_ID");
                break;
            case "⚡":
                role = event.getGuild().getRoleById("ELECTRO_ROLE_ID");
                break;
            case "❄️":
                role = event.getGuild().getRoleById("CRYO_ROLE_ID");
                break;
            case "🪨":
                role = event.getGuild().getRoleById("GEO_ROLE_ID");
                break;
        }

        if (role != null) {
            event.getGuild().addRoleToMember(member, role).queue();
        }
    }
}
