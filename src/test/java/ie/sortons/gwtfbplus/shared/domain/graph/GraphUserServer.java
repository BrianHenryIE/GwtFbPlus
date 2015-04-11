package ie.sortons.gwtfbplus.shared.domain.graph;


import ie.sortons.gwtfbplus.shared.domain.fql.FqlEvent.FqlEventDatesAdapter;

import java.util.Date;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GraphUserServer {


	String s="{\"id\":\"37302520\",\"name\":\"Brian Henry\",\"first_name\":\"Brian\",\"last_name\":\"Henry\",\"link\":\"https:\\/\\/www.facebook.com\\/BrianHenryIE\",\"hometown\":{\"id\":\"102180916490258\",\"name\":\"Wicklow, Ireland\"},\"location\":{\"id\":\"110769888951990\",\"name\":\"Dublin, Ireland\"},\"bio\":\"My blood type is B Positive. I know this because I\'m a blood donor.\\n\\nBe positive.\",\"quotes\":\"\\\"I already see myself as happy, wealthy, and successful. It\'s just time my bank account matched.\\\" - Some OKCupid test.\\n\\n\\\"I have a heart problem: I love too much.\\\"\\n\\n\\\"The police often question him, just because they find him interesting.\\\" - Dos Equis ad: The Most Interesting Man in the World\\n\\n\\\"All I wanted was to make the world a better place, and then make an ass-load of money.\\\" - Sealab 2021 (s02e02 - Stimutacs)\\n\\n\\\"It\'s nice to be important but it\'s more important to be nice.\\\" - Scooter (Move Your Ass!)\\n\\n\\\"If you never did, you should, these things are fun and fun is good.\\\" - Dr. Seuss (One Fish Two Fish Red Fish Blue Fish)\\n\\n\\\"I\'m really good at mountain climbing, guitar solos, and lying.\\\" - College Humor (Jeff Rubin)\\n\\n\\\"It could be the beginning of a second industrial revolution.\\\" - RTE News in the 60s talking about microchips.\\n\\n\\\"What\'s that? Pretty good? Well, how\'d you like to feel really good?\\\" - Sealab 2021 (s02e02 - Stimutacs)\\n\\n\\\"I didn\'t sell out, son. I bought in.\\\" - SLC Punk!\\n\\n\\\"We\'re about to get taken to a dream-world of magic.\\\" - Lonely Island (Lazy Sunday)\",\"education\":[{\"school\":{\"id\":\"160601354073245\",\"name\":\"St. David\'s Secondary School\"},\"year\":{\"id\":\"132393000129123\",\"name\":\"2001\"},\"type\":\"High School\"},{\"school\":{\"id\":\"106180519420701\",\"name\":\"UCD Ireland\"},\"type\":\"College\"},{\"school\":{\"id\":\"105624339506254\",\"name\":\"ESIGELEC\"},\"year\":{\"id\":\"138383069535219\",\"name\":\"2005\"},\"concentration\":[{\"id\":\"113222888772378\",\"name\":\"Erasmus, Ing\\u00e9nierie de l\'information et de la communication\"}],\"type\":\"College\"},{\"school\":{\"id\":\"155235547878911\",\"name\":\"DCU\"},\"year\":{\"id\":\"137616982934053\",\"name\":\"2006\"},\"concentration\":[{\"id\":\"189349614431644\",\"name\":\"Electronic Systems\"},{\"id\":\"110262255662482\",\"name\":\"French\"}],\"type\":\"College\"},{\"school\":{\"id\":\"113469455330274\",\"name\":\"University College Dublin\"},\"degree\":{\"id\":\"183699268331819\",\"name\":\"MSc Computer Science\"},\"year\":{\"id\":\"143641425651920\",\"name\":\"2014\"},\"type\":\"Graduate School\"},{\"school\":{\"id\":\"104051856299176\",\"name\":\"Trinity College, Dublin\"},\"degree\":{\"id\":\"109903862418964\",\"name\":\"Master of Science\"},\"year\":{\"id\":\"141778012509913\",\"name\":\"2008\"},\"concentration\":[{\"id\":\"111577762251481\",\"name\":\"Technology and Learning\"}],\"type\":\"Graduate School\"}],\"gender\":\"male\",\"religion\":\"Science\",\"political\":\"nama\",\"timezone\":0,\"locale\":\"en_GB\",\"languages\":[{\"id\":\"106059522759137\",\"name\":\"English\"},{\"id\":\"110393388983547\",\"name\":\"Gaeilge\"},{\"id\":\"112264595467201\",\"name\":\"Fran\\u00e7ais\"},{\"id\":\"108224912538348\",\"name\":\"French\"},{\"id\":\"108106272550772\",\"name\":\"French\"}],\"verified\":true,\"updated_time\":\"2014-02-08T15:57:18+0000\",\"username\":\"BrianHenryIE\"}\n";

	
	
	private Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new FqlEventDatesAdapter()).create();
	
	@Test
	public void test() {
	

		GraphUser g = gson.fromJson(s, GraphUser.class);
		
		System.out.println(g.getUpdatedTime());
		
	}

}
