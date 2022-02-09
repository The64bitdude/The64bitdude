import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;

import lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.DirectAudioController;
import net.dv8tion.jda.internal.utils.config.AuthorizationConfig;

public class Commands{
	
	private static AudioLoadResultHandler AudioLoadResultHandler;
	public static void command(String in,String out,MessageReceivedEvent event, Message message) {
		if (message.getContentRaw().equals(in))
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            //say stuff
            channel.sendMessage(out) /* => RestAction<Message> */
                   .queue(response /* => Message */ -> {
                       response.editMessageFormat(out + ": %d ms", System.currentTimeMillis() - time).queue();
                   });
        }
	}
	public static void cencor(String in,String out,String out2,MessageReceivedEvent event, Message msg) {
		if ((msg.getContentRaw().toLowerCase().indexOf(in)) != -1)
        {
			
            MessageChannel channel = event.getChannel();
            User author = event.getAuthor();
            String name = author.getId();
            long time = System.currentTimeMillis();
            //say stuff
            channel.sendMessage(out) /* => RestAction<Message> */
                   .queue(response /* => Message */ -> {
                       response.editMessageFormat(out +"<@"+ name+">" + out2 + ": %d ms", System.currentTimeMillis() - time).queue();
                   });
           while((System.currentTimeMillis() - time) < 250) {
            }
           channel.purgeMessages(msg);
        }
	}
	public static String trackurl = "https://www.youtube.com/watch?v=wNngSvSnX6U";
	public static void musiccommand(String in,String cName,MessageReceivedEvent event, Message msg,AuthorizationConfig auc) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		if((msg.getContentRaw().indexOf(in)) != -1) {
			cName = msg.getContentRaw().substring(msg.getContentRaw().indexOf(in) + in.length()+1);
			System.out.println(cName);
			List<VoiceChannel> listChannel = event.getJDA().getVoiceChannels();
			Object[] channels = listChannel.toArray();
			VoiceChannel channel = null;
			for(int i = 0; i < listChannel.size();i++) {
				if(listChannel.get(i).getName().equals(cName)) {
				channel = listChannel.get(i);
				}
			}
			trackurl = "https://www.youtube.com/watch?v=bvWRMAU6V-c";
			DirectAudioController control = event.getJDA().getDirectAudioController();
			control.connect(channel);
			PlayerManager Playm = new PlayerManager();
			PlayerManager.loadAndPlay(event.getTextChannel(),trackurl);
			
			
			
		}
		
		
	}
	
}