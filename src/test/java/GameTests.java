import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests
{
    private Game _game;

    @BeforeEach
    public void SetUp()
    {
        _game = new Game();
    }

    private void RollMany(int n, int pins)
    {
        for(int i = 0; i<n; i++)
            _game.Roll(pins);
    }

    private void RollSpare()
    {
        _game.Roll(5);
        _game.Roll(5);
    }

    @Test
    public void test_gutter()
    {
        int n = 20;
        int pins = 0;
        RollMany(n, pins);

        assertEquals(0, _game.Score());
    }

    @Test
    public void Rolling_All_ones()
    {
        RollMany(20,1);
        assertEquals(20, _game.Score());
    }

    @Test
    public void One_spare()
    {
        RollSpare();
        _game.Roll(3);

        RollMany(17,0);

        assertEquals(16,_game.Score());
    }

    private void RollStrike()
    {
        _game.Roll(10);
    }

    @Test
    public void One_strike()
    {
        RollStrike();

        _game.Roll(3);
        _game.Roll(4);

        RollMany(16,0);

        assertEquals(24,  _game.Score());
    }

    @Test
    public void TestPerfectGame()
    {
        RollMany( 12,10);
        assertEquals(300, _game.Score());
    }
}
