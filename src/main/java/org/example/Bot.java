package org.example;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class Bot {

    private final ShardManager shardManager;

    public Bot() throws LoginException{

        String token="MTIxNTMwNzIzMzIxNTI1NDU3MA.GIUg6E.tBtVFs0lHACoIjNqjotiyohjsYqYQSQo-ALFps";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("Minecraft"));
        shardManager=builder.build();

    }
    public ShardManager getShardManager() { return shardManager; }

    public static void main(String[] args) {
        try {
            Bot bot = new Bot();
        } catch (LoginException e) {
            System.out.println("ERROR: Provided bot token is invalid!");
        }
    }
}