package com.javaexpress;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ThreadPoolController {

    @Async("taskExecutor")
    @GetMapping("/heavy-task")
    public CompletableFuture<String> performHeavyTask(@RequestParam(defaultValue = "30") int duration) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is processing...");
        Thread.sleep(duration * 1000); // Simulate long-running task
        return CompletableFuture.completedFuture("Task Completed!");
    }
}

