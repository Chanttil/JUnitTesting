import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TestDemoTest {
    TestDemo testDemo;

    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("TestDemoTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
        if(!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        }else{
            assertThatThrownBy(() ->
                    testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
    static Stream<Object> argumentsForAddPositive() {

    return Stream.of(Arguments.of(1, 2, 3, false),
            Arguments.of(2, 4, 6, false),
            Arguments.of(8, -16, 24, true),
            Arguments.of(0, 10, 10, false),
            Arguments.of(3, 6, 9,false)
//           , Arguments.of(-10, 10, 7, false)
            );
    }

    @Test
    void assertThatNumberSquaredIsCorrect(){
        TestDemo mockDemo = spy(testDemo);

        doReturn(5).when(mockDemo).getRandomInt();

        int fiveSquared = mockDemo.randomNumberSquared();

        assertThat(fiveSquared).isEqualTo(25);


    }
}