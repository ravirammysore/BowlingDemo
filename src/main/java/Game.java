public class Game
{
    private int[] _rolls = new int[21];
    private int _currentRoll;

    private int SumOfBallsInFrame(int frameIndex)
    {
        return _rolls[frameIndex] + _rolls[frameIndex + 1];
    }

    private int SpareBonus(int frameIndex)
    {
        return _rolls[frameIndex + 2];
    }

    private int StrikeBonus(int frameIndex)
    {
        return _rolls[frameIndex + 1] + _rolls[frameIndex + 2];
    }

    private boolean IsSpareFrame(int frameIndex)
    {
        return _rolls[frameIndex] + _rolls[frameIndex + 1] == 10;
    }

    public void Roll(int pins)
    {
        _rolls[_currentRoll++] = pins;
    }

    public int Score()
    {
        int score = 0;
        int frameIndex = 0;

        for(int frame = 0; frame < 10; frame++)
        {
            if (_rolls[frameIndex] == 10)
            {
                score += 10 + StrikeBonus(frameIndex);
                frameIndex++;
            }
            else if (IsSpareFrame(frameIndex))
            {
                score += 10 + SpareBonus(frameIndex);
                frameIndex += 2;
            }
            else
            {
                score += SumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }
}