import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lavaplayer.PlayerManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.config.AuthorizationConfig;

public class The64BitSpycode extends ListenerAdapter
{
	public String serverVc = "";
	public static AuthorizationConfig auc;
    public static void main(String[] args) throws LoginException
    {

        // args[0] should be the token
        // We only need 2 intents in this bot. We only respond to messages in guilds and private channels.
        // All other events will be disabled.
    	
    	String Dtoken = "your token";
    	auc = new AuthorizationConfig(Dtoken);
        JDABuilder.createLight(Dtoken, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_VOICE_STATES)
            .addEventListeners(new The64BitSpycode())
            .setActivity(Activity.watching("... always watching"))
            .build();
    }
	
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
    	
        Message msg = event.getMessage();
        Commands.command("!test","it works!",event,msg);
        Commands.command("!ping","Pong!",event,msg);
        Commands.command("!omea","was bist du spreaken auf!",event,msg);
        Commands.command("!it-just-works","it really does!",event,msg);
        Commands.cencor("heck","dont say that"," it makes me angry",event,msg);
        Commands.cencor("shit",":( "," did you just say what i think you just said?",event,msg);
        Commands.cencor("fuck","im dissapointed "," you have failed me",event,msg);
        Commands.cencor("cum","eww your gross "," you have to just stop its not funny",event,msg);
        Commands.cencor("bitch","no you "," need to watch your prifanity",event,msg);
        Commands.cencor("horney","shhh, "," they dont need to know ;)",event,msg);
        Commands.cencor("loser","sorry, but that is the incorrect terminology, "," they are FAILURES not that sorry",event,msg);
        Commands.cencor("bad word","nice try, "," but thats not going to cut it",event,msg);
        Commands.cencor("roblox","we do not that here, "," ok",event,msg);
        Commands.cencor("nut","if you were talking about the ones that are food, "," You know what you did",event,msg);
        try {
			Commands.musiccommand("!join","General",event,msg,auc);
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		
	e.printStackTrace();
	System.out.println("file problem");
		} catch (InterruptedException e) {
			
	e.printStackTrace();
			System.out.println("some other stuff");
		}
        if ((msg.getContentRaw().equals("!closebot1232"))&&(event.getAuthor().getId().equals("514317770091921428")))
        {
        System.exit(1);
        }
        
        	 
        
    }
}
