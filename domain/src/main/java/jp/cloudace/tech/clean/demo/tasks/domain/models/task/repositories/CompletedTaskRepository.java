package jp.cloudace.tech.clean.demo.tasks.domain.models.task.repositories;


import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.domain.models.task.CompletedTask;

public interface CompletedTaskRepository {

    List<CompletedTask> listCompletedTask();

    void create(CompletedTask task);

}
