package com.example.student.lab0302;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//繼承View.OnClickListener介面，讓button按下時可以執行所有onclick方法
//由fragment去override這個onclick方法
public class CountFragment extends Fragment implements View.OnClickListener {
    private TextView teamName;
    private TextView score;
    //因為現在button要在fragment中直接使用，所以要先宣告
    private Button add3p, add2p, add1p;
    private ImageView teamLogo;

    public CountFragment() { //fragment無參數建構子
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_count, container, false);

    }

    public void onStart() {
        super.onStart();
        teamName = (TextView) getView().findViewById(R.id.teamName);
        teamLogo = (ImageView) getView().findViewById(R.id.teamLogo);
        score = (TextView) getView().findViewById(R.id.score);
        add3p = (Button) getView().findViewById(R.id.add3p);
        add2p = (Button) getView().findViewById(R.id.add2p);
        add1p = (Button) getView().findViewById(R.id.add1p);
        //要設定onClickListener監聽，監聽的對象是就是自己(this)
        add3p.setOnClickListener(this);
        add2p.setOnClickListener(this);
        add1p.setOnClickListener(this);
    }

    public void reset() {
        score.setText("0");
    }

    //public final class String
    //extends Object implements Serializable, Comparable<String>, CharSequence
    //因為CharSequence是個interface，有很多class有implement它：String /StringBuilder/...
    public void setName(CharSequence name) {
        teamName.setText(name);
    }

    public void setTeamLogo(int id) {
        //因為小螢幕中不會有teamLogo，所以小螢幕再找teamlogo id時會找不到而傳一個空值給teamlogo
        if (teamLogo != null) {
            //Sets a drawable as the content of this ImageView.
            teamLogo.setImageResource(id);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int scoreCount = Integer.parseInt(score.getText().toString());
        switch (id) {
            //因為add3p是button類別，但id是int，不能直接寫，所以要寫完整的R.id.add3p
            case R.id.add3p:
                score.setText(String.valueOf(scoreCount + 3));
                break;
            case R.id.add2p:
                score.setText(String.valueOf(scoreCount + 2));
                break;
            case R.id.add1p:
                score.setText(String.valueOf(scoreCount + 1));
                break;

        }
    }
}
