package jp.cloudace.tech.clean.demo.tasks.application.usecases.ports;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.domain.models.task.CompletedTask;


public interface ListCompletedTaskUseCaseOutputPort {
    void emitCompletedTasks(List<CompletedTask> tasks);
}
