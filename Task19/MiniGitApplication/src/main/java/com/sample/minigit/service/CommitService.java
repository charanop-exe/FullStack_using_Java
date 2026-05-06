package com.sample.minigit.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.sample.minigit.model.Commit;

@Service
public class CommitService {

    private List<Commit> commits = new ArrayList<>();
    private int version = 1;

    public void save(Map<String, String> data) {
        Commit commit = new Commit(
                version++,
                data.get("message"),
                data.get("content")
        );
        commits.add(commit);
    }

    public List<Commit> getAll() {
        return commits;
    }
    
    public void clear() {
        commits.clear();
        version=1;
    }
}