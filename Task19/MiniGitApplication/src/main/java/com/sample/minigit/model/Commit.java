package com.sample.minigit.model;

import java.time.LocalDateTime;

public class Commit {

    private int version;
    private String message;
    private String content;
    private LocalDateTime time;

    public Commit(int version, String message, String content) {
        this.version = version;
        this.message = message;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public int getVersion() { return version; }
    public String getMessage() { return message; }
    public String getContent() { return content; }
    public LocalDateTime getTime() { return time; }
}