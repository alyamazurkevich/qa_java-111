import com.example.Lion;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;


@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test(expected = Exception.class)
    public void checkManeExceptionTest() throws Exception {
        String sex = "Not-binary";
        Lion lion = new Lion(sex, feline);
        lion.doesHaveMane();
    }

    @Test
    public void checkKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void checkFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");

    }
}
