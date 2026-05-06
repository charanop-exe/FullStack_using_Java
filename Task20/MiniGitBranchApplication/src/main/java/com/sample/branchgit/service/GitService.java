package com.sample.branchgit.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GitService {

    private List<String> branches = new ArrayList<>(List.of("main"));
    private String current = "main";

    private Map<String, List<String>> commits = new HashMap<>();

    public GitService() {
        commits.put("main", new ArrayList<>());
    }

    // CREATE BRANCH
    public void createBranch(String name) {
        branches.add(name);
        commits.put(name, new ArrayList<>(commits.get(current)));
        current = name;
    }

    // COMMIT
    public void commit(String message) {
        commits.get(current).add(message);
    }

    // MERGE
    public String merge() {
        List<String> mainCommits = commits.get("main");
        List<String> featureCommits = commits.get(current);

        if (!mainCommits.isEmpty() && !featureCommits.isEmpty() && !current.equals("main")) {
            return "Merge Conflict Detected!";
        }

        mainCommits.addAll(featureCommits);
        current = "main";
        return "Merged Successfully";
    }

    // REBASE
    public void rebase() {
        List<String> mainCommits = commits.get("main");
        List<String> currentCommits = commits.get(current);

        List<String> rebased = new ArrayList<>(mainCommits);
        rebased.addAll(currentCommits);

        commits.put(current, rebased);
    }

    // GET DATA
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put("branches", branches);
        data.put("history", commits.get(current));
        return data;
    }
}