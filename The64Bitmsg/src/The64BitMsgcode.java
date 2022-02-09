import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lavaplayer.PlayerManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.config.AuthorizationConfig;

public class The64BitMsgcode extends ListenerAdapter
{
	public String serverVc = "";
	public static AuthorizationConfig auc;
    public static void main(String[] args) throws LoginException
    {

        // args[0] should be the token
        // We only need 2 intents in this bot. We only respond to messages in guilds and private channels.
        // All other events will be disabled.
    	
    	String Dtoken = "OTIyMzYyNDg0MjQzOTgwMzI4.YcAXAA.I53PxnqkFTit6Ro64xlKCbRa1Hg";
    	auc = new AuthorizationConfig(Dtoken);
    	JDABuilder jdb = JDABuilder.createLight(Dtoken, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_VOICE_STATES);
    	jdb.addEventListeners(new The64BitMsgcode())
		.setActivity(Activity.watching("your messages"))
        .build();
    }

  
    	
    
    public void onMessageReceived(MessageReceivedEvent event)
    {

    	Message msg = event.getMessage();
        msgcommands.msg(event,msg);
    	
    	
    	
        //try {
		//	Commands.musiccommand("!join","General",event,msg,auc);
			
		//} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//	System.out.println("file problem");
		//} catch (InterruptedException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//	System.out.println("some other stuff");
		//}
        if ((msg.getContentRaw().equals("!closebot1232"))&&(event.getAuthor().getId().equals("514317770091921428")))
        {
        System.exit(1);
        }
        
        	 
        
    }
}