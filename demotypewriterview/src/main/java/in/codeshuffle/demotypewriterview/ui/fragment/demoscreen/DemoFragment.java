package in.codeshuffle.demotypewriterview.ui.fragment.demoscreen;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import in.codeshuffle.demotypewriterview.databinding.FragmentDemoBinding;

public class DemoFragment extends DialogFragment {

    private static final String TAG = DemoFragment.class.getSimpleName();

    private Context context;

    private FragmentDemoBinding binding;

    public static DemoFragment getInstance() {
        Bundle bundle = new Bundle();
        DemoFragment demoFragment = new DemoFragment();
        demoFragment.setArguments(bundle);
        return demoFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDemoBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
