package codewars.morse;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MorseCodeDecoderTest {

  @Test
  public void testExampleFromDescription() {
    assertThat(MorseCodeDecoder.decode("."), is("E"));
    assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
  }

}
