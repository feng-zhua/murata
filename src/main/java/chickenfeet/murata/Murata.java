package chickenfeet.murata;

import chickenfeet.murata.commands.Sum;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Murata {
    public static void main(String[] args) throws InterruptedException {
        JDA api = JDABuilder.createDefault(System.getenv("BOT_TOKEN"))
                .addEventListeners(new MurataListener())
                .addEventListeners(new Sum())
                .build().awaitReady();
    }
}