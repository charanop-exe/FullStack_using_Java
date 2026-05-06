package com.sample.branchgit.controller;

import com.sample.branchgit.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GitController {

    @Autowired
    private GitService service;

    // CREATE BRANCH
    @PostMapping("/branch")
    public Map<String, String> createBranch(@RequestBody Map<String, String> data) {
        service.createBranch(data.get("name"));
        return Map.of("msg", "Branch created");
    }

    // COMMIT
    @PostMapping("/commit")
    public Map<String, String> commit(@RequestBody Map<String, String> data) {
        service.commit(data.get("message"));
        return Map.of("msg", "Committed");
    }

    // MERGE
    @PostMapping("/merge")
    public Map<String, String> merge() {
        String result = service.merge();
        return Map.of("msg", result);
    }

    // REBASE
    @PostMapping("/rebase")
    public Map<String, String> rebase() {
        service.rebase();
        return Map.of("msg", "Rebased");
    }

    // GET DATA
    @GetMapping("/data")
    public Map<String, Object> getData() {
        return service.getData();
    }
}