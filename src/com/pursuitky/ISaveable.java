package com.pursuitky;

import java.util.ArrayList;

public interface ISaveable {
    ArrayList<String> save();
    void load(ArrayList<String> data);
}
