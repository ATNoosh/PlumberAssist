package ir.atnoosh.plumberassist.database.viewmodels;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import ir.atnoosh.plumberassist.database.models.DesiredSize;
import ir.atnoosh.plumberassist.database.models.Problem;
import ir.atnoosh.plumberassist.database.repositories.DesiredSizeRepository;
import ir.atnoosh.plumberassist.database.repositories.ProblemRepository;

public class DesiredSizeViewModel extends AndroidViewModel {

    private final DesiredSizeRepository desiredSizeRepository;



    public DesiredSizeViewModel(@NonNull @NotNull Application application) {
        super(application);
        desiredSizeRepository = new DesiredSizeRepository(application);
        //allDesiredSize = desiredSizeRepository.getAllDesiredSizes();
    }

}