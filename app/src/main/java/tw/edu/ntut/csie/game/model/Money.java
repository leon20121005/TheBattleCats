package tw.edu.ntut.csie.game.model;

import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Integer;
import tw.edu.ntut.csie.game.R;

/**
 * Created by User on 2017/4/2.
 */

public class Money
{
    public static final int ADD_MONEY_COST = 200;
    private final int MONEY_MAX_ADD_SCALE;
    private final int SPEED;

    private MovingBitmap _coin;
    private MovingBitmap _slash;
    private Integer _currentInteger;
    private Integer _maxInteger;
    private int _currentMoney;
    private int _maxMoney;

    public Money(RecordModel recordModel, int x, int y)
    {
        MONEY_MAX_ADD_SCALE = recordModel.GetMoneyMaxAddScale();
        SPEED = recordModel.GetMoneyAddSpeed();

        _coin = new MovingBitmap(R.drawable.coin, x, y);
        _slash = new MovingBitmap(R.drawable.slash, x + 109, y + 4);
        _currentInteger = new Integer(4, _currentMoney, x + 25, y + 4);
        _maxInteger = new Integer(4, _maxMoney, x + 125, y + 4);
        _currentMoney = 0;
        _maxMoney = recordModel.GetInitialMaxMoney();
    }

    //產兵扣錢
    public void SubtractMoney(int cost)
    {
        _currentMoney -= cost;
    }

    //增加錢的最大值
    public void AddMoneyMax()
    {
        if (_currentMoney >= ADD_MONEY_COST)
        {
            _maxMoney += MONEY_MAX_ADD_SCALE;
            _currentMoney -= ADD_MONEY_COST;
        }
    }

    //產錢
    public void AddMoney()
    {
        if (_currentMoney < _maxMoney)
        {
            _currentMoney += SPEED;
        }
        if (_currentMoney > _maxMoney)
        {
            _currentMoney = _maxMoney;
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