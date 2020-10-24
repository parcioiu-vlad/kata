package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TopWordsTest {

  @Test
  public void sampleTests() {
    assertEquals(Arrays.asList("e", "d", "a"),    TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
    assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
    assertEquals(Arrays.asList("won't", "wont"),  TopWords.top3("  //wont won't won't "));
    assertEquals(Arrays.asList("e"),              TopWords.top3("  , e   .. "));
    assertEquals(Arrays.asList(),                 TopWords.top3("  ...  "));
    assertEquals(Arrays.asList(),                 TopWords.top3("  '  "));
    assertEquals(Arrays.asList(),                 TopWords.top3("  '''  "));
    assertEquals(Arrays.asList("a", "of", "on"),  TopWords.top3(Stream
        .of("In a village of La Mancha, the name of which I have no desire to call to",
            "mind, there lived not long since one of those gentlemen that keep a lance",
            "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
            "coursing. An olla of rather more beef than mutton, a salad on most",
            "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
            "on Sundays, made away with three-quarters of his income.")
        .collect(Collectors.joining("\n")) ));

      assertEquals(Arrays.asList("jfi", "mv'helnbek", "lzvliwih"), TopWords.top3("JFi dIZX LzvlIwIH Oho-dIZX!yGXzRJL'Tf MV'hElNbek MV'hElNbek?LzvlIwIH NWAxC;tYUJvMF yGXzRJL'Tf QiZhKRwOFb!MV'hElNbek MV'hElNbek_MV'hElNbek JFi LzvlIwIH JFi JFi_JFi-NWAxC/RGzNgip RGzNgip ydotwTq:dIZX_JFi-ydotwTq?LzvlIwIH JFi yGXzRJL'Tf MV'hElNbek.Oho!LzvlIwIH LzvlIwIH-LzvlIwIH QiZhKRwOFb!LzvlIwIH JFi_MV'hElNbek LzvlIwIH;JFi LzvlIwIH,Oho;dIZX LzvlIwIH RGzNgip,MV'hElNbek LzvlIwIH QiZhKRwOFb.NWAxC-JFi dIZX MV'hElNbek MV'hElNbek MV'hElNbek-RGzNgip JFi LzvlIwIH?MV'hElNbek?NWAxC Oho JFi mYYGbqYh/MV'hElNbek RGzNgip Oho/Oho-MV'hElNbek/Oho dIZX.dIZX JFi/QiZhKRwOFb;MV'hElNbek/MV'hElNbek yGXzRJL'Tf/QiZhKRwOFb-NWAxC.JFi RGzNgip NWAxC tYUJvMF QiZhKRwOFb NWAxC.QiZhKRwOFb Oho MV'hElNbek;dIZX!NWAxC NWAxC Oho dIZX/RGzNgip:Oho?MV'hElNbek/NWAxC;LzvlIwIH-tYUJvMF:tYUJvMF_RGzNgip LzvlIwIH tYUJvMF LzvlIwIH Oho JFi JFi NWAxC NWAxC.RGzNgip.Oho ydotwTq NWAxC_LzvlIwIH!MV'hElNbek;MV'hElNbek,yGXzRJL'Tf.dIZX?Oho JFi?NWAxC JFi,LzvlIwIH QiZhKRwOFb?ydotwTq QiZhKRwOFb;yGXzRJL'Tf.QiZhKRwOFb NWAxC MV'hElNbek;RGzNgip tYUJvMF NWAxC:tYUJvMF.LzvlIwIH NWAxC!ydotwTq_yGXzRJL'Tf tYUJvMF JFi LzvlIwIH MV'hElNbek,JFi-tYUJvMF MV'hElNbek?NWAxC?yGXzRJL'Tf.JFi MV'hElNbek yGXzRJL'Tf/RGzNgip-JFi JFi/tYUJvMF:MV'hElNbek_dIZX Oho JFi tYUJvMF,RGzNgip MV'hElNbek tYUJvMF ydotwTq QiZhKRwOFb.LzvlIwIH_JFi RGzNgip dIZX_dIZX!NWAxC RGzNgip ydotwTq LzvlIwIH LzvlIwIH yGXzRJL'Tf.NWAxC_QiZhKRwOFb MV'hElNbek mYYGbqYh JFi LzvlIwIH.Oho NWAxC NWAxC_MV'hElNbek ydotwTq dIZX JFi.JFi:mYYGbqYh tYUJvMF LzvlIwIH NWAxC LzvlIwIH tYUJvMF;LzvlIwIH_dIZX JFi Oho,NWAxC.MV'hElNbek,Oho,JFi/RGzNgip"));
  }

}
