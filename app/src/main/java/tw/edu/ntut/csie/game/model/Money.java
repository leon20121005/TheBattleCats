package tw.edu.ntut.csie.game.model;

import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Integer;
import tw.edu.ntut.csie.game.R;

/**
 * Created by User on 2017/4/2.
 */

public class Money
{
    public static int INITIAL_MAX_MONEY = 1000;
    public static int SPEED = 10;
    public static int MONEY_MAX_ADD_SCALE = 100;
    private MovingBitmap _coin;
    private MovingBitmap _slash;
    private Integer _currentInteger;
    private Integer _maxInteger;
    private int _currentMoney;
    private int _maxMoney;

    public Money()
    {
        _coin = new MovingBitmap(R.drawable.coin, 420, 8);
        _slash = new MovingBitmap(R.drawable.slash, 534, 10);
        _currentInteger = new Integer(4, _currentMoney, 450, 10);
        _maxInteger = new Integer(4, _maxMoney, 550, 10);
        _currentMoney = 0;
        _maxMoney = INITIAL_MAX_MONEY;
    }

    //產兵扣錢
    public void SubtractMoney(int cost)
    {
        _currentMoney -= cost;
    }

    //增加錢的最大值
    public void AddMoneyMax()
    {
        if (_currentMoney > 200)
        {
            _maxMoney += MONEY_MAX_ADD_SCALE;
            _currentMoney -= 200;
        }
    }

    //產錢
    public void AddMoney()
    {
        if (_currentMoney < _maxMoney)
        {
            _currentMoney += SPEED;
        }
    }

    public int GetCurrentMoney()
    {
        return _currentMoney;
    }

    public void show()
    {
        _currentInteger.setValue(_currentMoney);
        _maxInteger.setValue(_maxMoney);
        _currentInteger.show();
        _maxInteger.show();
        _coin.show();
        _slash.show();
    }
}