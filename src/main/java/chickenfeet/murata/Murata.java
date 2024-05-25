package chickenfeet.murata;

import chickenfeet.murata.embeds.ReactRoleEmbed;
import chickenfeet.murata.embeds.RuleEmbed;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Murata {
    public static void main(String[] args) throws LoginException {
        JDA api = JDABuilder.createDefault(System.getenv("BOT_TOKEN")).build();
        api.addEventListener(new MurataListener());
        api.addEventListener(new RoleReactListener());


    }
}
