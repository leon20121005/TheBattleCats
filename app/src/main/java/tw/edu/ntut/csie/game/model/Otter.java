package tw.edu.ntut.csie.game.model;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by User on 2017/3/15.
 */

public class Otter extends Units
{
    public Otter (int x, int y)
    {
        _health = 100;
        _currentHeath = 100;
        _attackDamage = 10;
        _moveSpeed = 10;
        _attackSpeed = 1;
        _appearance = new MovingBitmap(R.drawable.test_capoo, x, y);
    }

    public void Moving()
    {

    }

    public void Attack()
    {

    }

    public void Attacked(int damage)
    {
        if (_currentHeath - damage <= 0)
        {
            KnockedBack();
            Died();
        }
        else if (_currentHeath > _health / 2 && _health / 2 > _currentHeath - damage)
        {
            KnockedBack();
            _currentHeath -= damage;
        }
    }

    protected void KnockedBack()
    {

    }

    protected void Died()
    {

    }

    public void Show()
    {
        _appearance.show();
    }
}
