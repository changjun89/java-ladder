package ladder;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Players {

  public static final String PLAYERS_NAME_DELIMITER = ",";
  public static final int MINIMUM_PLAYERS_COUNT = 2;
  List<Player> players;

  public Players(String playersName) {
    if (isBlank(playersName)) {
      throw new IllegalArgumentException("players 이름을 입력하세요");
    }
    players = initPlayers(playersName);

  }

  private boolean isBlank(String playersName) {
    return playersName == null || "".equals(playersName.trim());
  }

  private List<Player> initPlayers(String playersName) {
    String[] splitNames = splitPlayersName(playersName);
    checkPlayersCount(splitNames);
    return Arrays.stream(splitNames)
        .map(Player::new)
        .collect(toList());
  }

  private String[] splitPlayersName(String playersName) {
    return playersName.split(PLAYERS_NAME_DELIMITER);
  }

  private void checkPlayersCount(String[] splitNames) {
    if (splitNames.length < MINIMUM_PLAYERS_COUNT) {
      throw new IllegalArgumentException("player 는 최소 2명입니다.");
    }
  }

  public int count() {
    return players.size();
  }

  @Override
  public String toString() {
    StringBuffer playersName = new StringBuffer();
    for (Player player : players) {
      playersName.append(player.toString());
    }
    return playersName.toString();
  }
}
