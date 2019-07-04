package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderGameInformationTest {

  LadderGameInformation information;

  @BeforeEach
  public void setup() {
    Players players = new Players("lee,chang,jun");
    LadderResult ladderResult = new LadderResult("꽝,꽝,성공");
    int ladderHeight = 5;
    information = new LadderGameInformation(players, ladderHeight, ladderResult);
  }

  @Test
  public void 플레이어수를_구해온다() {
    assertThat(information.playersCount()).isEqualTo(3);
  }

  @Test
  public void 사다리높이를_구해온다() {
    assertThat(information.ladderHeight()).isEqualTo(5);
  }


  @Test
  public void 참여자수와_실행결과는_같아야한다() {
    Players players = new Players("lee,chang,jun");
    LadderResult ladderResult = new LadderResult("꽝,꽝");
    int ladderHeight = 5;

    assertThatThrownBy(() -> {
      LadderGameInformation information = new LadderGameInformation(players, ladderHeight,
          ladderResult);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("참여할 사람수와 실행결과 수는 같아야 합니다.");

  }

}
