package com.example;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProgressService {

    private List<Progress> progressList = new ArrayList<>();

    public Progress saveProgress(Progress p) {
        progressList.add(p);
        return p;
    }

    public List<Progress> getAll() {
        return progressList;
    }
}