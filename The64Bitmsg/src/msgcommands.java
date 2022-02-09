import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.*;

public class msgcommands {
	public static void msg(MessageReceivedEvent event, Message msg) {
		System.out.println(event.getAuthor().getName() +" : " + msg.getContentRaw());
		System.out.println(msg.getChannel().toString());
		System.out.println(msg.getGuild().toString());
		String out = "";
			Scanner in = new Scanner(System.in);
			MessageChannel channel = event.getChannel();
		       out = in.nextLine();
		        channel.sendMessage(out).queue();
		
            
	}
	
}
