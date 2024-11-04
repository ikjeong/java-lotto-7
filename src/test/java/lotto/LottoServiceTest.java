package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("당첨 테스트")
    @Test
    void 당첨_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            LottoRank.FIRST.toString()
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 번호 생성 개수 예외 테스트")
    @Test
    void 당첨_번호_생성_개수_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1,2,3,4,5,6,7");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 번호 생성 중복 예외 테스트")
    @Test
    void 당첨_번호_생성_중복_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1,1,2,3,4,5");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 번호 0보다 작은 수 예외 테스트")
    @Test
    void 당첨_번호_0보다_작은_수_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("0,1,2,3,4,5");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 번호 45보다 큰 수 예외 테스트")
    @Test
    void 당첨_번호_45보다_큰_수_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1,2,3,4,5,46");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("보너스 번호 생성 중복 예외 테스트")
    @Test
    void 보너스_번호_생성_중복_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1,2,3,4,5,6", "1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("보너스 번호 0보다 작은 수 예외 테스트")
    @Test
    void 보너스_번호_0보다_작은_수_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1,2,3,4,5,6", "0");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("보너스 번호 45보다 큰 수 예외 테스트")
    @Test
    void 보너스_번호_45보다_큰_수_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1,2,3,4,5,6", "46");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 번호 생성 예외 재입력 테스트")
    @Test
    void 당첨_번호_생성_예외_재입력_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1,2,3,4,5,6,7", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            LottoRank.FIRST.toString()
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("보너스 번호 생성 예외 재입력 테스트")
    @Test
    void 보너스_번호_생성_예외_재입력_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1,2,3,4,5,6", "1", "7");
                    assertThat(output()).contains(
                            LottoRank.FIRST.toString()
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}