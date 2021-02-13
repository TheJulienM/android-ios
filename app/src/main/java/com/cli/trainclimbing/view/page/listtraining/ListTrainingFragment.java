package com.cli.trainclimbing.view.page.listtraining;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cli.trainclimbing.R;
import com.cli.trainclimbing.controller.Controller;
import com.cli.trainclimbing.model.Level;
import com.cli.trainclimbing.model.Training;
import com.cli.trainclimbing.model.TrainingTest;
import com.cli.trainclimbing.view.itemtraining.ListTrainingAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListTrainingFragment extends Fragment {

    private ListView lvList;
    private Controller controller;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       View root = inflater.inflate(R.layout.fragment_list_training, container, false);

       controller = Controller.getInstance(root.getContext());

        Button button = root.findViewById(R.id.lt_Button_sendtraing);

        button.setOnClickListener((v) -> testBDD());

       List<TrainingTest> trainingList = generateTraining();
       ListTrainingAdapter adapter = new ListTrainingAdapter(root.getContext(), trainingList);
       this.lvList = (ListView) root.findViewById(R.id.lt_ListView_training);
       this.lvList.setAdapter(adapter);
        return root;
    }

    public void testBDD() {
        System.out.println("COUCOU");

        int lastId = this.controller.getLastIdTraining();

        ArrayList<Level> listLevel = new ArrayList<>();
        listLevel.add(new Level("EASY", 2));
        listLevel.add(new Level("MEDIUM", 1));

        Date date = new Date();

        Training training = new Training(lastId+ 1, date, 5, listLevel);

        this.controller.AddTraining(training);
    }

    private List<TrainingTest> generateTraining() {
        List<TrainingTest> trainingList = new ArrayList<TrainingTest>();
        trainingList.add(new TrainingTest("Date : 21/09/2000", "2h00"));
        trainingList.add(new TrainingTest("Date : 21/09/2000", "2h00"));
        trainingList.add(new TrainingTest("Date : 21/09/2000", "2h00"));
        trainingList.add(new TrainingTest("Date : 21/09/2000", "2h00"));
        trainingList.add(new TrainingTest("Date : 21/09/2000", "2h00"));
        trainingList.add(new TrainingTest("Date : 21/09/2000", "2h00"));

        return trainingList;

    }
}