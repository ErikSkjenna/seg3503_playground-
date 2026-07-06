import java.util.regex.Pattern;

public class Twitter {

  public String loadTweet()
  {
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {}

    double r = Math.random();

    if (r <= 0.45) {
      return "I am tweet that likes to talk about @me";
    } else if (r <= 0.9) {
      return "Hello to @you";
    } else {
      return null;
    }
  }

  public boolean isMentionned(String name) {
    String tweet = loadTweet();

    if (tweet == null || name == null || name.trim().isEmpty()) {
      return false;
    }

    String regex = "(?<![A-Za-z0-9_])@" + Pattern.quote(name.trim()) + "(?![A-Za-z0-9_])";

    return Pattern.compile(regex).matcher(tweet).find();
  }
}