package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.example.listeners.EventListeners;

import javax.security.auth.login.LoginException;
import java.util.EventListener;

public class Bot {
    private final Dotenv config;
    private final ShardManager shardManager;

    public Bot() throws LoginException{
        config= Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("Minecraft"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES,GatewayIntent.MESSAGE_CONTENT);
        shardManager=builder.build();

        //Listeners
        shardManager.addEventListener(new EventListeners());
    }
    public Dotenv getConfig(){
        return config;
    }
    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            Bot bot = new Bot();
        } catch (LoginException e) {
            System.out.println("ERROR: Provided bot token is invalid!");
        }
    }
}